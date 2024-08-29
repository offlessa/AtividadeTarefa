package jv.triersistemas.primeiro_projeto.service;

import jv.triersistemas.primeiro_projeto.dto.CategoriaDto;
import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;

import java.util.List;
import java.util.Optional;

public interface CategoriaService {
    List<CategoriaEntity> findAll();
    Optional<CategoriaEntity> findById(int id);
    CategoriaEntity save(CategoriaDto dto);
    CategoriaEntity update(int id, CategoriaDto dto);
    void deleteById(int id);
}
