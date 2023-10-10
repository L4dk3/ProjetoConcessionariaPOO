package Gabriel.brito.dcx.ufpb.br;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ConcessionariaDados {
    private final String arquivoDados = "dados_carros.txt";

    public List<Veiculo> carregarCarros() {
        List<Veiculo> carros = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(arquivoDados))) {
            carros = (List<Veiculo>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return carros;
    }

    public void salvarCarros(List<Veiculo> carros) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(arquivoDados))) {
            outputStream.writeObject(carros);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
