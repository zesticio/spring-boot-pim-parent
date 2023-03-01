package io.zestic.pim.data.document;

import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import io.zestic.core.entity.Auditable;
import io.zestic.pim.api.product.Image;
import io.zestic.pim.api.product.Variant;
import lombok.Data;

@Data
@Document(collection = "products")
public class Product implements Auditable {

  @Id
  private Integer id;
  @Field("body_html")
  private String bodyHtml;
  private String handle;
  private List<Image> images;
  @Field("product_types")
  private String productType;
  @Field("published_at")
  private Date publishedAt;
  @Field("published_scope")
  private String publishedScope;
  private String status;
  private List<String> tags;
  private String title;
  private List<Variant> variants;
  private String vendor;
}
