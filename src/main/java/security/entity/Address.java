package security.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Embeddable
public class Address {
    @NotEmpty
    private String street;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotEmpty
    private String zipCode;

    @NotEmpty
    private String country;


}
