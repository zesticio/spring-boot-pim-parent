package io.zestic.pim.data.service;

import java.util.List;
import io.zestic.core.entity.Result;
import io.zestic.pim.api.product.Product;

public class ProductServiceImpl implements ServiceTemplate<Product> {

  @Override
  public Result<List<Product>> findAll() {
    return null;
  }

  @Override
  public Result<Void> create(Product image) {
    return null;
  }

  @Override
  public Result<Product> findById(String code) {
    return null;
  }

  @Override
  public Result<Product> update(String code, Product product) {
    return null;
  }

  @Override
  public Result<Product> delete(String code) {
    return null;
  }
}
