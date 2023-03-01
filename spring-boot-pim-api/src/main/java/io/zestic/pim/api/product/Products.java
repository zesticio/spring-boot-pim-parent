package io.zestic.pim.api.product;

import java.util.List;
import io.zestic.core.entity.Auditable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Products implements Auditable {

  private List<Product> products;

}
