package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

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
    
	private static List<TarefaDto> tarefas = new ArrayList<>();
    private static Long contadorId = 1L;
    
	@Override
	public List<TarefaDto> getTodasTarefas() {
		return tarefas;
	}
	
	@Override
	public Optional<TarefaDto> findById(Long id) {
    	return tarefas.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

	@Override
	public TarefaDto adicionarTarefa(TarefaDto novaTarefa) {
		var entidadePersistida = repository.save(new TarefaEntity(novaTarefa));
        return new TarefaDto(entidadePersistida);
	}

	@Override
	public TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada) {
		Optional<TarefaDto> tarefa = findById(id);
        if (tarefa.isPresent()) {
            tarefa.get().setTitulo(tarefaAtualizada.getTitulo());
            tarefa.get().setDescricao(tarefaAtualizada.getDescricao());
            tarefa.get().setCompleta(tarefaAtualizada.getCompleta());
            return tarefa.get();
        }
        return null;
	}

	@Override
	public void removerTarefa(Long id) {
		tarefas.removeIf(t -> t.getId().equals(id));
	}
	

}