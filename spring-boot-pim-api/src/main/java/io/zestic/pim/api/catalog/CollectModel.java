package io.zestic.pim.api.catalog;

import io.swagger.annotations.ApiModelProperty;
import io.zestic.core.entity.Auditable;
import io.zestic.core.entity.Model;
import lombok.Builder;
import lombok.Data;

@Data
public class CollectModel extends Model<Integer, CollectModel> implements Auditable {

    @ApiModelProperty(notes = "A unique numeric identifier for the collect.",
            required = false)
    private Integer id;

    @ApiModelProperty(notes = "The ID of the custom collection containing the product.",
            required = false)
    private Integer collectionId;

    @ApiModelProperty(notes = "The unique numeric identifier for the product in the custom collection.",
            required = false)
    private Integer productId;

    @Builder
    public CollectModel(Integer id, Integer collectionId, Integer productId) {
        this.id = id;
        this.collectionId = collectionId;
        this.productId = productId;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }
}
