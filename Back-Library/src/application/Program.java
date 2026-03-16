package application;

import entities.Book;
import entities.Loan;
import entities.User;
import services.LibraryServices;


import java.util.Scanner;

public class Program {
    static void main() {
        Scanner sc = new Scanner(System.in);
        LibraryServices libraryServices = new LibraryServices();
        int choice2 = 1;
        int choice3 = 1;


        System.out.println("------------------------------------");
        System.out.println("Você é funcionário ou usuário? (f/u)");
        System.out.println("------------------------------------");
        char choice = sc.next().charAt(0);
        if (choice == 'f') {
            while (choice2 != 0) {
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
                choice2 = sc.nextInt();

                switch (choice2) {
                    case 1:
                        System.out.print("Digite o nome do livro: ");
                        String signInBookName = sc.next();
                        System.out.print("Digite o nome do autor: ");
                        String signInBookAuthor = sc.next();
                        System.out.println("Digite o ID do livro: ");
                        int signInBookId = sc.nextInt();
                        Book bookSigned = new Book(signInBookName, signInBookAuthor, signInBookId);
                        libraryServices.signInBook(bookSigned);
                        break;
                    case 2:
                        System.out.print("Digite o ID do usuário: ");
                        int signInUserId = sc.nextInt();
                        if (libraryServices.getUser(signInUserId) != null) {
                            libraryServices.signOutUser(libraryServices.getUser(signInUserId));
                            System.out.println("Usuário removido com sucesso! ");
                        } else {
                            System.out.println("Usuário Inválido. ");
                        }
                        break;
                    case 3:
                        System.out.println("Digite o ID do livro: ");
                        int signOutBookId = sc.nextInt();
                        Book bookToRemove = libraryServices.getBook(signOutBookId);
                        if (bookToRemove == null) {
                            System.out.println("Livro Inválido");
                        } else {
                            boolean removed = libraryServices.signOutBook(bookToRemove);

                        if (removed) {
                            System.out.println("Livro removido com sucesso!");
                        } else {
                            System.out.println("Não foi possível remover o livro, pois ele possui empréstimo ativo.");
                        }
                     }

                        break;
                    case 4:
                        System.out.println("Lista de empréstimos ativos: " + libraryServices.getActiveLoans());
                        break;
                    case 5:
                        System.out.println("Empréstimos atrasados: " + libraryServices.getOverdueLoans());
                        break;
                    case 6:
                        System.out.println("Digite o id do usuário: ");
                        int userId = sc.nextInt();
                        System.out.println("Retornando empréstimos ativos\n" + libraryServices.getLoansByUser(userId));
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                }
            }
        }else if (choice == 'u') {
            while (choice3 != 0) {
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
                System.out.println("5. VISUALIZAR LISTA DE EMPRÉSTIMOS");
                System.out.println("6. LISTAR LIVROS");
                System.out.println("0. SAIR DO PROGRAMA");
                choice3 = sc.nextInt();

                switch (choice3) {
                    case 1:
                        System.out.print("Digite seu nome: ");
                        String signInUserName = sc.next();
                        System.out.print("Digite seu email: ");
                        String signInUserEmail = sc.next();
                        System.out.print("Digite o ID do usuário: ");
                        int SignInUserId = sc.nextInt();
                        User userSigned = new User(signInUserName, signInUserEmail, SignInUserId);
                        libraryServices.signInUser(userSigned);
                        break;
                    case 2:
                        System.out.print("Digite seu ID: ");
                        int signOutUserId = sc.nextInt();
                        User userToRemove = libraryServices.getUser(signOutUserId);
                        if(userToRemove == null) {
                            System.out.println("Usuário inválido");
                        } else {
                            boolean removed = libraryServices.signOutUser(userToRemove);
                            if (removed) {
                                System.out.println("Usuário removido com sucesso!");
                            } else {
                                System.out.println("Não foi possível remover o usuário, pois ele possui empréstimo ativo.");
                            }
                        }
                        break;
                    case 3:
                        System.out.print("Digite o Id do livro: ");
                        int bookId = sc.nextInt();
                        System.out.print("Digite seu Id: ");
                        int userId = sc.nextInt();
                        if (libraryServices.getBook(bookId) == null || libraryServices.getUser(userId) == null) {
                            System.out.println("Livro ou usuário inválido");
                        }else {
                            Loan loanCreated = libraryServices.loanBook(bookId, userId);
                            if (loanCreated == null) {
                                System.out.println("Empréstimo negado");
                            }else{
                                System.out.println("Empréstimo criado com sucesso!");
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Digite o Id do livro: ");
                        int bookReturnId = sc.nextInt();
                        System.out.print("Digite seu Id: ");
                        int userReturnId = sc.nextInt();
                        if (libraryServices.getBook(bookReturnId) == null || libraryServices.getUser(userReturnId) == null) {
                            System.out.println("Livro ou usuário inválido");
                        }
                        else{
                            Loan loanReturned = libraryServices.returnBook(bookReturnId, userReturnId);
                            if(loanReturned == null) {
                                System.out.println("Falha ao retornar empréstimo");
                            }else{
                                System.out.println("Empréstimo retornado com sucesso!");
                            }
                        }

                        break;
                    case 5:
                        System.out.print("Digite seu Id: ");
                        int userLoansId = sc.nextInt();
                        System.out.println("Empréstimos da conta: " + userLoansId);
                        System.out.println(libraryServices.getLoansByUser(userLoansId));
                        break;
                }
            }
        } else {
            System.out.println("COMANDO INVÁLIDO");
        }
    }
}
