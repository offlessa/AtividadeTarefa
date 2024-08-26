package jv.triersistemas.primeiro_projeto.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jv.triersistemas.primeiro_projeto.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
	private static List<Tarefa> tarefas = new ArrayList<>();
	private static long contador = 1;

	@PostMapping
	public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
		tarefa.setId(contador++);
		tarefas.add(tarefa);
		return tarefa;
	}

	@GetMapping
	public List<Tarefa> listarTarefas() {
		return tarefas;
	}

	@GetMapping("/{id}")
	public Tarefa obterTarefa(@PathVariable Long id) {
		for (Tarefa tarefa : tarefas) {
			if (tarefa.getId().equals(id)) {
				return tarefa;
			}
		}
		return null;
	}

	@PutMapping("/{id}")
	public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa novaTarefa) {
		Tarefa tarefa = obterTarefa(id);
		if (tarefa != null) {
			tarefa.setTitulo(novaTarefa.getTitulo());
			tarefa.setDescricao(novaTarefa.getDescricao());
			tarefa.setCompleta(novaTarefa.isCompleta());
			return tarefa;
		}
		return null;
	}

	@DeleteMapping("/{id}")
	public String deletarTarefa(@PathVariable Long id) {
		for (Tarefa t : tarefas) {
			if (t.getId().equals(id)) {
				tarefas.remove(t);
				return "Tarefa deletada com sucesso";
			}
		}
		return "Tarefa não encontrada";
	}
}
