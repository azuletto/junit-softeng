package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.ArrayList;

public class EmprestimoTest {

    @Test
    public void testEmprestarLivrosDisponiveis() {
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro("Livro 1", 1));
        livros.add(new Livro("Livro 2", 2));

        Emprestimo emprestimo = new Emprestimo();
        assertTrue(emprestimo.emprestar(livros));
    }

    @Test
    public void testEmprestarLivroIndisponivel() {
        List<Livro> livros = new ArrayList<>();
        Livro livro = new Livro("Livro 1", 1);
        livro.setDisponivel(false);
        livros.add(livro);

        Emprestimo emprestimo = new Emprestimo();
        assertFalse(emprestimo.emprestar(livros));
    }

    @Test
    public void testAlunoComDebito() {
        Aluno aluno = new Aluno("10");
        assertTrue(aluno.verificaDebito());
    }
}
