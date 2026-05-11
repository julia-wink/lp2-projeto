package com.cadastro.disciplinas.service;

import com.cadastro.disciplinas.domain.model.Disciplina;
import com.cadastro.disciplinas.domain.repository.DisciplinaRepository;
import java.time.LocalDate;

public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    // Injeção de dependência via construtor
    public DisciplinaService(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public void registrarDisciplina(Disciplina disciplina) {
        // R4: Validando a data de início através da lógica de negócio na própria entidade
        disciplina.validarDataInicio(LocalDate.now());
        
        disciplinaRepository.salvar(disciplina);
    }
}
