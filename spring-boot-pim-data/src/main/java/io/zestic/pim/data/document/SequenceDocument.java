package io.zestic.pim.data.document;

import io.zestic.core.entity.Auditable;
import io.zestic.pim.data.MongoDB;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "sequence")
public class SequenceDocument extends MongoDB implements Auditable {

  @Id
  private String id;
  private Integer sequence;
}
