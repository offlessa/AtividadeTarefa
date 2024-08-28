package jv.triersistemas.primeiro_projeto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "tarefa")
public class TarefaEntity {

	public TarefaEntity(TarefaDto novaTarefa) {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String titulo;
	private String descricao;
	private String completa;

}