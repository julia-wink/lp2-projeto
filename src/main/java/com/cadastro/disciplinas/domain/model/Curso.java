package com.cadastro.disciplinas.domain.model;

public class Curso {
    private Long codigo;
    private String nome;
    private String descricao;

    public Curso(Long codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters
    public Long getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public String getDescricao() { return descricao; }

    // Setters
    public void setCodigo(Long codigo) { this.codigo = codigo; }
    public void setNome(String nome) { this.nome = nome; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
