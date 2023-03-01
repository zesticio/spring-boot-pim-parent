package io.zestic.pim.api.catalog;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import io.swagger.annotations.ApiModelProperty;
import io.zestic.core.entity.Auditable;
import io.zestic.core.entity.Entity;
import io.zestic.pim.api.common.PublishedScope;
import io.zestic.pim.api.product.Image;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Collection extends Entity<Integer, Collection> implements Auditable {

  @ApiModelProperty(notes = "The ID for the collection.",
      required = true)
  private Integer id;

  @ApiModelProperty(notes = "Collection code",
      required = true)
  private String code;

  @ApiModelProperty(notes = "A description of the collection, complete with HTML markup. Many templates display this on their collection pages.",
      required = true)
  private String bodyHtml;

  @ApiModelProperty(notes = "A unique, human-readable string for the collection automatically generated from its title. This is used in themes by the Liquid templating language to refer to the collection. (limit: 255 characters)",
      required = true)
  private String handle;

  @ApiModelProperty(notes = "Image associated with the collection. Valid values are:",
      required = false)
  private Image image;

  @ApiModelProperty(notes = "The time and date (ISO 8601 format) when the collection was made visible. Returns null for a hidden collection.",
      required = false)
  private Date publishedAt;

  @ApiModelProperty(notes = "Whether the collection is published to the Point of Sale channel",
      required = true)
  private String publishedScope = PublishedScope.GLOBAL.toString();

  @ApiModelProperty(notes = "The name of the collection. (limit: 255 characters)",
      required = false)
  private String title;

  @ApiModelProperty(notes = "Attributes",
      required = false)
  private List<String> attributes = new ArrayList<>();

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }
}
