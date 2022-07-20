package tech.mdelgado.cclient.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(collection = "client")
public class Client {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String birthDay;
    private String probableDateDeath;

    public Client(String firstName, String lastName, Integer age, String birthDay, String probableDateDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthDay = birthDay;
        this.probableDateDeath = probableDateDeath;
    }
}
