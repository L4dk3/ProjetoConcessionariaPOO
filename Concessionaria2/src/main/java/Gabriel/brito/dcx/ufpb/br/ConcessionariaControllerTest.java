package Gabriel.brito.dcx.ufpb.br;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConcessionariaControllerTest {
    private ConcessionariaController controller;

    @BeforeEach
    public void setUp() {
        controller = new ConcessionariaController();
    }

    @Test
    public void testAdicionarCarro() {
        int tamanhoAnterior = controller.getCarros().size();

        Veiculo novoCarro = new Veiculo("Volkswagen", "Golf", 2022, 90000.0);
        controller.adicionarCarro(novoCarro);

        int tamanhoAtual = controller.getCarros().size();

        assertEquals(tamanhoAnterior + 1, tamanhoAtual);
        assertTrue(controller.getCarros().contains(novoCarro));
    }
}
