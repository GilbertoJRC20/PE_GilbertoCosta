import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Banner {

    public static void imprimirFicheiroConsola(String path) throws FileNotFoundException {

        // Instanciar um Scanner para o Ficheiro que foi passado por parâmetro
        Scanner leitorFicheiro = new Scanner(new File(path));

        while (leitorFicheiro.hasNextLine()) {
            String linha = leitorFicheiro.nextLine();
            System.out.println(linha);
        }

    }

    public static void main(String[] args) {

        try {

            imprimirFicheiroConsola("GameStart/GameStart_Banner.csv");

        } catch (FileNotFoundException e) {

            System.out.println("Ficheiro Não Encontrado...");

        }
    }
}
