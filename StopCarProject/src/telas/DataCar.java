package telas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataCar{
	
	public static final String ARQUIVO_USUARIOS = "cliente.txt";
	public static final String ARQUIVO_CARROS = "carro.txt";

	public List<Cliente> recuperaUsuariosDeArquivo() throws IOException {
		List<Cliente> listaClientes = new ArrayList<>();
		List<String> textoClientes = this.recuperaTextoDeArquivo(ARQUIVO_USUARIOS);
		for (String linha: textoClientes) {
			String [] dadosLinha = linha.split("#");
			listaClientes.add(new ClientePF(dadosLinha[0],dadosLinha[1],dadosLinha[2]));
		}
		return listaClientes;
	}
	
	public List<Carro> recuperaCarrosDeArquivo() throws IOException {
		List<Carro> listaCarros = new ArrayList<>();
		List<String> textoCarros = this.recuperaTextoDeArquivo(ARQUIVO_CARROS);
		for (String linha: textoCarros) {
			String [] dadosLinha = linha.split("#");
			System.out.println(dadosLinha.length);
			if(dadosLinha[3].equalsIgnoreCase("PIPAPE")){
				listaCarros.add(new Carro(dadosLinha[0],dadosLinha[1],Double.parseDouble(dadosLinha[2]),CategoriaCarro.PICAPE));
			}else if(dadosLinha[3].equalsIgnoreCase("SUV")){
				listaCarros.add(new Carro(dadosLinha[0],dadosLinha[1],Double.parseDouble(dadosLinha[2]),CategoriaCarro.SUV));
			}else if(dadosLinha[3].equalsIgnoreCase("CONVERSIVEL")){
				listaCarros.add(new Carro(dadosLinha[0],dadosLinha[1],Double.parseDouble(dadosLinha[2]),CategoriaCarro.CONVERSIVEL));
			}else{
				listaCarros.add(new Carro(dadosLinha[0],dadosLinha[1],Double.parseDouble(dadosLinha[2]),CategoriaCarro.DESCONHECIDO));
			}
		}
		return listaCarros;
	}
	public void gravaClienteEmArquivo(List<Cliente> clientes) throws IOException {
		List<String> clientesTxt = new ArrayList<>();
		for (Cliente u: clientes) {
			String linha = u.getNome()+"#"+u.getEndereco()
				+"#"+u.getId();
			clientesTxt.add(linha);
		}
                
		this.gravaTextoEmArquivo(clientesTxt, ARQUIVO_USUARIOS);
	}
	
	public void gravaCarroEmArquivo(List<Carro> carros) throws IOException {
		List<String> carrosTxt = new ArrayList<>();
		for (Carro u: carros) {
			if(u.getCategoria().toString().equalsIgnoreCase("PICAPE")){
				String linha = u.getModelo()+"#"+u.getPlaca()+"#"+u.getValorAluguelPorKmRodado()+"#"+CategoriaCarro.PICAPE;
				carrosTxt.add(linha);
			}else if(u.getCategoria().toString().equalsIgnoreCase("SUV")){
				String linha = u.getModelo()+"#"+u.getPlaca()+"#"+u.getValorAluguelPorKmRodado()+"#"+CategoriaCarro.SUV;
				carrosTxt.add(linha);
			}else if (u.getCategoria().toString().equalsIgnoreCase("CONVERSIVEL")){
				String linha = u.getModelo()+"#"+u.getPlaca()+"#"+u.getValorAluguelPorKmRodado()+"#"+CategoriaCarro.CONVERSIVEL;
				carrosTxt.add(linha);
			}else{
				String linha = u.getModelo()+"#"+u.getPlaca()+"#"+u.getValorAluguelPorKmRodado()+"#"+CategoriaCarro.DESCONHECIDO;
				carrosTxt.add(linha);
			}
		}
                
		this.gravaTextoEmArquivo(carrosTxt, ARQUIVO_CARROS);
	}
	
	public List<String> recuperaTextoDeArquivo(String nomeArquivo) throws IOException {
		
		BufferedReader leitor = null;
		List<String> textoLido = new ArrayList<>();
		try {
			leitor = new BufferedReader(new FileReader(nomeArquivo));
			String texto = null;
			do {
				texto = leitor.readLine();
				if (texto!=null) {
					textoLido.add(texto);
				}
			} while (texto!=null);
		} finally {
			if (leitor!=null) {
				leitor.close();
			}
		}
		return textoLido;
		
	}
	
	public void gravaTextoEmArquivo(List<String> texto, String nomeArquivo)
		throws IOException{
		
		BufferedWriter gravador = null;
		try {
			gravador = new BufferedWriter(new FileWriter(nomeArquivo));
			for (String s: texto) {
				gravador.write(s);
                                gravador.newLine();
			}
		} finally {
			if (gravador!=null) {
				gravador.close();
			}
		}
	}
}
