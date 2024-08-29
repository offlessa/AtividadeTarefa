package jv.triersistemas.primeiro_projeto.entity;

import jakarta.persistence.*;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "tarefa")
public class TarefaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;
    private Boolean completa;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoriaEntity categoria;

    public TarefaEntity(TarefaDto dto) {
        this.id = dto.getId();
        this.titulo = dto.getTitulo();
        this.descricao = dto.getDescricao();
        this.completa = dto.isCompleta();
       
    }

    public void setCategoria(CategoriaEntity categoriaEntity) {
        if (this.categoria != null) {
            this.categoria.removeTarefa(this);
        }
        this.categoria = categoriaEntity;
        if (categoriaEntity != null) {
            categoriaEntity.addTarefa(this);
        }
    }
}
