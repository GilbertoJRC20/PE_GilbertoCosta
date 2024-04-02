import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    public static void main (String[]args) {


        //Saudação
        System.out.println("✋\uD83D\uDE03 OLÁ ✋\uD83D\uDE03 BEM-VINDO À GAMESTART!\uD83C\uDF89\nA tua loja de videojogos favorita!");


        //Importar o scanner
        Scanner input = new Scanner(System.in);


        // Declarar variáveis
        int opcao;
        String tipoUtilizador, admin;



        //Ler Tipo de Utilizador no Menu Login
        do {
            System.out.print("\nTipo de Utilizador (ADMIN || CLIENTE): ");
            tipoUtilizador = input.next();
        } while (!tipoUtilizador.equalsIgnoreCase("ADMIN") && !tipoUtilizador.equalsIgnoreCase("CLIENTE"));

        //Loop Cliente
        do {

            System.out.println("\nOlá e Bem-Vindo\n");

            //Ler Opções Menu Cliente
            System.out.println("*** 1. Novo Registo ***");
            System.out.println("*** 2. Procurar Estacionamento ***");
            System.out.println("*** 3. Catálogo de Jogos ***");
            System.out.println("*** 4. Pré-Visualizar ***");
            System.out.println("*** 5. Mostrar por Editora ***");
            System.out.println("*** 6. Mostrar por Categoria ***");
            System.out.println("*** 7. Recém-Chegado ***");
            System.out.println("*** 8. Sair ***");

            //Perguntar o que deseja fazer
            System.out.print("\nO que deseja fazer?: ");
            opcao = input.nextInt();


            //Escolher a opções
            switch (opcao) {
                case 1:
                    System.out.println("\n*** 1. Novo Registo ***");
                    break;

                case 2:
                    System.out.println("\n*** 2. Procurar Estacionamento ***");
                    break;

                case 3:
                    System.out.println("\n*** 3. Catálogo de Jogos ***");
                    break;

                case 4:
                    System.out.println("\n*** 4. Pré-Visualizar ***");
                    break;

                case 5:
                    System.out.println("\n*** 5. Mostrar por Editora ***");
                    break;

                case 6:
                    System.out.println("\n*** 6. Mostrar por Categoria ***");
                    break;

                case 7:
                    System.out.println("\n*** 7. Recém-Chegado ***");
                    break;

                case 8:
                    System.out.println("\n*** 8. Obrigado e Até à Próxima ***");
                    break;

                default:
                    System.out.println("\nErro!!! Operação inválida!\n");
                    break;
            }
        } while (opcao != 8);


        //Loop Admin
        do {

            //Perguntar o que deseja fazer
            System.out.println("\nBem-vindo de volta Chefe\n");


            //Ler Opções Menu Administrador
            System.out.println("*** 1. Consultar Ficheiros ***");
            System.out.println("*** 2. Consultar Total de Vendas ***");
            System.out.println("*** 3. Consultar Total de Lucro ***");
            System.out.println("*** 4. Pesquisar Clientes ***");
            System.out.println("*** 5. Jogo Mais Caro ***");
            System.out.println("*** 6. Melhores Clientes ***");
            System.out.println("*** 7. Melhor Categoria ***");
            System.out.println("*** 8. Pesquisar por Vendas ***");
            System.out.println("*** 9. Top 5 Jogos ***");
            System.out.println("*** 10. Bottom 5 Jogos ***");
            System.out.println("*** 11. Sair ***");


            System.out.print("\nO que deseja fazer?: ");
            opcao = input.nextInt();


            //Apresentar as opções
            switch (opcao) {
                case 1:
                    System.out.println("\n*** 1. Consultar Ficheiros ***");
                    break;

                case 2:
                    System.out.println("\n*** 2. Consultar Total de Vendas ***");
                    break;

                case 3:
                    System.out.println("\n*** 3. Consultar Total de Lucro ***");
                    break;

                case 4:
                    System.out.println("\n*** 4. Pesquisar Clientes ***");
                    break;

                case 5:
                    System.out.println("\n*** 5. Jogo Mais Caro ***");
                    break;

                case 6:
                    System.out.println("\n*** 6. Melhores Clientes ***");
                    break;

                case 7:
                    System.out.println("\n*** 7. Melhor Categoria ***");
                    break;

                case 8:
                    System.out.println("\n*** 8. Pesquisar por Vendas ***");
                    break;

                case 9:
                    System.out.println("\n*** 9. Top 5 Jogos ***");
                    break;

                case 10:
                    System.out.println("\n*** 10. Bottom 5 Jogos ***");
                    break;

                case 11:
                    System.out.println("\n*** 11. Obrigado e Até à Próxima ***");
                    break;

                default:
                    System.out.println("\nErro!!! Operação inválida!\n");
                    break;
            }
        } while (opcao != 11);





    }
}