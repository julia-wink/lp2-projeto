package com.cadastro.disciplinas.domain.repository;

import com.cadastro.disciplinas.domain.model.Disciplina;
import java.util.List;
import java.util.Optional;

public interface DisciplinaRepository {
    void salvar(Disciplina disciplina);
    Optional<Disciplina> buscarPorNumero(Long numero);
    List<Disciplina> listarTodas();
    void deletar(Long numero);
}
