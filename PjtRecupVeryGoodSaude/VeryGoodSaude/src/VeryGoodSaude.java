import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class VeryGoodSaude {
    public static void main(String[] args) throws FileNotFoundException {


        //Saudação
        System.out.println("✋\uD83D\uDE03 OLÁ ✋\uD83D\uDE03 BEM-VINDO À VERY GOOD SAÚDE!\uD83C\uDF89\nA melhor cadeia de hospitais do país!\n");


        //Importar o scanner
        Scanner input = new Scanner(System.in);


        //Declarar variáveis
        int opcaoCliente, opcaoMedico, opcaoAdmin, utilizador;

        do {

            //Ler Tipo de Utilizador no Menu Login
            System.out.println("\nEscolha qual o tipo de utilizador com que vai entrar:");

            //Apresentar as opções
            System.out.println("1 - CLIENTE\t|\t2 - MÉDICO\t|\t3 - ADMINISTRADOR\t|\t4 - SAIR");
            System.out.print("Resposta: ");
            utilizador = input.nextInt();

            switch (utilizador) {

                case 1: //Apresentar Menu de Cliente

                    System.out.println("\nOlá e Bem-Vindo\n");

                    //Ler Opções Menu Cliente
                    System.out.println("*_*_*_* 1. Novo Registo *_*_*_*");
                    System.out.println("*_*_*_* 2. Procurar Estacionamento *_*_*_*");
                    System.out.println("*_*_*_* 3. Consultar Tabela de Preços *_*_*_*");
                    System.out.println("*_*_*_* 4. Consultar Catálogo de Interveções *_*_*_*");
                    System.out.println("*_*_*_* 5. Sair *_*_*_*");


                    System.out.print("\nO que deseja fazer?: ");
                    //Inserir a Opção
                    opcaoCliente = input.nextInt();


                         switch (opcaoCliente) {
                             case 1: //Apresentar opção 1
                                 System.out.println("\n*_*_*_* 1. Novo Registo *_*_*_*");

                                 System.out.println("\n*_*_*_* Inserir Utente *_*_*_*");

                                 int contacto;
                                 String nome = "", email = "", dataDeNascimento = "", nacionalidade = "";

                                 System.out.println("Por favor, insira os seus dados nos respetivos campos:\n");

                                 System.out.print("Insira Nome de Utente: ");
                                 nome = input.next();

                                 System.out.print("Insira o Contacto Telefónico do Utente: ");
                                 contacto = input.nextInt();

                                 System.out.print("Insira Endereço de Email do Utente: ");
                                 email = input.next();

                                 System.out.print("Insira a Data de Nascimento do Utente: ");
                                 dataDeNascimento = input.next();

                                 System.out.print("Insira a Nacionalidade do Utente: ");
                                 nacionalidade = input.next();


                                 System.out.println("\nCliente Inserido com Sucesso: " + nome + "\t|\t" + contacto + "\t|\t" + email + "\t|\t" + dataDeNascimento + "\t|\t" + nacionalidade);

                                 break;

                             //Imprimir ficheiro de Copyright


                             case 2:
                                 System.out.println("\n*_*_*_* 2. Procurar Estacionamento *_*_*_*");

                                 break;

                             case 3:
                                 System.out.println("\n*_*_*_* 3. Consultar Tabela de Preços *_*_*_*");
                                 break;

                             case 4:
                                 System.out.println("\n*_*_*_* 4. Consultar Catálogo de Interveções *_*_*_*");
                                 break;

                             case 5:
                                 System.out.println("\n*_*_*_* 5. Sair *_*_*_*");
                                 System.out.println("\n*_*_*_* 11. Obrigado e volte sempre! *_*_*_*");
                                 break;

                             default:
                                 System.out.println("\nErro!!! Opção não existe!\n");
                                 break;

                         }
                         while (opcaoCliente != 5) ;





                case 2: //Apresentar Menu de Médico
                    System.out.println("\nOlá e seja Bem-Vindo Doutor\n");

                    //Ler Opções Menu Cliente
                    System.out.println("*_*_*_* 1. Histórico de Utentes *_*_*_*");
                    System.out.println("*_*_*_* 2. Registar nova Intervenção *_*_*_*");
                    System.out.println("*_*_*_* 3. Sair *_*_*_*");

                    //Perguntar o que deseja fazer
                    System.out.print("\nO que deseja fazer Doutor?: ");
                    opcaoMedico = input.nextInt();


                    //Escolher a opções
                    switch (opcaoMedico) {
                        case 1:
                            System.out.println("\n*_*_*_* 1. Histórico de Utentes *_*_*_*");
                            break;

                        case 2:
                            System.out.println("\n*_*_*_* 2. Registar Nova Intervenção *_*_*_*");
                            break;

                        case 3:
                            System.out.println("\n*_*_*_* 3. Sair *_*_*_*");
                            break;

                        default:
                            System.out.println("\nErro!!! Opção não existe!\n");
                            break;

                    } while (opcaoMedico != 3);


                case 3: // Apresentar Menu de Administrador
                    System.out.println("\nOlá Chefe, seja Bem-Vindo\n");

                    //Ler Opções Menu Cliente
                    System.out.println("*_*_*_* 1. Consulta de Ficheiros *_*_*_*");
                    System.out.println("*_*_*_* 2. Total de Vendas *_*_*_*");
                    System.out.println("*_*_*_* 3. Total de Lucro *_*_*_*");
                    System.out.println("*_*_*_* 4. Intervenção Mais Cara *_*_*_*");
                    System.out.println("*_*_*_* 5. Cliente Mais Frequente *_*_*_*");
                    System.out.println("*_*_*_* 6. Tipo de Intervenção Mais Comum *_*_*_*");
                    System.out.println("*_*_*_* 7. Tipo de Intervenção Mais/Menos Lucrativo *_*_*_*");
                    System.out.println("*_*_*_* 8. Folha de Salários *_*_*_*");
                    System.out.println("*_*_*_* 9. Top 3 Profissionais que Mais Lucro Geram *_*_*_*");
                    System.out.println("*_*_*_* 10. Top 3 Profissionais com Salários mais Altos *_*_*_*");
                    System.out.println("*_*_*_* 11. Sair *_*_*_*");

                    //Perguntar o que deseja fazer
                    System.out.print("\nO que deseja fazer Chefe?: ");
                    opcaoAdmin = input.nextInt();

                    //Escolher a opções
                    switch (opcaoAdmin) {
                        case 1:
                            System.out.println("\n*_*_*_* 1. Histórico de Utentes *_*_*_*");
                            break;

                        case 2:
                            System.out.println("\n*_*_*_* 2. Total de Vendas *_*_*_*");
                            break;

                        case 3:
                            System.out.println("\n*_*_*_* 3. Total de Lucro *_*_*_*");
                            break;

                        case 4:
                            System.out.println("\n*_*_*_* 4. Intervenção Mais Cara *_*_*_*");
                            break;

                        case 5:
                            System.out.println("\n*_*_*_* 5. Cliente Mais Frequente *_*_*_*");
                            break;

                        case 6:
                            System.out.println("\n*_*_*_* 6. Tipo de Intervenção Mais Comum *_*_*_*");
                            break;

                        case 7:
                            System.out.println("\n*_*_*_* 7. Tipo de Intervenção Mais/Menos Lucrativo *_*_*_*");
                            break;

                        case 8:
                            System.out.println("\n*_*_*_* 8. Folha de Salários *_*_*_*");
                            break;

                        case 9:
                            System.out.println("\n*_*_*_* 9. Top 3 Profissionais que Mais Lucro Geram *_*_*_*");
                            break;

                        case 10:
                            System.out.println("\n*_*_*_* 10. Top 3 Profissionais com Salários mais Altos *_*_*_*");
                            break;

                        case 11:
                            System.out.println("\n*_*_*_* 11. Sair *_*_*_*");
                            break;

                        default:
                            System.out.println("\nErro!!! Opção não existe!\n");
                            break;

                    } while (opcaoAdmin != 11);

                default:
                    System.out.println("\nErro! Utilizador não encontrado! Tenta outra vez");
                    break;

            }

        } while (utilizador != 4);

        System.out.println("\n*_*_*_* Obrigado e Até à Próxima! *_*_*_*\n");

    }
}