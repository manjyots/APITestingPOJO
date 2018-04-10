package requestBuilder;

import entities.api.Location;
import entities.api.UserDetails;

public class UserDetailsBuilder {

    UserDetails request;

    public UserDetailsBuilder() {
        request = new UserDetails();
        request.setEmployer("jindal Steels");
        request.setUserName("Rocky");
        request.setLocation(new Location("haryana","Ambala"));



    }

    public UserDetails build()
    {
        return request;
    }
}
