package io.zestic.pim.data.service;

import java.util.List;
import java.util.Optional;
import io.zestic.core.entity.Result;
import io.zestic.pim.api.product.Variant;

public class VariantServiceImpl implements ServiceTemplate<Variant> {

  @Override
  public Result<List<Variant>> findAll(Optional<Integer> page, Optional<Integer> limit) {
    return null;
  }

  @Override
  public Result<Void> create(Variant variant) {
    return null;
  }

  @Override
  public Result<Variant> findById(String code) {
    return null;
  }

  @Override
  public Result<Variant> update(String code, Variant variant) {
    return null;
  }

  @Override
  public Result<Variant> delete(String code) {
    return null;
  }
}
