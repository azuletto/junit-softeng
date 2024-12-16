package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class ControleTest {

    private Controle controle;
    private List<Livro> livros;

    @BeforeEach
    public void setUp() {
        controle = new Controle();
        livros = new ArrayList<>();
        livros.add(new Livro("Livro 1", 1));
        livros.add(new Livro("Livro 2", 2));
    }

    @Test
    public void testEmprestimo_QuandoAlunoValidoSemDebitoEComLivrosDisponiveis_DeveSerPermitido() {
        Aluno aluno = new Aluno("1");
        for (Livro livro : livros) {
            livro.setDisponivel(true);
        }
        assertTrue(controle.emprestar(aluno.getRa(), livros),
            "Empréstimo deveria ser permitido para aluno válido sem débitos e com livros disponíveis.");
    }

    @Test
    public void testEmprestimo_QuandoAlunoInvalido_DeveSerNegado() {
        Aluno aluno = new Aluno("10"); // "10" representa um aluno inválido no método `verificarAluno()`
        assertFalse(controle.emprestar(aluno.getRa(), livros),
            "Empréstimo não deveria ser permitido para aluno inválido.");
    }

    @Test
    public void testEmprestimo_QuandoAlunoComDebito_DeveSerNegado() {
        Aluno aluno = new Aluno("10"); // Representando um RA que possui débito
        assertTrue(aluno.verificaDebito(), "Aluno com RA '10' deveria possuir débitos.");
        assertFalse(controle.emprestar(aluno.getRa(), livros),
            "Empréstimo não deveria ser permitido para aluno com débitos.");
    }

    @Test
    public void testEmprestimo_QuandoLivroIndisponivel_DeveSerNegado() {
        livros.get(0).setDisponivel(false); // Primeiro livro está indisponível
        assertFalse(controle.emprestar("1", livros),
            "Empréstimo não deveria ser permitido se algum livro está indisponível.");
    }

    @Test
    public void testEmprestimo_QuandoListaLivrosVazia_DeveSerNegado() {
        List<Livro> livrosVazios = new ArrayList<>();
        assertFalse(controle.emprestar("1", livrosVazios),
            "Empréstimo não deveria ser permitido com lista de livros vazia.");
    }

    @Test
    public void testEmprestimo_QuandoTodosLivrosDisponiveis_DeveSerPermitido() {
        for (Livro livro : livros) {
            livro.setDisponivel(true);
        }
        assertTrue(controle.emprestar("1", livros),
            "Empréstimo deveria ser permitido quando todos os livros estão disponíveis.");
    }
}
