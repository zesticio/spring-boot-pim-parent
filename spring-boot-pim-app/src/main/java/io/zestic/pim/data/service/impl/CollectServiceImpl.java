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
import io.zestic.pim.api.catalog.CollectHttpStatus;
import io.zestic.pim.api.catalog.CollectModel;
import io.zestic.pim.api.common.Constants;
import io.zestic.pim.data.document.CollectDocument;
import io.zestic.pim.data.document.CollectionDocument;
import io.zestic.pim.data.mapper.CollectMapper;
import io.zestic.pim.data.mapper.CollectionMapper;
import io.zestic.pim.data.repository.CollectRepository;
import io.zestic.pim.data.service.ServiceInterface;

@Service
public class CollectServiceImpl implements ServiceInterface<CollectModel, CollectDocument> {

  private CollectRepository repository;

  public CollectServiceImpl(CollectRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<List<CollectModel>> findAll(Optional<Integer> page, Optional<Integer> limit) {
    Result<List<CollectModel>> result = new Result<>(CollectHttpStatus.SUCCESS.getCode(), CollectHttpStatus.SUCCESS.getMessage());
    Pageable pageable = null;
    if (!page.isPresent()) {
      page = Optional.of(1);
    }
    if (!limit.isPresent()) {
      limit = Optional.of(Constants.DEFAULT_LIMIT);
    }
    pageable = PageRequest.of(page.get(), limit.get());
    Page<CollectDocument> temp = repository.findAll(pageable);
    temp.getTotalPages();

    List<CollectModel> list = new ArrayList<>();
    temp.get().collect(Collectors.toList()).forEach(collect -> {
      CollectMapper instance = Mappers.getMapper(CollectMapper.class);
      list.add(instance.toModel(collect));
    });
    result.setData(list);
    return result;
  }

  @Override
  public Result<CollectModel> create(CollectModel model) {
    Result<CollectModel> result = new Result<>(CollectHttpStatus.CREATED.getCode(), CollectHttpStatus.CREATED.getMessage());
    CollectMapper instance = Mappers.getMapper(CollectMapper.class);
    result.setData(instance.toModel(repository.save(instance.toDocument(model))));
    return result;
  }

  @Override
  public Result<CollectModel> findById(String code) {
    Result<CollectModel> result = new Result<>(CollectHttpStatus.CREATED.getCode(), CollectHttpStatus.CREATED.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<CollectDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          CollectDocument document = collection.get();
          CollectMapper instance = Mappers.getMapper(CollectMapper.class);
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
  public Result<CollectModel> update(String code, CollectModel model) {
    Result<CollectModel> result = new Result<>(CollectHttpStatus.CREATED.getCode(), CollectHttpStatus.CREATED.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<CollectDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          CollectDocument document = collection.get();
          copy(model, document);
          CollectMapper instance = Mappers.getMapper(CollectMapper.class);
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
  public Result<CollectModel> delete(String code) {
    Result<CollectModel> result = new Result<>(CollectHttpStatus.CREATED.getCode(), CollectHttpStatus.CREATED.getMessage());
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
  public void copy(CollectModel model, CollectDocument document) {
    document.setModifiedAt(new Date(System.currentTimeMillis()));
  }
}
