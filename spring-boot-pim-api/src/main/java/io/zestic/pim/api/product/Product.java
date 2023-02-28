package io.zestic.pim.api.product;

import java.util.Date;
import java.util.List;
import io.zestic.core.entity.Auditable;
import io.zestic.core.entity.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Entity<Integer, Product> implements Auditable {

  @ApiModelProperty(notes = "Alpha numeric value that used as a unique identified for the product. Each id is unique across the system. No two product will have the same id even if they are from different category",
      example = "SUG1000000001",
      required = true)
  private Integer id;

  @ApiModelProperty(notes = "A description of the product. Supports HTML formatting.",
      example = "It's the small iPod with a big idea: Video.",
      required = true)
  private String bodyHtml;

  @ApiModelProperty(notes = "A unique human-friendly string for the product. Automatically generated from the product's title. Used by the Liquid templating language to refer to objects.",
      example = "ipod-nano",
      required = true)
  private String handle;

  @ApiModelProperty(notes = "A list of product image objects, each one representing an image associated with the product.",
      required = false)
  private List<Image> images;

  @ApiModelProperty(notes = "A categorization for the product used for filtering and searching products.",
      required = true)
  private String productType;

  @ApiModelProperty(notes = "The date and time (ISO 8601 format) when the product was published. Can be set to null to unpublish the product from the Online Store channel.",
      required = false)
  private Date publishedAt;

  @ApiModelProperty(notes = "Whether the product is published to the Point of Sale channel. Valid values {global / private}",
      required = true)
  private String publishedScope;

  @ApiModelProperty(notes = "The status of the product. Valid values {active, archived, draft}",
      required = true)
  private String status;

  @ApiModelProperty(notes = "A string of comma-separated tags that are used for filtering and search. A product can have up to 250 tags. Each tag can have up to 255 characters.",
      required = false)
  private List<String> tags;

  @ApiModelProperty(notes = "The name of the product.",
      required = true)
  private String title;

  @ApiModelProperty(notes = "An array of product variants, each representing a different version of the product.\n" +
      "\n" +
      "The position property is read-only. The position of variants is indicated by the order in which they are listed.",
      required = false)
  private List<Variant> variants;

  @ApiModelProperty(notes = "The name of the product's vendor.",
      required = false)
  private String vendor;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }
}
