package Gabriel.brito.dcx.ufpb.br;

import java.util.List;

public class RemoverCarroController {
    public void removerCarro(List<Veiculo> carros, Veiculo carroRemovido) {
        carros.remove(carroRemovido);
    }
}
