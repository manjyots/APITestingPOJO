package entities.api;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@EqualsAndHashCode
public class UserDetails {

    private Location location;

    private int userId;

    private String employer;

    private String userName;


}
