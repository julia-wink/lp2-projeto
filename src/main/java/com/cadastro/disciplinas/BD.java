package com.cadastro.disciplinas;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.cadastro.disciplinas.domain.model.Curso;
import com.cadastro.disciplinas.domain.model.Disciplina;
import com.cadastro.disciplinas.domain.model.Professor;
import com.cadastro.disciplinas.domain.repository.CursoRepository;
import com.cadastro.disciplinas.domain.repository.DisciplinaRepository;
import com.cadastro.disciplinas.domain.repository.ProfessorRepository;

public class BD implements ProfessorRepository, CursoRepository, DisciplinaRepository{
   
   @Override
   public void salvarProfessor(Professor professor) {
        
        String sql = "INSERT INTO professor (codigo_funcional, nome, data_nascimento) VALUES (?, ?, ?)";
    
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, professor.getCodigoFuncional());
            pstmt.setString(2, professor.getNome());
            pstmt.setDate(3, Date.valueOf(professor.getDataNascimento())); 
            pstmt.executeUpdate(); 
            System.out.println("Inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir professor: " + e.getMessage(), e);
        }
   }
   
   @Override
   public Optional<Professor> buscarPorCodigoProfessor(Long codigoFuncional){
        
        String sql = "SELECT * FROM professor WHERE codigo_funcional = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, codigoFuncional);
            try (ResultSet rs = stmt.executeQuery()){
            
                if(rs.next()){
                    Long codigo = rs.getLong("codigo_funcional");
                    String nome = rs.getString("nome");
                    LocalDate dataNasc = rs.getDate("data_nascimento").toLocalDate();
                    Professor professor = new Professor(codigo, nome, dataNasc);
                    return Optional.of(professor);
                } else return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar professor: " + e.getMessage(), e);
        }
    }

   @Override
   public List<Professor> listarTodosProfessores(){
    
        String sql = "SELECT * FROM professor";
        ArrayList<Professor> professores = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long codigoFuncional = rs.getLong("codigo_funcional");
                String nome = rs.getString("nome");
                LocalDate dataNasc = rs.getDate("data_nascimento").toLocalDate();
                Professor professor = new Professor(codigoFuncional, nome, dataNasc);
                professores.add(professor);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar professores", e);
        }
        return professores;
   }

   @Override
   public void deletarProfessor(Long codigoFuncional){
        String sql = "DELETE FROM professor WHERE codigo_funcional = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, codigoFuncional);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhum professor encontrado com o código: " + codigoFuncional);
            } else {
                System.out.println("Professor deletado com sucesso!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar professor com o código: " + codigoFuncional, e);
        }
   }

   @Override
   public void salvarCurso(Curso curso) {
        
        String sql = "INSERT INTO curso (codigo, nome, descricao) VALUES (?, ?, ?)";
    
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, curso.getCodigo());
            pstmt.setString(2, curso.getNome());
            pstmt.setString(3, curso.getDescricao()); 
            pstmt.executeUpdate(); 
            System.out.println("Inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir curso: " + e.getMessage(), e);
        }
   }
   
   @Override
   public Optional<Curso> buscarPorCodigoCurso(Long codigo){
        
        String sql = "SELECT * FROM curso WHERE codigo = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, codigo);
            try (ResultSet rs = stmt.executeQuery()){
            
                if(rs.next()){
                    Long cd = rs.getLong("codigo");
                    String nome = rs.getString("nome");
                    String descricao = rs.getString("descricao");
                    Curso curso = new Curso(cd, nome, descricao);
                    return Optional.of(curso);
                } else return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar curso: " + e.getMessage(), e);
        }
    }

   @Override
   public List<Curso> listarTodosCursos(){
    
        String sql = "SELECT * FROM curso";
        ArrayList<Curso> cursos = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long codigo = rs.getLong("codigo");
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                Curso curso = new Curso(codigo, nome, descricao);
                cursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar cursos", e);
        }
        return cursos;
   }

   @Override
   public void deletarCurso(Long codigo){
        String sql = "DELETE FROM curso WHERE codigo = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, codigo);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhum curso encontrado com o código: " + codigo);
            } else {
                System.out.println("Curso deletado com sucesso!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar curso com o código: " + codigo, e);
        }
   }

      @Override
   public void salvarDisciplina(Disciplina disciplina) {
        
        String sql = "INSERT INTO disciplina (numero, nome, data_inicio, data_encerramento, codigo_professor, codigo_curso) VALUES (?, ?, ?, ?, ?, ?)";
    
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setLong(1, disciplina.getNumero());
            pstmt.setString(2, disciplina.getNome());
            pstmt.setDate(3, Date.valueOf(disciplina.getDataInicio()));
            pstmt.setDate(4, Date.valueOf(disciplina.getDataEncerramento())); 
            pstmt.setLong(5, disciplina.getProfessor().getCodigoFuncional());
            pstmt.setLong(6, disciplina.getCurso().getCodigo());  

            pstmt.executeUpdate(); 
            System.out.println("Inserido com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir disciplina: " + e.getMessage(), e);
        }
   }
   
   @Override
   public Optional<Disciplina> buscarPorNumeroDisciplina(Long numero){
        
        String sql = "SELECT * FROM disciplina WHERE numero = ?";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setLong(1, numero);
            try (ResultSet rs = stmt.executeQuery()){
            
                if(rs.next()){
                    Long nro = rs.getLong("numero");
                    String nome = rs.getString("nome");
                    LocalDate dataInicio = rs.getDate("data_inicio").toLocalDate();
                    LocalDate dataEncerramento = rs.getDate("data_encerramento").toLocalDate();

                    Disciplina disciplina = new Disciplina(null, null, null, null, null, null);
                    Professor codigoProfessor = new Professor(null, null, null);
                    codigoProfessor.setCodigoFuncional(rs.getLong("codigo_professor"));
                    disciplina.setProfessor(codigoProfessor);

                    Curso codigoCurso = new Curso(null, null, null);
                    codigoCurso.setCodigo(rs.getLong("codigo_curso"));
                    disciplina.setCurso(codigoCurso);
                    
                    disciplina = new Disciplina (nro, nome, dataInicio, dataEncerramento, codigoProfessor, codigoCurso);
                    return Optional.of(disciplina);
                } else return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar disciplina: " + e.getMessage(), e);
        }
    }

   @Override
   public List<Disciplina> listarTodasDisciplinas(){
    
        String sql = "SELECT * FROM disciplina";
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        try (PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Long nro = rs.getLong("numero");
                String nome = rs.getString("nome");
                LocalDate dataInicio = rs.getDate("data_inicio").toLocalDate();
                LocalDate dataEncerramento = rs.getDate("data_encerramento").toLocalDate();

                Disciplina disciplina = new Disciplina(null, null, null, null, null, null);
                Professor codigoProfessor = new Professor(null, null, null);
                codigoProfessor.setCodigoFuncional(rs.getLong("codigo_professor"));
                disciplina.setProfessor(codigoProfessor);

                Curso codigoCurso = new Curso(null, null, null);
                codigoCurso.setCodigo(rs.getLong("codigo_curso"));
                disciplina.setCurso(codigoCurso);
                    
                disciplina = new Disciplina (nro, nome, dataInicio, dataEncerramento, codigoProfessor, codigoCurso);
                disciplinas.add(disciplina);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar disciplinas", e);
        }
        return disciplinas;
   }

   @Override
   public void deletarDisciplina(Long numero){
        String sql = "DELETE FROM disciplina WHERE numero = ?";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setLong(1, numero);
            int linhasAfetadas = stmt.executeUpdate();

            if (linhasAfetadas == 0) {
                System.out.println("Nenhuma disciplina encontrada com o número: " + numero);
            } else {
                System.out.println("Disciplina deletada com sucesso!");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar disciplina com o número: " + numero, e);
        }
   }
}
