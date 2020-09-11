package br.com.unbox.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Data
public class UserModel {

    @Id
    private String email;
    private String name;
    private String doc;
}
