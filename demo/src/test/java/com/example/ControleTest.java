package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


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
    public void testEmprestimoPermitido() {
        Aluno aluno = mock(Aluno.class);
        when(aluno.verificaDebito()).thenReturn(false);

        assertTrue(controle.emprestar(aluno.getRa(), livros),
            "O empréstimo deveria ser permitido para aluno válido sem débitos.");
    }

    @Test
    public void testEmprestimoNegadoAlunoInvalido() {
        Aluno aluno = mock(Aluno.class);
        when(aluno.getRa()).thenReturn("10"); // Simulando um RA inválido

        assertFalse(controle.emprestar(aluno.getRa(), livros),
            "O empréstimo deveria ser negado para aluno inválido.");
    }

    @Test
    public void testEmprestimoNegadoAlunoComDebito() {
        Aluno aluno = mock(Aluno.class);
        when(aluno.verificaDebito()).thenReturn(true);

        assertFalse(controle.emprestar(aluno.getRa(), livros),
            "O empréstimo deveria ser negado para aluno com débitos.");
    }

    @Test
    public void testEmprestimoNegadoLivroIndisponivel() {
        livros.get(0).setDisponivel(false);

        assertFalse(controle.emprestar("1", livros),
            "O empréstimo deveria ser negado se algum livro está indisponível.");
    }

    @Test
    public void testEmprestimoNegadoListaVazia() {
        List<Livro> livrosVazios = new ArrayList<>();

        assertFalse(controle.emprestar("1", livrosVazios),
            "O empréstimo deveria ser negado para uma lista de livros vazia.");
    }

    @Test
    public void testEmprestimoTodosLivrosDisponiveis() {
        for (Livro livro : livros) {
            livro.setDisponivel(true);
        }

        assertTrue(controle.emprestar("1", livros),
            "O empréstimo deveria ser permitido quando todos os livros estão disponíveis.");
    }
}
