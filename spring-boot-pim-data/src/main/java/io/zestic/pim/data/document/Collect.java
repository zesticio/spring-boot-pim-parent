package io.zestic.pim.data.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import io.swagger.annotations.ApiModelProperty;
import io.zestic.core.entity.Auditable;
import io.zestic.core.entity.Entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Document(collection = "collects")
public class Collect implements Auditable {

  @Id
  private Integer id;
  @Field("collection_id")
  private Integer collectionId;
  @Field("product_id")
  private Integer productId;

}
