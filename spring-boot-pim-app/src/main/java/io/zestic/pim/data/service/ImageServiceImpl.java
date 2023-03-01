package io.zestic.pim.data.service;

import java.util.List;
import io.zestic.core.entity.Result;
import io.zestic.pim.api.catalog.Collection;
import io.zestic.pim.api.product.Image;

public class ImageServiceImpl implements ServiceTemplate<Image> {

  @Override
  public Result<List<Image>> findAll() {
    return null;
  }

  @Override
  public Result<Void> create(Image image) {
    return null;
  }

  @Override
  public Result<Image> findById(String code) {
    return null;
  }

  @Override
  public Result<Image> update(String code, Image image) {
    return null;
  }

  @Override
  public Result<Image> delete(String code) {
    return null;
  }
}
