package com.cadastro.disciplinas.domain.repository;

import com.cadastro.disciplinas.domain.model.Professor;
import java.util.List;
import java.util.Optional;

public interface ProfessorRepository {
    void salvar(Professor professor);
    Optional<Professor> buscarPorCodigo(Long codigoFuncional);
    List<Professor> listarTodos();
    void deletar(Long codigoFuncional);
}
