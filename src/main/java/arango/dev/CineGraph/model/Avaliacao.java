package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Edge;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Edge("avaliacoes")
public class Avaliacao {

    @Id
    private String id;

    private String _from;

    private String _to;

    private Integer nota;

    private String comentario;
}