package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Document;
import lombok.*;
import org.springframework.data.annotation.Id;

@Document("filmes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Filme {

    @Id
    private String id;

    private String titulo;

    private String genero;

    private Integer ano;

    private Double nota;
}