package io.zestic.pim.data.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.apache.commons.lang3.math.NumberUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import io.zestic.core.entity.Result;
import io.zestic.pim.api.common.Constants;
import io.zestic.pim.api.product.ImageHttpStatus;
import io.zestic.pim.api.product.ImageModel;
import io.zestic.pim.data.document.ImageDocument;
import io.zestic.pim.data.mapper.ImageMapper;
import io.zestic.pim.data.repository.ImageRepository;
import io.zestic.pim.data.service.ServiceInterface;

@Service
public class ImageServiceImpl implements ServiceInterface<ImageModel, ImageDocument> {

  private ImageRepository repository;

  public ImageServiceImpl(ImageRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<List<ImageModel>> findAll(Optional<Integer> page, Optional<Integer> limit) {
    Result<List<ImageModel>> result = new Result<>(ImageHttpStatus.SUCCESS.getCode(), ImageHttpStatus.SUCCESS.getMessage());
    Pageable pageable = null;
    if (!page.isPresent()) {
      page = Optional.of(1);
    }
    if (!limit.isPresent()) {
      limit = Optional.of(Constants.DEFAULT_LIMIT);
    }
    pageable = PageRequest.of(page.get(), limit.get());
    Page<ImageDocument> temp = repository.findAll(pageable);
    temp.getTotalPages();

    List<ImageModel> list = new ArrayList<>();
    temp.get().collect(Collectors.toList()).forEach(collection -> {
      ImageMapper instance = Mappers.getMapper(ImageMapper.class);
      list.add(instance.toModel(collection));
    });
    result.setData(list);
    return result;
  }

  @Override
  public Result<ImageModel> create(ImageModel model) {
    Result<ImageModel> result = new Result<>(ImageHttpStatus.SUCCESS.getCode(), ImageHttpStatus.SUCCESS.getMessage());
    ImageMapper instance = Mappers.getMapper(ImageMapper.class);
    result.setData(instance.toModel(repository.save(instance.toDocument(model))));
    return result;
  }

  @Override
  public Result<ImageModel> findById(String code) {
    Result<ImageModel> result = new Result<>(ImageHttpStatus.SUCCESS.getCode(), ImageHttpStatus.SUCCESS.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<ImageDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          ImageDocument document = collection.get();
          ImageMapper instance = Mappers.getMapper(ImageMapper.class);
          result.setData(instance.toModel(document));
        } else {
          onDataNotFound(result);
        }
      } else {
        onDataNotFound(result);
      }
    } else {
      onBadRequest(result);
    }
    return result;
  }

  @Override
  public Result<ImageModel> update(String code, ImageModel model) {
    Result<ImageModel> result = new Result<>(ImageHttpStatus.SUCCESS.getCode(), ImageHttpStatus.SUCCESS.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<ImageDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          ImageDocument document = collection.get();
          copy(model, document);
          ImageMapper instance = Mappers.getMapper(ImageMapper.class);
          result.setData(instance.toModel(repository.save(document)));
        } else {
          onDataNotFound(result);
        }
      } else {
        onDataNotFound(result);
      }
    } else {
      onBadRequest(result);
    }
    return result;
  }

  @Override
  public Result<ImageModel> delete(String code) {
    Result<ImageModel> result = new Result<>(ImageHttpStatus.SUCCESS.getCode(), ImageHttpStatus.SUCCESS.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        repository.deleteById(Integer.parseInt(code));
      } else {
        onDataNotFound(result);
      }
    } else {
      onBadRequest(result);
    }
    return result;
  }

  @Override
  public void copy(ImageModel model, ImageDocument document) {
    document.setModifiedAt(new Date(System.currentTimeMillis()));
  }
}
