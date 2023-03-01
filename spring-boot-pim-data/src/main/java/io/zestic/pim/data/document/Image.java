package io.zestic.pim.data.document;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import io.zestic.core.entity.Auditable;
import lombok.Data;

@Data
@Document(collection = "images")
public class Image implements Auditable {

  @Id
  private Integer id;
  private Integer position;
  @Field("product_id")
  private String productId;
  @Field("variant_ids")
  private List<String> variantIds;
  private String src;
  private Double width;
  private Double height;
}
