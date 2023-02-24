package in.zestic.pim.api.product;

import java.util.List;
import in.zestic.core.entity.Auditable;
import in.zestic.core.entity.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Products implements Auditable {

  private List<Product> products;

}
