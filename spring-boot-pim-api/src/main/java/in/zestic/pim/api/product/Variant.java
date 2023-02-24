package in.zestic.pim.api.product;

import in.zestic.core.entity.Auditable;
import in.zestic.core.entity.Entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Variant extends Entity<Integer, Variant> implements Auditable {

  @ApiModelProperty(notes = "The unique numeric identifier for the product variant.",
      required = true)
  private Integer id;

  @ApiModelProperty(notes = "The barcode, UPC, or ISBN number for the product.",
      required = true)
  private String barcode;

  @ApiModelProperty(notes = "The original price of the item before an adjustment or a sale.",
      required = true)
  private Double compareAtPrice;

  @ApiModelProperty(notes = "The handle of a fulfillment service that stocks a product variant.\n" +
      "This is the handle of a third-party fulfillment service if the following conditions are met:\n" +
      "\n" +
      "The product variant is stocked by a single fulfillment service.\n" +
      "The FulfillmentService is a third-party fulfillment service. Third-party fulfillment services don't have a handle with the value manual.\n" +
      "The fulfillment service hasn't opted into SKU sharing.\n" +
      "If the conditions aren't met, then this is manual.\n" +
      "The relationship between a product variant and a fulfillment service was changed in the 2022-07 API version. A ProductVariant can be stocked by multiple fulfillment services. As a result, we recommend that you use the InventoryLevel resource if you need to determine where a product variant is stocked.\n" +
      "\n" +
      "If you previously set this field, then we recommend that you instead connect an inventory item to a location. Each Location is associated with a single FulfillmentService. The value of this field after setting it will be as described above.\n" +
      "\n" +
      "If you need to determine whether a product is a gift card, then you should continue to use this field until an alternative is available",
      required = true)
  private String fulfillmentService;

  @ApiModelProperty(notes = "The weight of the product variant in grams.",
      required = true)
  private String grams;

  @ApiModelProperty(notes = "The unique numeric identifier for a product's image. The image must be associated to the same product as the variant.",
      required = true)
  private Integer imageId;

  @ApiModelProperty(notes = "The unique identifier for the inventory item, which is used in the Inventory API to query for inventory information.",
      required = true)
  private Integer inventoryItemId;

  @ApiModelProperty(notes = "The fulfillment service that tracks the number of items in stock for the product variant. Valid values:",
      required = true)
  private String inventoryManagement;

  @ApiModelProperty(notes = "Whether customers are allowed to place an order for the product variant when it's out of stock. Valid values:",
      required = true)
  private String inventoryPolicy;

  @ApiModelProperty(notes = "An aggregate of inventory across all locations. To adjust inventory at a specific location, use the InventoryLevel resource.",
      required = true)
  private Integer inventoryQuantity;

  @ApiModelProperty(notes = "This property is deprecated. Use the InventoryLevel resource instead.",
      required = true)
  private Integer oldInventoryQuantity;

  @ApiModelProperty(notes = "This property is deprecated. Use the InventoryLevel resource instead.",
      required = true)
  private Integer inventoryQuantityAdjustment;

  @ApiModelProperty(notes = "The price of the product variant.",
      required = true)
  private Double price;

  @ApiModelProperty(notes = "The unique numeric identifier for the product.",
      required = true)
  private Integer productId;

  @ApiModelProperty(notes = "A unique identifier for the product variant in the shop. Required in order to connect to a FulfillmentService.",
      required = true)
  private String sku;

  @ApiModelProperty(notes = "Whether a tax is charged when the product variant is sold.\n",
      required = true)
  private Boolean taxable;

  @ApiModelProperty(notes = "This parameter applies only to the stores that have the Avalara AvaTax app installed. Specifies the Avalara tax code for the product variant.",
      required = true)
  private String taxCode;

  @ApiModelProperty(notes = "The title of the product variant. The title field is a concatenation of the option1, option2, and option3 fields. You can only update title indirectly using the option fields.",
      required = true)
  private String title;

  @ApiModelProperty(notes = "The weight of the product variant in the unit system specified with weight_unit.",
      required = true)
  private String weight;

  @ApiModelProperty(notes = "The unit of measurement that applies to the product variant's weight. If you don't specify a value for weight_unit, then the shop's default unit of measurement is applied. Valid values: g, kg, oz, and lb.",
      required = true)
  private String weightUnit;


  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }
}
