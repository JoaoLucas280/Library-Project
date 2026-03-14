package application;

import entities.Book;
import entities.User;
import services.LibraryServices;

import java.util.Random;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random randomizer = new Random(100);
        LibraryServices  libraryServices = new LibraryServices();

        System.out.println("------------------------------------");
        System.out.println("Você é funcionário ou usuário? (f/u)");
        System.out.println("------------------------------------");
        char choice = sc.next().charAt(0);
        if (choice == 'f') {
            System.out.println("================================");
            System.out.println("        MENU DA BIBLIOTECA      ");
            System.out.println("           FUNCIONÁRIOS      ");
            System.out.println("================================");
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println("     ESCOLHA UMA DAS OPÇÕES:     ");
            System.out.println("---------------------------------");
            System.out.println("1. CADASTRAR LIVRO");
            System.out.println("2. REMOVER USUÁRIO");
            System.out.println("3. REMOVER LIVRO");
            System.out.println("4. LISTAR EMPRÉSTIMOS ATIVOS");
            System.out.println("5. LISTAR EMPRÉSTIMOS ATRASADOS");
            System.out.println("6. LISTAR EMPRÉSTIMO POR USUÁRIO");
            System.out.println("0. SAIR DO PROGRAMA");
            int choice2 = sc.nextInt();
            switch (choice2) {
                case 1:
                    System.out.println("Digite o nome do livro: ");
                    String signInBookName = sc.next();
                    System.out.println("Digite o nome do autor: ");
                    String signInBookAuthor = sc.next();
                    int signInBookId = randomizer.nextInt(100) + 1;
                    System.out.print("ID do livro: " + signInBookId);
                    Book bookSigned = new Book(signInBookName, signInBookAuthor, signInBookId);
                    libraryServices.signInBook(bookSigned);
                    break;
                case 2:
                    System.out.println("Digite o nome do usuário: ");
                    String signInUserName = sc.next();
                    System.out.println("Digite o email do usuário: ");
                    String signInUserEmail = sc.next();
                    System.out.println("Digite o ID do usuário: ");
                    int signInUserId = sc.nextInt();
                    User userSigned = new User(signInUserName, signInUserEmail, signInUserId);
                    libraryServices.signOutUser(userSigned);
                    break;
                case 3:
                    System.out.println("Digite o nome do livro: ");
                    String signOutBookName = sc.next();
                    System.out.println("Digite o nome do autor: ");
                    String signOutBookAuthor = sc.next();
                    System.out.println("Digite o ID do livro: ");
                    int signOutBookId = sc.nextInt();
                    Book bookSignedOut = new Book(signOutBookName, signOutBookAuthor, signOutBookId);
                    libraryServices.signOutBook(bookSignedOut);
                    break;
                case 4:
                    System.out.println("Lista de empréstimos ativos: ");
                    libraryServices.getActiveLoans();
                    break;
                case 5:
                    System.out.println("Empréstimos atrasados: ");
                    libraryServices.getOverdueLoans();
                    break;
                case 6:
                    System.out.println("Digite o id do usuário: ");
                    int userId = sc.nextInt();
                    System.out.println("Retornando empréstimos ativos...");
                    libraryServices.getLoansByUser(userId);
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
            }

        }else if (choice == 'u') {
            System.out.println("=================================");
            System.out.println("        MENU DA BIBLIOTECA       ");
            System.out.println("             USUÁRIO      ");
            System.out.println("=================================");
            System.out.println();
            System.out.println("---------------------------------");
            System.out.println("     ESCOLHA UMA DAS OPÇÕES:     ");
            System.out.println("---------------------------------");
            System.out.println("1. CADASTRAR");
            System.out.println("2. REMOVER CONTA");
            System.out.println("3. EMPRÉSTIMO DE LIVRO");
            System.out.println("4. RETORNO DE LIVRO");
            System.out.println("5. VISUALIZAR QUANTIDADE DE EMPRÉSTIMOS");
            System.out.println("0. SAIR DO PROGRAMA");
            int choice3 = sc.nextInt();

            switch (choice3) {
                case 1:
                    System.out.println("Digite seu nome: ");
                    String signInUserName = sc.nextLine();
                    System.out.println("Digite seu email: ");
                    sc.nextLine();
                    String signInUserEmail = sc.nextLine();
                    int SignInUserId = randomizer.nextInt(100) + 1;
                    System.out.println("ID gerado: " + SignInUserId);
                    User userSigned = new User(signInUserName, signInUserEmail, SignInUserId);
                    libraryServices.signInUser(userSigned);
                    break;
                case 2:
                    System.out.print("Digite seu nome: ");
                    String signOutName = sc.next();
                    System.out.println("Digite seu email: ");
                    String signOutEmail = sc.next();
                    System.out.print("Digite seu ID: ");
                    int signOutBookId = sc.nextInt();
                    libraryServices.signOutUser();
                    break;
                case 3:
                    System.out.print("Digite seu Id: ");
                    int userId = sc.nextInt();
                    System.out.print("Digite o Id do livro: ");
                    int bookId = sc.nextInt();
                    libraryServices.loanBook(userId, bookId);

                    break;
                case 4:
                    System.out.print("Digite seu Id: ");
                    int userReturnId = sc.nextInt();
                    System.out.print("Digite o Id do livro: ");
                    int bookReturnId = sc.nextInt();
                    libraryServices.returnBook(userReturnId, bookReturnId);

                    break;
                case 5:
                    System.out.print("Digite seu Id: ");
                    int userLoansId = sc.nextInt();
                    libraryServices.getLoansByUser(userLoansId);
                    System.out.println(libraryServices.getLoansByUser(userLoansId));
                    break;
            }
        } else {
            System.out.println("COMANDO INVÁLIDO");
        }
    }
}
