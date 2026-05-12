package trabFinal;

import java.util.ArrayList;
import java.util.Iterator;

public class ProfessorRepository {
    private ArrayList<Professor> professores = new ArrayList<Professor>();
    
    public void salvar(Professor professor){
        professores.add(professor);
    }

    public void buscarPorCodigo(Long codigoFuncional){
        for (Professor p : professores){
            if(p.getCodigoFuncional().equals(codigoFuncional)){
                System.out.println("Professor " + p.getNome() + " encontrado");
            }
        }
    }

    public void listarTodos(){
        for (Professor p : professores){
            System.out.println("Professor " + p.getNome() + "\n");
        }
    }

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
