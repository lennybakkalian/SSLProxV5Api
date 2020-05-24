package io.sslprox.packets.auth;

import io.sslprox.packets.SSLProxPacket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse extends SSLProxPacket<LoginRequest> {

  private int statusCode;
  private String msg;

}
