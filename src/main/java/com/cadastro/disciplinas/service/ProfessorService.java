package com.cadastro.disciplinas.service;

import com.cadastro.disciplinas.domain.model.Professor;
import com.cadastro.disciplinas.domain.repository.ProfessorRepository;

public class ProfessorService {
    private final ProfessorRepository professorRepository;

    // Injeção de dependência via construtor
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrarProfessor(Professor professor) {
        // Implementar regras futuras antes de salvar
        professorRepository.salvar(professor);
    }
}
