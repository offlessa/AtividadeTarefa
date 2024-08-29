package jv.triersistemas.primeiro_projeto.dto;

import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TarefaDto {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean completa;
    private Integer categoriaId; 

    public TarefaDto(TarefaEntity entity) {
        this.id = entity.getId();
        this.titulo = entity.getTitulo();
        this.descricao = entity.getDescricao();
        this.completa = entity.getCompleta();
        if (entity.getCategoria() != null) {
            this.categoriaId = entity.getCategoria().getId(); 
        }
    }
}
