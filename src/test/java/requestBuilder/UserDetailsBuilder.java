package requestBuilder;

import entities.api.Location;
import entities.api.UserDetails;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsBuilder {

    UserDetails request;

    public UserDetailsBuilder(String employername,String username, int userId, String city, String state) {
        request = new UserDetails();
        request.setEmployer(employername);
        request.setUserName(username);
        request.setUserId(userId);
        request.setLocation(location(city,state));

    }

    public Location location(String city, String state)
    {
        Location location = new Location();
        location.setCity("ambala");
        location.setState("haryana");
        return location;

    }

    public List<UserDetails> build() {
        List<UserDetails> userDetails = new ArrayList<UserDetails>();
        userDetails.add(request);
        return userDetails;
    }
}
