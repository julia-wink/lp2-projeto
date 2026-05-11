package com.cadastro.disciplinas.domain.repository;

import com.cadastro.disciplinas.domain.model.Curso;
import java.util.List;
import java.util.Optional;

public interface CursoRepository {
    void salvar(Curso curso);
    Optional<Curso> buscarPorCodigo(Long codigo);
    List<Curso> listarTodos();
    void deletar(Long codigo);
}
