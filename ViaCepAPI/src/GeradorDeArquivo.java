import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void gerarJson(endereco Endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter arquivo = new FileWriter(Endereco.cep()+".json");
        arquivo.write(gson.toJson(Endereco));
        arquivo.close();
    }
}
