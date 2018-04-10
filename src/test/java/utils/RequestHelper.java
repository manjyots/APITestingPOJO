package utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;

public class RequestHelper {

    public static String asString(Object o) {
        if (Properties.contentType.equals("application/json")) {
            return getJsonString(o);
        }
        return getXMLString(o);
    }

    private static String getJsonString(Object o) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL);

        try {
            return objectMapper.writeValueAsString(o);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String getXMLString(Object o) {
        try {
            JAXBContext context = JAXBContext.newInstance(o.getClass());

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            final StringWriter stringWriter = new StringWriter();

            m.marshal(o, stringWriter);
            String xmlString = stringWriter.toString();
            return xmlString.substring(xmlString.indexOf('\n') + 1);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return "";
    }


}
