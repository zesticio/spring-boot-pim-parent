package io.zestic.pim.api.product;

import java.util.List;
import io.zestic.core.entity.Auditable;
import lombok.Data;

@Data
public class ImagesModel implements Auditable {

  private List<ProductModel> images;
}
