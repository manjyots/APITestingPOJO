package entities.api;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Location {

    private String state;
    private String city;

    public Location(String state , String city)
    {
        this.state=state;
        this.city=city;
    }

}
