package io.sslprox.packets.auth;

import io.sslprox.packets.SSLProxPacket;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest extends SSLProxPacket<LoginResponse> {

  private String username;
  private String password;

}
