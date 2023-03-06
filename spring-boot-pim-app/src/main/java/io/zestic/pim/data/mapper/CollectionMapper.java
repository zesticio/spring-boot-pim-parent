package io.zestic.pim.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import io.zestic.pim.api.catalog.CollectionModel;
import io.zestic.pim.data.document.CollectionDocument;

@Mapper
public interface CollectionMapper {

  @Mapping(target="id", source="document.id")
  @Mapping(target="code", source="document.code")
  @Mapping(target="bodyHtml", source="document.bodyHtml")
  @Mapping(target="handle", source="document.handle")
  @Mapping(target="image", source="document.image")
  @Mapping(target="publishedAt", source="document.publishedAt")
  @Mapping(target="publishedScope", source="document.publishedScope")
  @Mapping(target="title", source="document.title")
  @Mapping(target="attributes", source="document.attributes")
  CollectionModel toModel(CollectionDocument document);

  @Mapping(target="id", source="model.id")
  @Mapping(target="code", source="model.code")
  @Mapping(target="bodyHtml", source="model.bodyHtml")
  @Mapping(target="handle", source="model.handle")
  @Mapping(target="image", source="model.image")
  @Mapping(target="publishedAt", source="model.publishedAt")
  @Mapping(target="publishedScope", source="model.publishedScope")
  @Mapping(target="title", source="model.title")
  @Mapping(target="attributes", source="model.attributes")
  CollectionDocument toDocument(CollectionModel model);
}
