package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Document;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank
    private String titulo;

    @NotBlank
    private String genero;

    @NotNull
    @Min(1888)
    @Max(2030)
    private Integer ano;
}