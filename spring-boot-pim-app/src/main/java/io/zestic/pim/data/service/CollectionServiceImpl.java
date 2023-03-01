package io.zestic.pim.data.service;

import java.util.List;
import io.zestic.core.entity.Result;
import io.zestic.pim.api.catalog.Collection;

public class CollectionServiceImpl implements ServiceTemplate<Collection> {

  @Override
  public Result<List<Collection>> findAll() {
    return null;
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
