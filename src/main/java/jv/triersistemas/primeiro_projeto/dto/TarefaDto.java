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
	private String completa;

	public TarefaDto(TarefaEntity dto) {
		this.id = dto.getId();
		this.titulo = dto.getTitulo();
		this.descricao = dto.getDescricao();
		this.completa = dto.getCompleta();
	}

	public TarefaDto(Object entidadePersistida) {

	}
}