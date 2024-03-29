package io.zestic.pim.app.service;

import io.zestic.core.entity.Result;
import io.zestic.pim.api.catalog.CollectionModel;
import io.zestic.pim.api.common.Constants;
import io.zestic.pim.api.exception.ApplicationErrorImpl;
import io.zestic.pim.api.exception.BadRequestException;
import io.zestic.pim.api.exception.DataNotFoundException;
import io.zestic.pim.app.mapper.CollectionMapper;
import io.zestic.pim.data.document.CollectionDocument;
import io.zestic.pim.data.repository.CollectionRepository;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CollectionServiceImpl implements ServiceInterface<CollectionModel, CollectionDocument> {

    final private CollectionRepository repository;

    public CollectionServiceImpl(CollectionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Result<List<CollectionModel>> findAll(Optional<Integer> page, Optional<Integer> limit) {
        Result<List<CollectionModel>> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());
        if (!page.isPresent()) {
            page = Optional.of(1);
        }
        if (!limit.isPresent()) {
            limit = Optional.of(Constants.DEFAULT_LIMIT);
        }
        Pageable pageable = PageRequest.of(page.get(), limit.get());
        Page<CollectionDocument> temp = repository.findAll(pageable);
        temp.getTotalPages();

        List<CollectionModel> list = new ArrayList<>();
        temp.get().collect(Collectors.toList()).forEach(collection -> {
            CollectionMapper instance = Mappers.getMapper(CollectionMapper.class);
            list.add(instance.toModel(collection));
        });
        result.setData(list);
        return result;
    }

    @Override
    public Result<CollectionModel> create(CollectionModel model) {
        Result<CollectionModel> result = new Result<>(ApplicationErrorImpl.CREATED.getCode(), ApplicationErrorImpl.CREATED.getMessage());
        CollectionMapper instance = Mappers.getMapper(CollectionMapper.class);
        result.setData(instance.toModel(repository.save(instance.toDocument(model))));
        return result;
    }

    @Override
    public Result<CollectionModel> findById(String code) {
        Result<CollectionModel> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());
        if (NumberUtils.isParsable(code)) {
            if (repository.existsById(Integer.parseInt(code))) {
                Optional<CollectionDocument> collection = repository.findById(Integer.parseInt(code));
                if (collection.isPresent()) {
                    CollectionDocument document = collection.get();
                    CollectionMapper instance = Mappers.getMapper(CollectionMapper.class);
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
    public Result<CollectionModel> update(String code, CollectionModel model) {
        Result<CollectionModel> result = new Result<>(ApplicationErrorImpl.CREATED.getCode(), ApplicationErrorImpl.CREATED.getMessage());
        if (NumberUtils.isParsable(code)) {
            if (repository.existsById(Integer.parseInt(code))) {
                Optional<CollectionDocument> collection = repository.findById(Integer.parseInt(code));
                if (collection.isPresent()) {
                    CollectionDocument document = collection.get();
                    copy(model, document);
                    CollectionMapper instance = Mappers.getMapper(CollectionMapper.class);
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
    public Result<CollectionModel> delete(String code) {
        Result<CollectionModel> result = new Result<>(ApplicationErrorImpl.SUCCESS.getCode(), ApplicationErrorImpl.SUCCESS.getMessage());

        if (!NumberUtils.isParsable(code)) {
            throw new BadRequestException(ApplicationErrorImpl.BAD_REQUEST);
        }

        if (repository.existsById(Integer.parseInt(code))) {
            repository.deleteById(Integer.parseInt(code));
        } else {
            onDataNotFound(result);
            throw new DataNotFoundException(ApplicationErrorImpl.NOT_FOUND);
        }

        return result;
    }

    @Override
    public void copy(CollectionModel model, CollectionDocument document) {
        if (StringUtils.isNotBlank(model.getBodyHtml())) {
            document.setBodyHtml(model.getBodyHtml());
        }
        if (StringUtils.isNotBlank(model.getHandle())) {
            document.setHandle(model.getHandle());
        }
        if (StringUtils.isNotBlank(model.getTitle())) {
            document.setTitle(model.getTitle());
        }
        if (StringUtils.isNotBlank(model.getPublishedScope())) {
            document.setPublishedScope(model.getTitle());
        }
        if (model.getAttributes() != null) {
            document.setAttributes(model.getAttributes());
        }
        document.setModifiedAt(new Date(System.currentTimeMillis()));
    }
}
