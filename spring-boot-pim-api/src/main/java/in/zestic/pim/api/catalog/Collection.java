package in.zestic.pim.api.catalog;

import java.util.Date;
import java.util.List;
import in.zestic.core.entity.Auditable;
import in.zestic.core.entity.Entity;
import in.zestic.pim.api.product.Image;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Collection extends Entity<Integer, Collection> implements Auditable {

  @ApiModelProperty(notes = "The ID for the collection.",
      required = false)
  private Integer id;

  @ApiModelProperty(notes = "A description of the collection, complete with HTML markup. Many templates display this on their collection pages.",
      required = false)
  private String bodyHtml;

  @ApiModelProperty(notes = "A unique, human-readable string for the collection automatically generated from its title. This is used in themes by the Liquid templating language to refer to the collection. (limit: 255 characters)",
      required = false)
  private String handle;

  @ApiModelProperty(notes = "Image associated with the collection. Valid values are:",
      required = false)
  private Image image;

  @ApiModelProperty(notes = "The time and date (ISO 8601 format) when the collection was made visible. Returns null for a hidden collection.",
      required = false)
  private Date publishedAt;

  @ApiModelProperty(notes = "Whether the collection is published to the Point of Sale channel",
      required = false)
  private String publishedScope;

  @ApiModelProperty(notes = "The name of the collection. (limit: 255 characters)",
      required = false)
  private String title;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }
}
