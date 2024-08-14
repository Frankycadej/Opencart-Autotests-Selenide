package models;

import lombok.Data;

@Data
public class User {

    private final String password;
    private final String email;
    private final String firstname;
    private final String lastname;

}
