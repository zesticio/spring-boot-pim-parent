package io.zestic.pim.data.service;

import java.util.List;
import java.util.Optional;
import io.zestic.core.entity.Result;
import io.zestic.pim.api.catalog.CollectionHttpStatus;

public interface ServiceInterface<S, D> {

  Result<List<S>> findAll(Optional<Integer> page, Optional<Integer> limit);

  Result<S> create(S s);

  Result<S> findById(String code);

  Result<S> update(String code, S s);

  Result<S> delete(String code);

  void copy(S s, D d);

  default void onDataNotFound(Result result) {
    result.setCode(CollectionHttpStatus.NOT_FOUND.getCode());
    result.setMessage(CollectionHttpStatus.NOT_FOUND.getMessage());
  }

  default void onBadRequest(Result result) {
    result.setCode(CollectionHttpStatus.BAD_REQUEST.getCode());
    result.setMessage(CollectionHttpStatus.BAD_REQUEST.getMessage());
  }

  default void onMethodNotAllowed(Result result) {
    result.setCode(CollectionHttpStatus.METHOD_NOT_ALLOWED.getCode());
    result.setMessage(CollectionHttpStatus.METHOD_NOT_ALLOWED.getMessage());
  }

  default void onDuplicate(Result result) {
    result.setCode(CollectionHttpStatus.DUPLICATE.getCode());
    result.setMessage(CollectionHttpStatus.DUPLICATE.getMessage());
  }

  default void onInternalServerError(Result result) {
    result.setCode(CollectionHttpStatus.INTERNAL_SERVER_ERROR.getCode());
    result.setMessage(CollectionHttpStatus.INTERNAL_SERVER_ERROR.getMessage());
  }

  default void onUnauthorized(Result result) {
    result.setCode(CollectionHttpStatus.UNAUTHORIZED.getCode());
    result.setMessage(CollectionHttpStatus.UNAUTHORIZED.getMessage());
  }
}
