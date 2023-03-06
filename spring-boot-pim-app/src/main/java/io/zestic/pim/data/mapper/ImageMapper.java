package io.zestic.pim.data.mapper;

import org.mapstruct.Mapper;
import io.zestic.pim.api.product.ImageModel;
import io.zestic.pim.data.document.ImageDocument;

@Mapper
public interface ImageMapper {

  ImageModel toModel(ImageDocument source);

  ImageDocument toDocument(ImageModel model);
}
