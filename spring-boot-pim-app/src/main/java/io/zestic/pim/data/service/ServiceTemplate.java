package io.zestic.pim.data.service;

import java.util.List;
import io.zestic.core.entity.Result;

public interface ServiceTemplate<T> {

  Result<List<T>> findAll();

  Result<Void> create(T t);

  Result<T> findById(String code);

  Result<T> update(String code, T t);

  Result<T> delete(String code);
}
