import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;

class XmlToJsonTest {

  @Test
  public void main() throws URISyntaxException {
    try {
      String[] args = {new File(getClass().getClassLoader().getResource("edxl-de-affaire.test.xml").getFile()).getAbsolutePath()};
      XmlToJson.main(args);
    }catch (Exception e){
      e.printStackTrace();
    }
  }

}
