package com.example;

import java.util.List;

public class Emprestimo {

    public boolean emprestar(List<Livro> livros) {
        for (Livro livro : livros) {
            if (!livro.isDisponivel()) {
                System.out.println("Livro " + livro.getTitulo() + " não está disponível.");
                return false;
            }
            livro.setDisponivel(false);
        }
        return true;
    }
}
