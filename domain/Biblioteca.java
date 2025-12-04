package exercicios.noveexercicios.sistemadebiblioteca.domain;

import java.util.Scanner;

public class Biblioteca {
    Scanner scanner = new Scanner(System.in);

    private Livro[] livros = new Livro[10];
    private int quantidadeLivros = 0;

    public void cadastrarLivro() {
        if (quantidadeLivros >= livros.length) {
            System.out.println("Limite de livros alcançado!");
            return;
        } else {
            System.out.println("Digite o título do livro:");
            String tituloDoLivro = scanner.nextLine();
            while (tituloDoLivro == null || tituloDoLivro.trim().isEmpty()) {
                System.out.println("Digite um título válido:");
                tituloDoLivro = scanner.nextLine();
            }

            System.out.println("Digite o nome do autor do livro");
            String autorDoLivro = scanner.nextLine();
            while (autorDoLivro == null || autorDoLivro.trim().isEmpty()) {
                System.out.println("Digite um nome válido:");
                autorDoLivro = scanner.nextLine();
            }

            System.out.println("Digite o ano do livro");
            while (!scanner.hasNextInt()) {
                System.out.println("Ano inválido! Digite novamente:");
                scanner.nextLine();
            }

            int anoDoLivro = scanner.nextInt();
            scanner.nextLine();

            Livro livro = new Livro(tituloDoLivro, autorDoLivro, anoDoLivro);

            livros[quantidadeLivros] = livro;
            quantidadeLivros++;

            System.out.println("Livro cadastrado!");
            return;
        }
    }

    public void listarLivros() {
        for (int i = 0; i < quantidadeLivros; i++) {
            Livro l = livros[i];
            System.out.println((i + 1) + " - " + l.getTitulo() + " (" + l.getAutor() + ")" + " - " + l.getAno() + " - " + l.isEmprestado());
        }
        return;
    }

    public void buscarLivroPorTitulo() {
        System.out.println("Que livro deseja buscar?");
        String nomeDoLivro = scanner.nextLine();

        while (nomeDoLivro == null || nomeDoLivro.trim().isEmpty()) {
            System.out.println("Digite um título válido:");
            nomeDoLivro = scanner.nextLine();
        }

        for (int i = 0; i < quantidadeLivros; i++) {
            Livro l = livros[i];
            if (nomeDoLivro.equalsIgnoreCase(l.getTitulo())) {
                System.out.println((i + 1) + " - " + l.getTitulo() + " - " + l.getAno() + " - " + (l.isEmprestado() ? "Emprestado" : "Disponível"));
                return;
            }
        }
        System.out.println("livro não encontrado");
        return;
    }

    public void emprestarLivro() {
        System.out.println("Que livro deseja emprestar?");
        String nomeDoLivro = scanner.nextLine();

        while (nomeDoLivro == null || nomeDoLivro.trim().isEmpty()) {
            System.out.println("Digite um título válido:");
            nomeDoLivro = scanner.nextLine();
        }

        for (int i = 0; i < quantidadeLivros; i++) {
            Livro l = livros[i];
            if (nomeDoLivro.equalsIgnoreCase(l.getTitulo())) {
                if (l.isEmprestado()) {
                    System.out.println("Este livro já está emprestado!");
                } else {
                    l.emprestar();
                    System.out.println("Livro emprestado!");
                    return;
                }
            }
        }
        System.out.println("livro não encontrado");
        return;
    }

    public void devolverLivro() {
        System.out.println("Que livro deseja devolver?");
        String nomeDoLivro = scanner.nextLine();

        while (nomeDoLivro == null || nomeDoLivro.trim().isEmpty()) {
            System.out.println("Digite um título válido:");
            nomeDoLivro = scanner.nextLine();
        }

        for (int i = 0; i < quantidadeLivros; i++) {
            Livro l = livros[i];
            if (nomeDoLivro.equalsIgnoreCase(l.getTitulo())) {
                if (l.isEmprestado()) {
                    l.devolver();
                    System.out.println("Livro devolvido!");
                    return;
                } else {
                    System.out.println("Este livro não está emprestado!");
                }
            }
        }
        System.out.println("livro não encontrado");
        return;
    }
}
