package io.zestic.pim.app.service;

import java.util.List;
import java.util.Optional;
import io.zestic.core.entity.Result;
import io.zestic.pim.api.exception.ApplicationErrorImpl;

public interface ServiceInterface<S, D> {

  Result<List<S>> findAll(Optional<Integer> page, Optional<Integer> limit);

  Result<S> create(S s);

  Result<S> findById(String code);

  Result<S> update(String code, S s);

  Result<S> delete(String code);

  void copy(S s, D d);

  default void onDataNotFound(Result result) {
    result.setCode(ApplicationErrorImpl.NOT_FOUND.getCode());
    result.setMessage(ApplicationErrorImpl.NOT_FOUND.getMessage());
  }

  default void onBadRequest(Result result) {
    result.setCode(ApplicationErrorImpl.BAD_REQUEST.getCode());
    result.setMessage(ApplicationErrorImpl.BAD_REQUEST.getMessage());
  }

  default void onMethodNotAllowed(Result result) {
    result.setCode(ApplicationErrorImpl.METHOD_NOT_ALLOWED.getCode());
    result.setMessage(ApplicationErrorImpl.METHOD_NOT_ALLOWED.getMessage());
  }

  default void onDuplicate(Result result) {
    result.setCode(ApplicationErrorImpl.DUPLICATE.getCode());
    result.setMessage(ApplicationErrorImpl.DUPLICATE.getMessage());
  }

  default void onInternalServerError(Result result) {
    result.setCode(ApplicationErrorImpl.INTERNAL_SERVER_ERROR.getCode());
    result.setMessage(ApplicationErrorImpl.INTERNAL_SERVER_ERROR.getMessage());
  }

  default void onUnauthorized(Result result) {
    result.setCode(ApplicationErrorImpl.UNAUTHORIZED.getCode());
    result.setMessage(ApplicationErrorImpl.UNAUTHORIZED.getMessage());
  }
}
