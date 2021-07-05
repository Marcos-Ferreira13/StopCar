package telas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {
	
	SistemaStopCar sistema;
	Carro novoCarro;
	Cliente novoCliente;

	@BeforeEach

	public void setUp (){
		sistema = new SistemaStopCar();
		novoCarro = new Carro("ferrari","123PB",20.50,CategoriaCarro.CONVERSIVEL);
		novoCliente = new ClientePF("marcos","rio tinto","123");
	}

	@Test
	void test() {
		assertTrue(sistema.cadastrarCarro(novoCarro));
		assertTrue(sistema.cadastrarCliente(novoCliente));
		
		List<Carro> carros = sistema.buscaCarroPorCategoria(CategoriaCarro.CONVERSIVEL);
		
		assertTrue(carros.size() == 1);
		assertTrue(sistema.alugarCarro("123", "123PB"));
	}
	
	@Test
	void testExiste() {
	
		assertFalse(sistema.existeCarro(novoCarro));
		assertFalse(sistema.existeCliente(novoCliente));
		
		sistema.cadastrarCarro(novoCarro);
		sistema.cadastrarCliente(novoCliente);
		
		assertTrue(sistema.existeCarro(novoCarro));
		assertTrue(sistema.existeCliente(novoCliente));
	}
	
	@Test
	void testBusca() {
		sistema.cadastrarCarro(novoCarro);
		sistema.cadastrarCliente(novoCliente);
		
		assertTrue(sistema.buscaCarroPorCategoria(CategoriaCarro.DESCONHECIDO).size() == 0);
		assertTrue(sistema.buscaCarroPorCategoria(CategoriaCarro.PICAPE).size() == 0);
		assertTrue(sistema.buscaCarroPorCategoria(CategoriaCarro.SUV).size() == 0);
		assertTrue(sistema.buscaCarroPorCategoria(CategoriaCarro.CONVERSIVEL).size() == 1);
		
		assertEquals(novoCarro, sistema.buscaCarroPorPlaca("123PB"));
		
		assertEquals(novoCliente, sistema.buscaClientePorId("123"));
		
	}
	
}
