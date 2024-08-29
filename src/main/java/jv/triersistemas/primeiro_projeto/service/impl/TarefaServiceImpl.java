package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.TarefaService;


@Service
public class TarefaServiceImpl implements TarefaService {
	
	@Autowired
	private TarefaRepository repository;
    
	@Override
	public List<TarefaDto> getTodasTarefas() {
		return repository.findAll().stream().map(TarefaDto::new).toList();
	}
	
	@Override
	public TarefaDto findById(Long id) throws IllegalArgumentException {
		return new TarefaDto(repository.findById(id).orElseThrow(()-> new IllegalArgumentException("não foi possivel encontrar o id")));
	}
	


	@Override
	public TarefaDto adicionarTarefa(TarefaDto novaTarefa) {
        var entidadePersistida = repository.save(new TarefaEntity(novaTarefa));
		return new TarefaDto(entidadePersistida);
	}

	@Override
	public TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada) throws IllegalArgumentException {
		findById(id);
		tarefaAtualizada.setId(id);
		var entidadePersistida = repository.save(new TarefaEntity(tarefaAtualizada));
        return new TarefaDto(entidadePersistida);
	}

	@Override
	public void removerTarefa(Long id) throws IllegalArgumentException {
		findById(id);
		repository.deleteById(id);
	}





	

}