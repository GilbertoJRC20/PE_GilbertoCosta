import java.io.File;
import java.io.FileNotFoundException;
import java.util.PropertyPermission;
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

    public static int contarLinhasFicheiro (String path) throws FileNotFoundException {

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

    /**
     * Método que, dado um género, imprime na consola todas as músicas desse género
     *
     * @param matrizCompleta Matriz com as músicas todas
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

    public static void main (String[]args) throws FileNotFoundException {


            try {

                imprimirFicheiroConsola("GameStart/GameStart_Banner.csv");

            } catch (FileNotFoundException e) {

                System.out.println("Ficheiro Não Encontrado...");

            }


        // Caminho para o ficheiro
        String path = "Ficheiros/exercicio_09.csv";

        // Matriz completa
        String[][] matrizFicheiro = lerFicheiroParaMatriz(path);

        // imprimirMatrizStrings(matrizFicheiro);


        //Saudação
        System.out.println("✋\uD83D\uDE03 OLÁ ✋\uD83D\uDE03 BEM-VINDO À GAMESTART!\uD83C\uDF89\nA tua loja de videojogos favorita!\n");


        //Importar o scanner
        Scanner input = new Scanner(System.in);


        // Declarar variáveis
        int opcao;
        String tipoUtilizador, admin, cliente, editora;




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
                    System.out.println("Que Editora deseja pesquisar?: ");
                    editora = input.nextLine();
                    //editora = input.nextLine();

                    pesquisarPorEditora(matrizFicheiro, editora);

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


        int nLinhas;

        nLinhas = contarLinhasFicheiro ("GameStart");

        System.out.println("Número de Linhas: " + nLinhas);


    }
}
