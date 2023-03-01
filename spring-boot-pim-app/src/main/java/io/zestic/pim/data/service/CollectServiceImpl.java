package io.zestic.pim.data.service;

import java.util.List;
import io.zestic.core.entity.Result;
import io.zestic.pim.data.document.Collect;
import io.zestic.pim.data.repository.CollectRepository;

public class CollectServiceImpl implements ServiceTemplate<Collect> {

  private CollectRepository repository;

  public CollectServiceImpl(CollectRepository repository) {
    this.repository = repository;
  }

  @Override
  public Result<List<Collect>> findAll() {
    return null;
  }

  @Override
  public Result<Void> create(Collect collect) {
    return null;
  }

  @Override
  public Result<Collect> findById(String code) {
    return null;
  }

  @Override
  public Result<Collect> update(String code, Collect collect) {
    return null;
  }

  @Override
  public Result<Collect> delete(String code) {
    return null;
  }
}
