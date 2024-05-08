import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VeryGoodSaude {

    /**
     * Método para instanciar um scanner para ler e imprimir os ficheiros na consola
     * @param path caminho para o ficheiro
     * @throws FileNotFoundException excecão necessária
     */
    public static void leitorDeFicheiros(String path) throws FileNotFoundException {

        // Instanciar um Scanner para o Ficheiro que foi passado por parâmetro
        Scanner leitorFicheiro = new Scanner(new File(path));

        while (leitorFicheiro.hasNextLine()) {
            String linha = leitorFicheiro.nextLine();
            System.out.println(linha);
        }

    }


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // Utilizados para a mesma opção no menu

    /**
     * Método contador de linhas de um ficheiro
     * @param path parâmetro para indicar o caminho para um dito ficheiro
     * @return retorna o número de linhas no ficheiro passado por parâmetro
     * @throws FileNotFoundException exceção necessária
     */
    public static int contarLinhasFicheiro(String path) throws FileNotFoundException {

        int numeroLinhas = 0;

        Scanner leitura = new Scanner(new File(path));

        while (leitura.hasNextLine()) {
            numeroLinhas++;
            leitura.nextLine();
        }

        return numeroLinhas;
    }



    /**
     * Método que faz a soma de todos os valores double num determinado ficheiro e apresenta o total da soma desses valores
     * @param path caminho para o ficheiro que é passado por parâmetro no método
     * @throws FileNotFoundException exceção necessária
     */
    public static void totalVendas(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));

        String linha = scanner.nextLine();  //Linha do cabecalho

        double total = 0;


        while (scanner.hasNextLine()) {
            linha = scanner.nextLine();
            String[] valor = linha.split(";");


            total += Double.parseDouble(valor[5]);
        }

        System.out.println("Valor total das vendas é: " + total + " €");
        scanner.close();
    }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void intervencaoMaisCara(String path) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(path));

        String linha, denominacao = "";
        double  intervencaoMC = 0;
        int identificacaoUtente = 0;

        while (scanner.hasNextLine()) {

            // Ler linha do ficheiro para variável "linha"
            linha = scanner.nextLine(); //Linha do cabecalho

            //Dividir a linha pela vírgula ";"
            String[] linhaDividida = linha.split(";");

            if (linhaDividida.length >= 6) {

                try {

                    // Transformar de volta para double
                    double valorIntervencao = Double.parseDouble(linhaDividida[5]);

                    // Percorrer os valores e compará-los
                    if (valorIntervencao > intervencaoMC) {


                        intervencaoMC = valorIntervencao;
                        denominacao = linhaDividida[4];
                        identificacaoUtente = Integer.parseInt(linhaDividida[1]);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Erro");
                }
            }
        }

        System.out.println("*** Intervenção Mais Cara ***\n");


        System.out.println("Descrição: " + denominacao);
        System.out.println("Valor: " + intervencaoMC + " €");
        System.out.println("Foi realizada ao utente com o Número de Utente: " + identificacaoUtente);

        System.out.println();

    }



    /*public static void pacientes (String path) throws FileNotFoundException {

        Scanner sc = new Scanner(new File(path));

        String linha, nome = "";
        int identificacaoUtente;

        while (sc.hasNextLine()) {
            linha = sc.nextLine();
            String[] linhaDividida = linha.split(";");

            identificacaoUtente = Integer.parseInt(linhaDividida[0]);
            nome = linhaDividida[1];


        }


        System.out.println("Com o nome " + nome);
        scanner.close();


    }*/

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////






