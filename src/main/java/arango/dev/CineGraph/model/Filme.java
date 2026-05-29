package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Document;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Document("filmes")
public class Filme {

    @Id
    private String id;

    private String titulo;

    private String genero;

    private Integer ano;

    private Double nota;
}