import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import oasis.names.tc.emergency.edxl.de._2.DEDistributionType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.nio.file.Paths;

public class XmlToJson {
  public static void main(String[] args) throws JAXBException, JsonProcessingException {
    String filePath = args[0];
    JAXBContext jaxbContext = JAXBContext.newInstance(DEDistributionType.class);
    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
    long start = System.currentTimeMillis();
    DEDistributionType deDistributionType = (DEDistributionType) ((JAXBElement)jaxbUnmarshaller.unmarshal(Paths.get(filePath).toFile())).getValue();
    long end = System.currentTimeMillis();
    ObjectMapper objectMapper = new ObjectMapper();
    String json = objectMapper.writeValueAsString(deDistributionType);
    long endJson = System.currentTimeMillis();
    System.out.println("parsing time "+(end - start)+"ms");
    System.out.println("json time "+(endJson - end)+"ms");
    System.out.println("total time "+(endJson - start)+"ms");
    System.out.println("json" + json);
  }
}
