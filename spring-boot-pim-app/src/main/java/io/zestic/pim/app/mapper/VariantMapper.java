package io.zestic.pim.app.mapper;

import org.mapstruct.Mapper;
import io.zestic.pim.api.product.ProductModel;
import io.zestic.pim.api.product.VariantModel;
import io.zestic.pim.data.document.ProductDocument;
import io.zestic.pim.data.document.VariantDocument;

@Mapper
public interface VariantMapper {

  VariantModel toModel(VariantDocument document);

  VariantDocument toDocument(VariantModel model);
}
