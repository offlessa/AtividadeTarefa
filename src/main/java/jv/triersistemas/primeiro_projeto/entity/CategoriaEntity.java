package jv.triersistemas.primeiro_projeto.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jv.triersistemas.primeiro_projeto.enums.PrioridadeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "categoria")

public class CategoriaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nome;
	private String descricao;

	@Enumerated(EnumType.ORDINAL)
	private PrioridadeEnum prioridade;
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.DETACH)
	 private List<TarefaEntity> tarefas = new ArrayList<>();
	
    public void addTarefa(TarefaEntity tarefa) {
        tarefas.add(tarefa);
        tarefa.setCategoria(this);
    }

    public void removeTarefa(TarefaEntity tarefa) {
        tarefas.remove(tarefa);
        tarefa.setCategoria(null);
    }
}




