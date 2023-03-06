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
import io.zestic.pim.api.product.ProductHttpStatus;
import io.zestic.pim.api.product.ProductModel;
import io.zestic.pim.data.document.ImageDocument;
import io.zestic.pim.data.document.ProductDocument;
import io.zestic.pim.data.mapper.ImageMapper;
import io.zestic.pim.data.mapper.ProductMapper;
import io.zestic.pim.data.repository.ProductRepository;
import io.zestic.pim.data.service.ServiceInterface;

@Service
public class ProductServiceImpl implements ServiceInterface<ProductModel, ProductDocument> {

  private ProductRepository repository;

  public ProductServiceImpl(ProductRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<List<ProductModel>> findAll(Optional<Integer> page, Optional<Integer> limit) {
    Result<List<ProductModel>> result = new Result<>(ProductHttpStatus.SUCCESS.getCode(), ProductHttpStatus.SUCCESS.getMessage());
    Pageable pageable = null;
    if (!page.isPresent()) {
      page = Optional.of(1);
    }
    if (!limit.isPresent()) {
      limit = Optional.of(Constants.DEFAULT_LIMIT);
    }
    pageable = PageRequest.of(page.get(), limit.get());
    Page<ProductDocument> temp = repository.findAll(pageable);
    temp.getTotalPages();

    List<ProductModel> list = new ArrayList<>();
    temp.get().collect(Collectors.toList()).forEach(collection -> {
      ProductMapper instance = Mappers.getMapper(ProductMapper.class);
      list.add(instance.toModel(collection));
    });
    result.setData(list);
    return result;
  }

  @Override
  public Result<ProductModel> create(ProductModel model) {
    Result<ProductModel> result = new Result<>(ProductHttpStatus.SUCCESS.getCode(), ProductHttpStatus.SUCCESS.getMessage());
    ProductMapper instance = Mappers.getMapper(ProductMapper.class);
    result.setData(instance.toModel(repository.save(instance.toDocument(model))));
    return result;
  }

  @Override
  public Result<ProductModel> findById(String code) {
    Result<ProductModel> result = new Result<>(ProductHttpStatus.SUCCESS.getCode(), ProductHttpStatus.SUCCESS.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<ProductDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          ProductDocument document = collection.get();
          ProductMapper instance = Mappers.getMapper(ProductMapper.class);
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
  public Result<ProductModel> update(String code, ProductModel model) {
    Result<ProductModel> result = new Result<>(ProductHttpStatus.SUCCESS.getCode(), ProductHttpStatus.SUCCESS.getMessage());
    if (NumberUtils.isParsable(code)) {
      if (repository.existsById(Integer.parseInt(code))) {
        Optional<ProductDocument> collection = repository.findById(Integer.parseInt(code));
        if (collection.isPresent()) {
          ProductDocument document = collection.get();
          copy(model, document);
          ProductMapper instance = Mappers.getMapper(ProductMapper.class);
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
  public Result<ProductModel> delete(String code) {
    Result<ProductModel> result = new Result<>(ProductHttpStatus.SUCCESS.getCode(), ProductHttpStatus.SUCCESS.getMessage());
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
  public void copy(ProductModel model, ProductDocument document) {
    document.setModifiedAt(new Date(System.currentTimeMillis()));
  }
}
