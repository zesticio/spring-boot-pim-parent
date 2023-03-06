package io.zestic.pim.data.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import io.zestic.core.entity.Auditable;
import io.zestic.pim.data.MongoDB;
import lombok.Data;

@Data
@Document(collection = "documents")
public class VariantDocument extends MongoDB implements Auditable {

  @Id
  private Integer id;
  private String barcode;
  @Field("compare_at_price")
  private Double compareAtPrice;
  @Field("fullfillment_service")
  private String fulfillmentService;
  private String grams;
  @Field("image_id")
  private Integer imageId;
  @Field("inventory_item_id")
  private Integer inventoryItemId;
  @Field("inventory_management")
  private String inventoryManagement;
  @Field("inventory_policy")
  private String inventoryPolicy;
  @Field("inventory_quantity")
  private Integer inventoryQuantity;
  @Field("old_inventory_quantity")
  private Integer oldInventoryQuantity;
  @Field("inventory_quantity_adjustment")
  private Integer inventoryQuantityAdjustment;
  private Double price;
  @Field("product_id")
  private Integer productId;
  private String sku;
  private Boolean taxable;
  @Field("tax_code")
  private String taxCode;
  private String title;
  private String weight;
  @Field("weight_unit")
  private String weightUnit;
}
