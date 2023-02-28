package io.zestic.pim.api.product;

import java.util.List;
import io.zestic.core.entity.Auditable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Images implements Auditable {

  private List<Product> images;

}
