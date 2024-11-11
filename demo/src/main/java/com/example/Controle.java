package com.example;

import java.util.List;

public class Controle {

    // Método para emprestar livros
    public boolean emprestar(String raAluno, List<Livro> livros) {
        Aluno aluno = new Aluno(raAluno);

        // Verifica se o aluno existe
        if (!aluno.verificarAluno()) {
            System.out.println("Aluno não encontrado.");
            return false;
        }

        // Verifica se o aluno possui débitos
        if (aluno.verificaDebito()) {
            System.out.println("Aluno possui débitos pendentes.");
            return false;
        }

        // Realiza o empréstimo dos livros
        return aluno.emprestar(livros);
    }
}
