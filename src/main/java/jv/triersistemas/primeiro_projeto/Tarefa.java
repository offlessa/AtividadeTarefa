package jv.triersistemas.primeiro_projeto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean completa;

}
