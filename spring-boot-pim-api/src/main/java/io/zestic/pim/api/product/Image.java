package io.zestic.pim.api.product;

import java.util.List;
import io.zestic.core.entity.Auditable;
import io.zestic.core.entity.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Image extends Entity<Integer, Image> implements Auditable {

  @ApiModelProperty(notes = "A unique numeric identifier for the product image.",
      required = false)
  private Integer id;

  @ApiModelProperty(notes = "The order of the product image in the list. The first product image is at position 1 and is the \"main\" image for the product.",
      required = false)
  private Integer position;

  @ApiModelProperty(notes = "The id of the product associated with the image.",
      required = false)
  private String productId;

  @ApiModelProperty(notes = "An array of variant ids associated with the image.",
      required = false)
  private List<String> variantIds;

  @ApiModelProperty(notes = "Specifies the location of the product image. This parameter supports Liquid filters that you can use to retrieve modified copies of the image.",
      required = false)
  private String src;

  @ApiModelProperty(notes = "Width dimension of the image which is determined on upload.",
      required = false)
  private Double width;

  @ApiModelProperty(notes = "Height dimension of the image which is determined on upload.",
      required = false)
  private Double height;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }
}
