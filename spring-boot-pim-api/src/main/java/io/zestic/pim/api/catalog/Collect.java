package io.zestic.pim.api.catalog;

import io.zestic.core.entity.Auditable;
import io.zestic.core.entity.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Collect extends Entity<Integer, Collect> implements Auditable {

  @ApiModelProperty(notes = "A unique numeric identifier for the collect.",
      required = false)
  private Integer id;

  @ApiModelProperty(notes = "The ID of the custom collection containing the product.",
      required = false)
  private Integer collectionId;

  @ApiModelProperty(notes = "The unique numeric identifier for the product in the custom collection.",
      required = false)
  private Integer productId;

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }
}
