package security.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Entity()
public class Venue {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Event> events;


}
