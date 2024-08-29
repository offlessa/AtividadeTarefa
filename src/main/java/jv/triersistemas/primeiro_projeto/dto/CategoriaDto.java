package jv.triersistemas.primeiro_projeto.dto;

import jv.triersistemas.primeiro_projeto.enums.PrioridadeEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaDto {
	private int id;
	private String nome;
	private String descricao;
	private PrioridadeEnum prioridade;
}
