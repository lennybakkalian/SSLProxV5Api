package io.sslprox.packets;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerializedPacket {
  private Object data;
  private String clazz;
}