/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    public static void main(String[] args) throws FileNotFoundException  {


        //Saudação
        System.out.println("✋\uD83D\uDE03 OLÁ ✋\uD83D\uDE03 BEM-VINDO À VERY GOOD SAÚDE!\uD83C\uDF89\nA melhor cadeia de hospitais do país!\n");


        //Importar o scanner
        Scanner input = new Scanner(System.in);


        //Declarar variáveis
        int opcao, utilizador, escolherFicheiro;

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
                    opcao = input.nextInt();

                         switch (opcao) {
                             case 1: //Apresentar opção 1
                                 System.out.println("\n*_*_*_* 1. Novo Registo *_*_*_*");

                                 System.out.println("\n*_*_*_* Inserir Utente *_*_*_*");

                                 int contacto;
                                 String nome = "", email = "", dataDeNascimento = "", nacionalidade = "";

                                 System.out.println("Por favor, insira os seus dados nos respetivos campos:\n");

                                 System.out.print("Insira Nome de Utente: ");
                                 nome = input.next();

                                 System.out.print("Insira o Contacto Telefónico do Utente, sem indicativo: ");
                                 contacto = input.nextInt();

                                 System.out.print("Insira Endereço de Email do Utente: ");
                                 email = input.next();

                                 System.out.print("Insira a Data de Nascimento do Utente: ");
                                 dataDeNascimento = input.next();

                                 System.out.print("Insira a Nacionalidade do Utente: ");
                                 nacionalidade = input.next();

                                 System.out.println("\nCliente Inserido com Sucesso: " + nome + "\t|\t" + contacto + "\t|\t" + email + "\t|\t" + dataDeNascimento + "\t|\t" + nacionalidade);


                                 System.out.println("\n");

                                 //Imprimir ficheiro de Copyright
                                 leitorDeFicheiros("Ficheiros/VeryGoodSaude_Copyright.txt");

                            break;

                             case 2:
                                 System.out.println("\n*_*_*_* 2. Procurar Estacionamento *_*_*_*");


                                 System.out.println("Olá, eu sou o porteiro do estacionamento deste hospital.\uD83D\uDC68\u200D✈\uFE0F\uD83C\uDFE5\uD83C\uDD7F\uFE0F");
                                 System.out.println("Aqui temos 70 lugares de estacionamento mas, pelo que eu vejo aqui nas câmaras, maior parte deles estão ocupados");
                                 System.out.println("Vou-lhe então dar a lista de lugares de vago:\n");


                                 //Declarar Variáveis
                                 int num = 0, lugar = 50;


                                 while (num <= 39) {
                                     num++;

                                     boolean primo = true;

                                     for (int divisor = 2; divisor < num; divisor++) {

                                         if (num % divisor == 0) {
                                             primo = false;
                                         }
                                     }

                                     if (primo) {
                                         System.out.println("O lugar " + num + " está vago");
                                     }
                                 }


                                 while (lugar <= 75) {
                                     lugar++;

                                     boolean primo = true;

                                     for (int divisor = 2; divisor < lugar; divisor++) {

                                         if (lugar % divisor == 0) {
                                             primo = false;
                                         }
                                     }

                                     if (primo) {
                                         System.out.println("O lugar " + lugar + " está vago");
                                     }
                                 }

                                 System.out.println("\nDe nada e até à próxima \uD83D\uDC4B\n");

                                 leitorDeFicheiros("Ficheiros/VeryGoodSaude_Copyright.txt");

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


                         } while (opcao != 5);



                         break;



                case 2: //Apresentar Menu de Médico
                    System.out.println("\nOlá e seja Bem-Vindo Doutor\n");

                    //Ler Opções Menu Cliente
                    System.out.println("*_*_*_* 1. Histórico de Utentes *_*_*_*");
                    System.out.println("*_*_*_* 2. Registar nova Intervenção *_*_*_*");
                    System.out.println("*_*_*_* 3. Sair *_*_*_*");

                    //Perguntar o que deseja fazer
                    System.out.print("\nO que deseja fazer Doutor?: ");
                    opcao = input.nextInt();


                    //Escolher a opções
                    switch (opcao) {
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

                    } while (opcao != 3);

                    break;


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
                    opcao = input.nextInt();

                    //Escolher a opções
                    switch (opcao) {
                        case 1:
                            System.out.println("\n*_*_*_* 1. Consulta de Ficheiros *_*_*_*");

                            do {

                                System.out.println("\nTem os seguintes ficheiros para ver:\n");
                                System.out.println("1. <----- Registos de todas as Intervenções -----> ");
                                System.out.println("2. <----- Registo de Margem de Lucro por Área de Intervenção -----> ");
                                System.out.println("3. <----- Lista de Utentes -----> ");
                                System.out.println("4. <----- Lista de Colaboradores -----> ");
                                System.out.println("5. <----- Sair -----> ");

                                System.out.print("\nQual o ficheiro que pretende consultar? ");
                                escolherFicheiro = input.nextInt();

                                switch (escolherFicheiro) {
                                    case 1:

                                        //Imprimir ficheiro de Vendas


                                        leitorDeFicheiros("Ficheiros/VeryGoodSaude_Intervencoes.csv");
                                        break;

                                    case 2:

                                        //Imprimir ficheiro de Clientes

                                        leitorDeFicheiros("Ficheiros/VeryGoodSaude_TiposIntervencao.csv");
                                        break;

                                    case 3:

                                        //Imprimir ficheiro de Categorias

                                        leitorDeFicheiros("Ficheiros/VeryGoodSaude_Utentes.csv");
                                        break;


                                    case 4:

                                        leitorDeFicheiros("Ficheiros/VeryGoodSaude_Staff.csv");
                                        break;


                                    case 5:

                                        System.out.println("5. Sair\n");
                                        break;

                                }


                            } while (escolherFicheiro != 5);

                            leitorDeFicheiros("Ficheiros/VeryGoodSaude_Copyright.txt");

                            break;


                        case 2:
                            System.out.println("\n*_*_*_* 2. Total de Vendas *_*_*_*");

                            System.out.println("Foram feitas um total de " + contarLinhasFicheiro("Ficheiros/VeryGoodSaude_Intervencoes.csv") + " de intervenções.");
                            totalVendas("Ficheiros/VeryGoodSaude_Intervencoes.csv");

                            break;

                        case 3:
                            System.out.println("\n*_*_*_* 3. Total de Lucro *_*_*_*");
                            break;

                        case 4:
                            System.out.println("\n*_*_*_* 4. Intervenção Mais Cara *_*_*_*");

                            intervencaoMaisCara("Ficheiros/VeryGoodSaude_Intervencoes.csv");
                            //pacientes("Ficheiros/VeryGoodSaude_Utentes.csv"); tentei xD

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

                    } while (opcao != 11);

                default:
                    System.out.println("\nErro! Utilizador não encontrado! Tenta outra vez");
                    break;

            }

        } while (utilizador != 4);

        System.out.println("\n*_*_*_* Obrigado e Até à Próxima! *_*_*_*\n");


        leitorDeFicheiros("Ficheiros/VeryGoodSaude_Copyright.txt");

    }

}