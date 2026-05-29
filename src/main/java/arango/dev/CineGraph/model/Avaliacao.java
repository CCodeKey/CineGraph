package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Document;
import lombok.*;
import org.springframework.data.annotation.Id;

@Document("avaliacoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Avaliacao {

    @Id
    private String id;

    private String comentario;

    private Integer nota;

    private String usuarioId;

    private String filmeId;
}