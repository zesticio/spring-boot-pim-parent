package io.zestic.pim.app.mapper;

import org.mapstruct.Mapper;
import io.zestic.pim.api.product.ProductModel;
import io.zestic.pim.data.document.ProductDocument;

@Mapper
public interface ProductMapper {

  ProductModel toModel(ProductDocument source);

  ProductDocument toDocument(ProductModel model);
}
