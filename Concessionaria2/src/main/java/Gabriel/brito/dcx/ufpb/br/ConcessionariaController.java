package Gabriel.brito.dcx.ufpb.br;

import Gabriel.brito.dcx.ufpb.br.ConcessionariaDados;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConcessionariaController {
    private List<Veiculo> carros;
    private ConcessionariaDados persistence;
    private AdicionarCarroController adicionarCarroController;
    private RemoverCarroController removerCarroController;
    private BuscarCarroController buscarCarroController;

    public ConcessionariaController() {
        carros = new ArrayList<>();
        persistence = new ConcessionariaDados();
        adicionarCarroController = new AdicionarCarroController();
        removerCarroController = new RemoverCarroController();
        buscarCarroController = new BuscarCarroController();

        carregarCarros();
    }

    public void carregarCarros() {
        carros = persistence.carregarCarros();
    }

    public void salvarCarros() {
        persistence.salvarCarros(carros);
    }

    public void adicionarCarro(Veiculo novoCarro) {
        adicionarCarroController.adicionarCarro(carros, novoCarro);
        salvarCarros();
    }

    public void removerCarro(Veiculo carroRemovido) {
        removerCarroController.removerCarro(carros, carroRemovido);
        salvarCarros();
    }

    public List<Veiculo> buscarCarros(String criterio, String valor) {
        return buscarCarroController.buscarCarros(carros, criterio, valor);
    }

    public List<Veiculo> getCarros() {
        return carros;
    }
}
