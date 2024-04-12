import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LojaGameStart {

    public static void imprimirFicheiroConsola(String path) throws FileNotFoundException {

        // Instanciar um Scanner para o Ficheiro que foi passado por parâmetro
        Scanner leitorFicheiro = new Scanner(new File(path));

        while (leitorFicheiro.hasNextLine()) {
            String linha = leitorFicheiro.nextLine();
            System.out.println(linha);
        }

    }


    /**
     * Método que imprime uma matriz de Strings na consola
     *
     * @param matriz Matriz a ser impressa
     */
    public static void imprimirMatrizStrings(String[][] matriz) {

        for (int linha = 0; linha < matriz.length; linha++) {
            for (int coluna = 0; coluna < matriz[0].length; coluna++) {
                System.out.print(matriz[linha][coluna] + "\t|\t");
            }
            System.out.println();
        }
    }


    /**
     * Método que conta as colunas de um ficheiro estruturado (ex: .csv)
     *
     * @param path        Caminho para o ficheiro
     * @param delimitador Delimitador que separa as colunas
     * @return Número de Colunas
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static int contarColunas(String path, String delimitador) throws FileNotFoundException {

        Scanner leitura = new Scanner(new File(path));

        String linha = leitura.nextLine();

        String[] linhaDividida = linha.split(delimitador);

        int numeroColunas = linhaDividida.length;

        return numeroColunas;
    }

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
     * Método que lê um ficheiro estruturado para uma matriz
     *
     * @param path Caminho para o ficheiro
     * @return Matriz preenchida com o conteúdo do ficheiro
     * @throws FileNotFoundException Caso o ficheiro não seja encontrado
     */
    public static String[][] lerFicheiroParaMatriz(String path) throws FileNotFoundException {

        // Declarar matriz á medida
        String[][] matrizCompleta = new String[contarLinhasFicheiro(path) - 1][contarColunas(path, ";")];

        // Scanner
        Scanner leitura = new Scanner(new File(path));

        // Linha atual
        String linha = leitura.nextLine();

        int contadorLinha = 0;

        while (leitura.hasNextLine()) {

            linha = leitura.nextLine();

            String[] linhaDividida = linha.split(";");

            for (int i = 0; i < matrizCompleta[0].length; i++) {
                matrizCompleta[contadorLinha][i] = linhaDividida[i];
            }

            contadorLinha++;

        }

        return matrizCompleta;

    }


    public static void somarValorTotal(String path) throws FileNotFoundException {
        Scanner in = new Scanner( new File(path));

        String linha = in.nextLine();  //Linha do cabecalho

        double total = 0;

        while (in.hasNextLine()) {
            linha = in.nextLine();
            String[] valor = linha.split(";");


                total += Double.parseDouble(valor[5]);
        }

        System.out.println("Valor total das vendas é: " + total + " €");
        in.close();
    }


    /**
     * Método que, dado um género, imprime na consola todas as músicas desse género
     *
     * @param matrizCompleta  Matriz com as músicas todas
     * @param editoraPesquisa Pesquisar por Editora
     */
    public static void pesquisarPorEditora(String[][] matrizCompleta, String editoraPesquisa) {

        System.out.println();

        for (int linha = 0; linha < matrizCompleta.length; linha++) {

            if (matrizCompleta[linha][2].equalsIgnoreCase(editoraPesquisa)) {

                System.out.println("Identificação da Venda: " + matrizCompleta[linha][0]);
                System.out.println("Identificação do Cliente: " + matrizCompleta[linha][1]);
                System.out.println("Editora: " + matrizCompleta[linha][2]);
                System.out.println("Categoria: " + matrizCompleta[linha][3]);
                System.out.println("Nome do Jogo: " + matrizCompleta[linha][3]);
                System.out.println("Preço do Jogo: " + matrizCompleta[linha][3]);

                System.out.println("___________________________________________________________________");

            }

        }

    }

    public static void jogoMaisCaro(String path) throws FileNotFoundException {

        Scanner leitura = new Scanner(new File(path));

        String linha;
        double valor = 0, jogoMaisCaro = 0;
        String nome = "";

        while (leitura.hasNextLine()) {

            // Ler linha do ficheiro para variável "linha"
            linha = leitura.nextLine();

            //Dividir a linha pela vírgula ","
            String[] linhaDividida = linha.split(";");

            //Se a linhaDividida[1] como inteiro MAIOR QUE idadeMaisVelha
            if (Double.parseDouble(linhaDividida[5]) > jogoMaisCaro) {
                // Atualizar variáveis para ficar com as informações da pessoa mais velha atual
                jogoMaisCaro = Double.parseDouble(linhaDividida[5]);
                nome = linhaDividida[4];
            }

            System.out.println("O jogo mais caro é " + nome + "e custa " + jogoMaisCaro + " €");

        }
    }



    public static void main(String[] args) throws FileNotFoundException {

        //Imprimir ficheiro de Banner
            imprimirFicheiroConsola("GameStart/GameStart_Banner.csv");


        //Caminho para o ficheiro
        String path = "GameStart/GameStart_Vendas.csv";

        //Matriz completa
        String[][] matrizFicheiro = lerFicheiroParaMatriz(path);

        //imprimirMatrizStrings(matrizFicheiro);


        //Saudação
        System.out.println("✋\uD83D\uDE03 OLÁ ✋\uD83D\uDE03 BEM-VINDO À GAMESTART!\uD83C\uDF89\nA sua loja de videojogos favorita!\n");


        //Importar o scanner
        Scanner input = new Scanner(System.in);


        //Declarar variáveis
        int opcao, utilizador, escolhaFicheiro;
        String editora;


        do {

            //Ler Tipo de Utilizador no Menu Login
            System.out.println("\nEscolha qual o tipo de utilizador com que vai entrar:");

            //Apresentar as opções
            System.out.println("1 - ADMINISTRADOR\n2 - CLIENTE\n3 - SAIR\n");
            System.out.print("Resposta: ");
            utilizador = input.nextInt();

            switch (utilizador) {

                case 1: //Apresentar Menu de Administrador

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

                            do {
                                System.out.println("\nTem as seguintes opções para escolher.\n");

                                System.out.println("1. Vendas");
                                System.out.println("2. Clientes");
                                System.out.println("3. Categorias");
                                System.out.println("4. Sair\n");
                                System.out.print("\nQual o ficheiro que pretende consultar? ");
                                escolhaFicheiro = input.nextInt();

                                switch (escolhaFicheiro) {
                                    case 1:

                                        //Imprimir ficheiro de Vendas

                                        imprimirFicheiroConsola("GameStart/GameStart_Vendas.csv");
                                        break;

                                    case 2:

                                        //Imprimir ficheiro de Clientes

                                        imprimirFicheiroConsola("GameStart/GameStart_Clientes.csv");
                                        break;

                                    case 3:

                                        //Imprimir ficheiro de Categorias

                                        imprimirFicheiroConsola("GameStart/GameStart_Categorias.csv");
                                        break;


                                    case 4:

                                        System.out.println("4. Sair\n");
                                        break;

                                }

                            } while (escolhaFicheiro != 4);

                            //Imprimir ficheiro de Copyright

                            imprimirFicheiroConsola("GameStart/GameStart_Copyright.txt");

                            break;

                        case 2:
                            System.out.println("\n*** 2. Consultar Total de Vendas ***");

                            int  nLinhas;

                            nLinhas = contarLinhasFicheiro ("GameStart/GameStart_Vendas.csv");


                            System.out.println("Foram feitas " + nLinhas  + " vendas");
                            somarValorTotal("GameStart/GameStart_Vendas.csv");

                            break;

                        case 3:
                            System.out.println("\n*** 3. Consultar Total de Lucro ***");
                            break;

                        case 4:
                            System.out.println("\n*** 4. Pesquisar Clientes ***");
                            break;

                        case 5:
                            System.out.println("\n*** 5. Jogo Mais Caro ***");

                            jogoMaisCaro("GameStart/GameStart_Vendas.csv");

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
                            System.out.println("\n*** 11. Obrigado e bom descanso! ***");
                            break;

                        default:
                            System.out.println("\nErro!!! Operação inválida!\n");
                            break;
                    }
                    while (opcao != 11);


                    break;

                case 2: //Apresentar Menu de Cliente

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

                            long contacto;
                            String nome = "", email = "";

                            System.out.println("Por favor, insira os seus dados nos respetivos campos:\n");

                            System.out.print("Nome: ");
                            nome = input.next();

                            System.out.print("Email: ");
                            email = input.next();

                            System.out.print("Contacto Telefónico: ");
                            contacto = input.nextLong();

                            System.out.println("\nCliente registado com sucesso\n");
                            System.out.println(nome + " | " + email + " | " + contacto);

                            break;

                        case 2:
                            System.out.println("\n*** 2. Procurar Estacionamento ***");
                            break;

                        case 3:
                            System.out.println("\n*** 3. Catálogo de Jogos ***");
                            break;

                        case 4:
                            System.out.println("\n*** 4. Pré-Visualizar ***");


                            System.out.println("Aqui podes ver as capas dos seguintes jogos:");


                            do {
                                System.out.println("\nTem as seguintes opções para escolher.\n");

                                System.out.println("1. Call Of Duty");
                                System.out.println("2. Fifa");
                                System.out.println("3. Hollow Knight");
                                System.out.println("4. Minecraft");
                                System.out.println("5. Mortal Kombat");
                                System.out.println("6. Overcooked");
                                System.out.println("7. The Witcher 3");
                                System.out.println("8. Sair\n");
                                System.out.print("\nQual o ficheiro que pretende consultar? ");
                                escolhaFicheiro = input.nextInt();

                                switch (escolhaFicheiro) {
                                    case 1:

                                        //Imprimir ficheiro de Call Of Duty

                                        imprimirFicheiroConsola("GameStart/CatalogoGrafico/callOfDuty.txt");
                                        break;

                                    case 2:

                                        //Imprimir ficheiro de Fifa

                                        imprimirFicheiroConsola("GameStart/CatalogoGrafico/fifa.txt");
                                        break;

                                    case 3:

                                        //Imprimir ficheiro de Hollow Knight

                                        imprimirFicheiroConsola("GameStart/CatalogoGrafico/hollowKnight.txt");
                                        break;

                                    case 4:

                                        //Imprimir ficheiro de Minecraft

                                        imprimirFicheiroConsola("GameStart/CatalogoGrafico/minecraft.txt");
                                        break;

                                    case 5:

                                        //Imprimir ficheiro de MortalKombat

                                        imprimirFicheiroConsola("GameStart/CatalogoGrafico/mortalKombat.txt");
                                        break;

                                    case 6:

                                        //Imprimir ficheiro de Overcooked

                                        imprimirFicheiroConsola("GameStart/CatalogoGrafico/overcooked.txt");
                                        break;

                                    case 7:

                                        //Imprimir ficheiro de The Witcher 3

                                        imprimirFicheiroConsola("GameStart/CatalogoGrafico/witcher3.txt");
                                        break;


                                    case 8:

                                        System.out.println("8. Sair\n");
                                        System.out.println("Obrigado e até à prõxima");
                                        break;

                                }

                            } while (escolhaFicheiro != 8);

                            //Imprimir ficheiro de Copyright

                            imprimirFicheiroConsola("GameStart/GameStart_Copyright.txt");


                            break;

                        case 5: //Não funciona e ainda não descobri porquê
                            System.out.println("\n*** 5. Mostrar por Editora ***");
                            System.out.println("Que Editora deseja pesquisar?: ");
                            editora = input.nextLine();
                            //editora = input.nextLine();

                            pesquisarPorEditora(matrizFicheiro, editora);

                            imprimirFicheiroConsola("GameStart/GameStart_Vendas.csv");

                            break;

                        case 6:
                            System.out.println("\n*** 6. Mostrar por Categoria ***");
                            break;

                        case 7:
                            System.out.println("\n*** 7. Recém-Chegado ***");
                            break;

                        case 8:
                            System.out.println("\n*** 8. Obrigado e volte sempre! ***");
                            break;

                        default:
                            System.out.println("\nErro!!! Operação inválida!\n");
                            break;
                    }
                    while (opcao != 8) ;

                    break;

                case 3:
                    System.out.println("Sair");
                    System.out.println("\n*** Obrigado e Até à Próxima! ***\n");
                    break;


                default:
                    System.out.println("\nErro! Utilizador não encontrado! Tenta outra vez");

            }

        } while (utilizador != 3);


        //Imprimir ficheiro de Copyright

            imprimirFicheiroConsola("GameStart/GameStart_Copyright.txt");

    }
}