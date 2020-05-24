import io.sslprox.SSLProxApi;
import io.sslprox.packets.auth.LoginRequest;
import java.net.URI;

public class SSLProxApiTest {

  public static void main(String[] args){
    try{
      SSLProxApi api = new SSLProxApi(new URI("ws://localhost:2222"));
      api.connect();

      LoginRequest req = new LoginRequest("test", "secretpw");
      req.setCallback(c -> {
        System.out.println("got callback");
      });
      api.send(req);
    }catch(Exception e){
      e.printStackTrace();
    }
  }

}
