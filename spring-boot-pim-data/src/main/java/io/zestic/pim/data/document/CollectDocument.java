package io.zestic.pim.data.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import io.zestic.core.entity.Auditable;
import io.zestic.pim.data.MongoDB;
import lombok.Data;

@Data
@Document(collection = "collects")
public class CollectDocument extends MongoDB implements Auditable {

  @Id
  private Integer id;
  @Field("collection_id")
  private Integer collectionId;
  @Field("product_id")
  private Integer productId;

}
