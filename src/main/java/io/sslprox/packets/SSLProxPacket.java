package io.sslprox.packets;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class SSLProxPacket<T extends SSLProxPacket> {

  @Getter
  @Setter
  private UUID uuid;

  @JsonIgnore
  @Getter
  private SSLProxPacketCallback<T> callback;

  public void setCallback(SSLProxPacketCallback callback){
    this.callback = callback;
    this.uuid = UUID.randomUUID();
  }


  public interface SSLProxPacketCallback<T>{
    void callback(T data);
  }

}
