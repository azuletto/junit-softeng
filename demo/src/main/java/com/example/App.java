package com.example;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o RA do Aluno: ");
        String raAluno = entrada.nextLine();

        System.out.print("Digite o número de livros a serem emprestados: ");
        int numLivros = entrada.nextInt();

        List<Livro> livros = new ArrayList<>();
        for (int i = 0; i < numLivros; i++) {
            System.out.print("Digite o código do livro " + (i + 1) + ": ");
            int codigoLivro = entrada.nextInt();
            livros.add(new Livro("Livro " + codigoLivro, codigoLivro));
        }

        Controle controle = new Controle();
        boolean sucesso = controle.emprestar(raAluno, livros);

        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso!");
        } else {
            System.out.println("Falha no empréstimo. Verifique as pendências do aluno.");
        }

        entrada.close();
    }
}
