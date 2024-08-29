package jv.triersistemas.primeiro_projeto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.entity.TarefaEntity;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.repository.TarefaRepository;
import jv.triersistemas.primeiro_projeto.service.TarefaService;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    @Override
    public List<TarefaDto> getTodasTarefas() {
        return repository.findAll().stream().map(TarefaDto::new).toList();
    }

    @Override
    public TarefaDto findById(Long id) throws IllegalArgumentException {
        return new TarefaDto(repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Não foi possível encontrar o ID")));
    }

    @Override
    public TarefaDto adicionarTarefa(TarefaDto novaTarefa) {
        CategoriaEntity categoria = categoriaService.findById(novaTarefa.getCategoriaId())
            .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        TarefaEntity tarefaEntity = new TarefaEntity(novaTarefa);
        tarefaEntity.setCategoria(categoria);

        TarefaEntity entidadePersistida = repository.save(tarefaEntity);
        return new TarefaDto(entidadePersistida);
    }

    @Override
    public TarefaDto atualizarTarefa(Long id, TarefaDto tarefaAtualizada) throws IllegalArgumentException {
        TarefaDto tarefaExistente = findById(id);

        CategoriaEntity categoria = categoriaService.findById(tarefaAtualizada.getCategoriaId())
            .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));

        tarefaAtualizada.setId(id);
        TarefaEntity tarefaEntity = new TarefaEntity(tarefaAtualizada);
        tarefaEntity.setCategoria(categoria);

        TarefaEntity entidadePersistida = repository.save(tarefaEntity);
        return new TarefaDto(entidadePersistida);
    }

    @Override
    public void removerTarefa(Long id) throws IllegalArgumentException {
        findById(id);
        repository.deleteById(id);
    }
}
