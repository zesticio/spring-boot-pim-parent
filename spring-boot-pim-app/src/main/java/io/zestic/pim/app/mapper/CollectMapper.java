package io.zestic.pim.app.mapper;

import org.mapstruct.Mapper;
import io.zestic.pim.api.catalog.CollectModel;
import io.zestic.pim.data.document.CollectDocument;

@Mapper
public interface CollectMapper {

  CollectModel toModel(CollectDocument source);

  CollectDocument toDocument(CollectModel model);
}
