package Gabriel.brito.dcx.ufpb.br;

import java.util.ArrayList;
import java.util.List;

public class BuscarCarroController {
    public List<Veiculo> buscarCarros(List<Veiculo> carros, String criterio, String valor) {
        List<Veiculo> resultados = new ArrayList<>();

        for (Veiculo veiculo : carros) {
            if ("Todos".equals(criterio) ||
                    ("Marca".equals(criterio) && veiculo.getMarca().equalsIgnoreCase(valor)) ||
                    ("Ano".equals(criterio) && Integer.toString(veiculo.getAno()).equals(valor))) {
                resultados.add(veiculo);
            }
        }

        return resultados;
    }
}
