package exercicios.noveexercicios.sistemadebiblioteca.domain;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private Biblioteca biblioteca = new Biblioteca();

    private boolean sistemaLigado = true;

    public void mostrarMenu() {
        while (sistemaLigado) {
            System.out.println("\n--- MENU ---");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Listar livros");
            System.out.println("3 - Buscar livro por título");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    biblioteca.cadastrarLivro();
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    biblioteca.buscarLivroPorTitulo();
                    break;
                case 4:
                    biblioteca.emprestarLivro();
                    break;
                case 5:
                    biblioteca.devolverLivro();
                    break;
                case 6:
                    sistemaLigado = false;
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    break;
            }
        }
    }

}
