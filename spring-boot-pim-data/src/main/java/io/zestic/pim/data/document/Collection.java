package io.zestic.pim.data.document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import io.zestic.core.entity.Auditable;
import io.zestic.pim.api.common.PublishedScope;
import io.zestic.pim.api.product.Image;
import lombok.Data;

@Data
@Document(collection = "collections")
public class Collection implements Auditable {

  @Id
  private Integer id;
  private String code;
  @Field("body_html")
  private String bodyHtml;
  private String handle;
  private Image image;
  @Field("published_at")
  private Date publishedAt;
  @Field("published_scope")
  private String publishedScope = PublishedScope.GLOBAL.toString();
  private String title;
  private List<String> attributes = new ArrayList<>();
}
