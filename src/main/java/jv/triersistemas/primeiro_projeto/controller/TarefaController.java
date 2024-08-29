package jv.triersistemas.primeiro_projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jv.triersistemas.primeiro_projeto.dto.TarefaDto;
import jv.triersistemas.primeiro_projeto.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping
	public List<TarefaDto> getTodasTarefas() {
		return tarefaService.getTodasTarefas();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getTarefaPorId(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(tarefaService.findById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@PostMapping
	public TarefaDto adicionarTarefa(@RequestBody TarefaDto novaTarefa) {
		return tarefaService.adicionarTarefa(novaTarefa);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarTarefa(@PathVariable Long id, @RequestBody TarefaDto tarefaAtualizada) {
		try {
			return ResponseEntity.ok(tarefaService.atualizarTarefa(id, tarefaAtualizada));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removerTarefa(@PathVariable Long id) {
		try {
			tarefaService.removerTarefa(id);
			return ResponseEntity.ok().body("{\n	\"result\" : \"" + id + " removido com sucesso\" \n}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}

}