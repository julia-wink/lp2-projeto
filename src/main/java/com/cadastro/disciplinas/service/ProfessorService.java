package com.cadastro.disciplinas.service;

import com.cadastro.disciplinas.domain.model.Professor;
import com.cadastro.disciplinas.domain.repository.ProfessorRepository;

public class ProfessorService implements ProfessorRepository{
    private final ProfessorRepository professorRepository;

    // Injeção de dependência via construtor
    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public void cadastrarProfessor(Professor professor) {
        // Implementar regras futuras antes de salvar
        professorRepository.salvar(professor);
    }

    @Override
    public void salvar(Professor professor){
        professores.add(professor); 
    }

    @Override
    public void buscarPorCodigo(Long codigoFuncional){
        for (Professor p : professores){
            if(p.getCodigoFuncional().equals(codigoFuncional)){
                System.out.println("Professor " + p.getNome() + " encontrado");
            }
        }
    }

     @Override
    public void listarTodos(){
        for (Professor p : professores){
            System.out.println("Professor " + p.getNome() + "\n");
        }
    }

     @Override
    public void deletar(Long codigoFuncional){
        Iterator<Professor> iterator = professores.iterator();

        while (iterator.hasNext()) {
            Professor p = iterator.next();
            if (p.getCodigoFuncional().equals(codigoFuncional)) {
                iterator.remove();
                System.out.println("Professor removido com sucesso!");
                return;
            }
        }
            System.out.println("Professor não encontrado.");
        }
    }
