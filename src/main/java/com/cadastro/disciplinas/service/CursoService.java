package com.cadastro.disciplinas.service;

import com.cadastro.disciplinas.domain.model.Curso;
import com.cadastro.disciplinas.domain.repository.CursoRepository;

public class CursoService {
    private final CursoRepository cursoRepository;

    // Injeção de dependência via construtor
    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public void cadastrarCurso(Curso curso) {
        // Implementar regras futuras antes de salvar
        cursoRepository.salvar(curso);
    }
}
