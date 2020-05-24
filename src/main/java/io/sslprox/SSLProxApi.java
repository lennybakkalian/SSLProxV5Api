package io.sslprox;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.sslprox.events.EmptyEvent;
import io.sslprox.packets.SSLProxPacket;
import io.sslprox.packets.SerializedPacket;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

public class SSLProxApi extends WebSocketClient{

  private List<SSLProxPacket> callbackPackets = new ArrayList<>();

  private ObjectMapper objectMapper = new ObjectMapper();

  @Setter
  private EmptyEvent connectionClosedEvent;

  public SSLProxApi(URI serverUri) {
    super(serverUri);
  }

  @Override
  public void onOpen(ServerHandshake serverHandshake) {
    System.out.println("connected");
  }

  @Override
  public void onMessage(String s) {

  }

  @Override
  public void onClose(int i, String s, boolean b) {
    System.out.println("error: " + s);
  }

  @Override
  public void onError(Exception e) {
    e.printStackTrace();
  }

  public void send(SSLProxPacket packet) throws Exception {
    if(packet == null) return;
    if(packet.getCallback() != null) registerCallbackPacket(packet);

    SerializedPacket serializedPacket = new SerializedPacket(packet, packet.getClass().getCanonicalName());
    System.out.println(objectMapper.writeValueAsString(serializedPacket));
    send(objectMapper.writeValueAsString(serializedPacket));
  }

  public void registerCallbackPacket(SSLProxPacket packet){
    this.callbackPackets.add(packet);
  }

  public void unregisterCallbackPacket(SSLProxPacket packet){
    this.callbackPackets.remove(packet);
  }
}
