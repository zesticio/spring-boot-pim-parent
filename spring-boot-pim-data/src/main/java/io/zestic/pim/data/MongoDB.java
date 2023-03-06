package io.zestic.pim.data;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MongoDB implements Serializable {

  @JsonProperty("version")
  private Long version;
  @JsonProperty("created_at")
  private Date createdAt;
  @JsonProperty("modified_at")
  private Date modifiedAt;

}
