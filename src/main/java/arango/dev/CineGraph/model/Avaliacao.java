package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Document;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String comentario;

    @NotNull
    @Min(1)
    @Max(10)
    private Integer nota;

    @NotBlank
    private String usuarioId;

    @NotBlank
    private String filmeId;
}