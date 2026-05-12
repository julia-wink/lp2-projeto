package trabFinal;

import java.time.LocalDate;

public class Professor {
    private Long codigoFuncional;
    private String nome;
    private LocalDate dataNascimento;

    public Professor(Long codigoFuncional, String nome, LocalDate dataNascimento) {
        this.codigoFuncional = codigoFuncional;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }
    public Long getCodigoFuncional() {
        return codigoFuncional;
    }
    public void setCodigoFuncional(Long codigoFuncional) {
        this.codigoFuncional = codigoFuncional;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    
}
