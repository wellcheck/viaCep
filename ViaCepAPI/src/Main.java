import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        consultaCep consulta = new consultaCep();
        Scanner entrada = new Scanner(System.in);
        String busca = "";

        while (!busca.equalsIgnoreCase("sair")) {
            System.out.println("Digite um CEP:");
            busca = entrada.nextLine();

            if(busca.equalsIgnoreCase("sair")){
                break;
            }

            try {
                var enderecoFinal = consulta.buscarEndereco(busca);

                System.out.println(enderecoFinal);

                GeradorDeArquivo gerador = new GeradorDeArquivo();
                gerador.gerarJson(enderecoFinal);
            } catch (RuntimeException e) {
                System.out.println("Erro ao buscar cep!!" + e);
                System.out.println("Finalizando a aplicação!");
            }

        }
    }
    }
