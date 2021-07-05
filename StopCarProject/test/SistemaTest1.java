

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import telas.Carro;
import telas.CategoriaCarro;
import telas.Cliente;
import telas.ClientePF;
import telas.SistemaStopCar;

class SistemaTest {
	SistemaStopCar sistema = new SistemaStopCar();
	
	@Test
	void test() {
		Carro novoCarro = new Carro("ferrari","123PB",20.50,CategoriaCarro.CONVERSIVEL);
		Cliente novoCliente = new ClientePF("marcos","rio tinto","123");
		assertTrue(sistema.cadastrarCarro(novoCarro));
		assertTrue(sistema.cadastrarCliente(novoCliente));
		List<Carro> carros = sistema.buscaCarroPorCategoria(CategoriaCarro.CONVERSIVEL);
		assertTrue(carros.size() == 1);
		assertTrue(sistema.alugarCarro("123", "123PB"));
	}

}