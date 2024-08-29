package jv.triersistemas.primeiro_projeto.service.impl;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import jv.triersistemas.primeiro_projeto.repository.CategoriaRepository;
import jv.triersistemas.primeiro_projeto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<CategoriaEntity> findAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public Optional<CategoriaEntity> findById(int id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public CategoriaEntity save(CategoriaDto dto) {
		CategoriaEntity categoria = new CategoriaEntity();
		categoria.setNome(dto.getNome());
		categoria.setDescricao(dto.getDescricao());
		categoria.setPrioridade(dto.getPrioridade());
		return categoriaRepository.save(categoria);
	}

	@Override
	public CategoriaEntity update(int id, CategoriaDto dto) {
		Optional<CategoriaEntity> existingCategoria = categoriaRepository.findById(id);
		if (existingCategoria.isPresent()) {
			CategoriaEntity categoria = existingCategoria.get();
			categoria.setNome(dto.getNome());
			categoria.setDescricao(dto.getDescricao());
			categoria.setPrioridade(dto.getPrioridade());
			return categoriaRepository.save(categoria);
		}
		return null;
	}

	@Override
	public void deleteById(int id) {
		categoriaRepository.deleteById(id);
	}
}
