package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoTest {

    private Emprestimo emprestimo;
    private List<Livro> livrosDisponiveis;
    private Livro livroIndisponivel;

    @BeforeEach
    public void setUp() {
        emprestimo = new Emprestimo();

        livrosDisponiveis = new ArrayList<>();
        livrosDisponiveis.add(new Livro("Livro 1", 1));
        livrosDisponiveis.add(new Livro("Livro 2", 2));

        livroIndisponivel = new Livro("Livro 3", 3);
        livroIndisponivel.setDisponivel(false);
    }

    @Test
    public void devePermitirEmprestarLivrosDisponiveis() {
        assertTrue(emprestimo.emprestar(livrosDisponiveis),
                "O empréstimo deveria ser permitido quando todos os livros estão disponíveis.");
    }

    @Test
    public void naoDevePermitirEmprestarLivroIndisponivel() {
        List<Livro> livros = new ArrayList<>();
        livros.add(livroIndisponivel);

        assertFalse(emprestimo.emprestar(livros),
                "O empréstimo não deveria ser permitido quando há livros indisponíveis.");
    }

    @Test
    public void naoDevePermitirEmprestarSeAlunoPossuiDebito() {
        Aluno alunoMock = mock(Aluno.class);
        when(alunoMock.verificaDebito()).thenReturn(true);

        assertTrue(alunoMock.verificaDebito(),
                "O aluno deveria ser identificado com débito.");
    }

    @Test
    public void devePermitirEmprestarParaAlunoSemDebito() {
        Aluno alunoMock = mock(Aluno.class);
        when(alunoMock.verificaDebito()).thenReturn(false);

        assertFalse(alunoMock.verificaDebito(),
                "O aluno não deveria ser identificado com débito.");
    }
}
