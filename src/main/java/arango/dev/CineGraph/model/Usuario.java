package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Document;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Document("usuarios")
public class Usuario {

    @Id
    private String id;

    private String nome;

    private Integer idade;

    private String email;
}