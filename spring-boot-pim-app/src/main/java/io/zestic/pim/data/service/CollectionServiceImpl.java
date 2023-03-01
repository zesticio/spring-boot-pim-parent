package io.zestic.pim.data.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import io.zestic.core.entity.Result;
import io.zestic.core.util.HTTPErrorCodes;
import io.zestic.pim.api.catalog.Collection;
import io.zestic.pim.api.common.Constants;
import io.zestic.pim.data.repository.CollectionRepository;

public class CollectionServiceImpl implements ServiceTemplate<Collection> {

  private CollectionRepository repository;

  public CollectionServiceImpl(CollectionRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<List<Collection>> findAll(Optional<Integer> page, Optional<Integer> limit) {
    Result<List<Collection>> result = new Result<>(HTTPErrorCodes.SUCCESS.getCode(), HTTPErrorCodes.SUCCESS.getMessage());
    Pageable pageable = null;
    if (!page.isPresent()) {
      page = Optional.of(1);
    }
    if (!limit.isPresent()) {
      limit = Optional.of(Constants.DEFAULT_LIMIT);
    }
    pageable = PageRequest.of(page.get(), limit.get());
    Page<io.zestic.pim.data.document.Collection> temp = repository.findAll(pageable);
    temp.getTotalPages();

    List<Collection> list = new ArrayList<>();
    temp.get().collect(Collectors.toList()).forEach(collection -> {

    });
    result.setData(list);
    return result;
  }

  @Override
  public Result<Void> create(Collection collection) {
    return null;
  }

  @Override
  public Result<Collection> findById(String code) {
    return null;
  }

  @Override
  public Result<Collection> update(String code, Collection collection) {
    return null;
  }

  @Override
  public Result<Collection> delete(String code) {
    return null;
  }
}
