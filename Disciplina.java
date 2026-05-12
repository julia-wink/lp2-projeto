package trabFinal;

import java.time.LocalDate;

public class Disciplina {
    private Long numero;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataEncerramento;
    private Professor professor;
    private Curso curso;

    public boolean validarDataInicio(LocalDate dataInicio, LocalDate dataEncerramento){
        return dataEncerramento.isAfter(dataInicio);
    }
}
