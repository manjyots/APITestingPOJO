package utils;

import entities.api.UserDetails;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

public class ResponseHelper {

    public static Object getResponseObject(String responseString, Class responseClass) throws IOException {
        if (Properties.contentType.equals("application/xml")) {
            try {
                final JAXBContext context = JAXBContext.newInstance(responseClass);
                final Unmarshaller unmarshaller = context.createUnmarshaller();

                return unmarshaller.unmarshal(new StringReader(responseString));
            } catch (JAXBException e) {
                e.printStackTrace();
            }
        } else {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(responseString, responseClass);
        }

        return null;
    }

    public static List<UserDetails> getListOfApiResponseObjects(String responseString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserDetails> myObjects = mapper.readValue(responseString,
                new TypeReference<List<UserDetails>>() {
                });
        return myObjects;
    }

}
