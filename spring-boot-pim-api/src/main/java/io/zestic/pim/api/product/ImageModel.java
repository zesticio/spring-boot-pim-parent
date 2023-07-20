package io.zestic.pim.api.product;

import io.swagger.annotations.ApiModelProperty;
import io.zestic.core.entity.Auditable;
import io.zestic.core.entity.Model;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class ImageModel extends Model<Integer, ImageModel> implements Auditable {

    @ApiModelProperty(notes = "A unique numeric identifier for the product image.",
            required = false)
    private Integer id;

    @ApiModelProperty(notes = "The order of the product image in the list. The first product image is at position 1 and is the \"main\" image for the product.",
            required = false)
    private Integer position;

    @ApiModelProperty(notes = "The id of the product associated with the image.",
            required = false)
    private Integer productId;

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

    @Builder
    public ImageModel(Integer id, Integer position, Integer productId, List<String> variantIds, String src, Double width, Double height) {
        this.id = id;
        this.position = position;
        this.productId = productId;
        this.variantIds = variantIds;
        this.src = src;
        this.width = width;
        this.height = height;
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
