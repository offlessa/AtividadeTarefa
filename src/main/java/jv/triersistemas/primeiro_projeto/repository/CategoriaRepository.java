package jv.triersistemas.primeiro_projeto.repository;

import jv.triersistemas.primeiro_projeto.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Integer> {
}
