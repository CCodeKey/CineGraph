package arango.dev.CineGraph.model;

import com.arangodb.springframework.annotation.Document;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@Document("usuarios")
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    private String id;

    @NotBlank
    private String nome;

    @NotNull
    @Min(0)
    private Integer idade;

    @Email
    @NotBlank
    private String email;
}