package io.zestic.pim.app.service;

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
import io.zestic.pim.api.exception.ApplicationErrorImpl;
import io.zestic.pim.api.product.VariantModel;
import io.zestic.pim.app.mapper.VariantMapper;
import io.zestic.pim.data.document.VariantDocument;
import io.zestic.pim.data.repository.VariantRepository;

@Service
public class VariantServiceImpl implements ServiceInterface<VariantModel, VariantDocument> {

  private VariantRepository repository;

  public VariantServiceImpl(VariantRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<List<VariantModel>> findAll(Optional<Integer> page, Optional<Integer> limit) {
    Result<List<VariantModel>> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());
    Pageable pageable = null;
    if (!page.isPresent()) {
      page = Optional.of(1);
    }
    if (!limit.isPresent()) {
      limit = Optional.of(Constants.DEFAULT_LIMIT);
    }
    pageable = PageRequest.of(page.get(), limit.get());
    Page<VariantDocument> temp = repository.findAll(pageable);
    temp.getTotalPages();

    List<VariantModel> list = new ArrayList<>();
    temp.get().collect(Collectors.toList()).forEach(collection -> {
      VariantMapper instance = Mappers.getMapper(VariantMapper.class);
      list.add(instance.toModel(collection));
    });
    result.setData(list);
    return result;
  }

  @Override
  public Result<VariantModel> create(VariantModel model) {
    Result<VariantModel> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());
    VariantMapper instance = Mappers.getMapper(VariantMapper.class);
    result.setData(instance.toModel(repository.save(instance.toDocument(model))));
    return result;
  }

  @Override
  public Result<VariantModel> findById(String code) {
    Result<VariantModel> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<VariantDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          VariantDocument document = collection.get();
          VariantMapper instance = Mappers.getMapper(VariantMapper.class);
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
  public Result<VariantModel> update(String code, VariantModel model) {
    Result<VariantModel> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<VariantDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          VariantDocument document = collection.get();
          copy(model, document);
          VariantMapper instance = Mappers.getMapper(VariantMapper.class);
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
  public Result<VariantModel> delete(String code) {
    Result<VariantModel> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());
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
  public void copy(VariantModel model, VariantDocument document) {
    document.setModifiedAt(new Date(System.currentTimeMillis()));
  }
}
