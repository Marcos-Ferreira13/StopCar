package telas;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import telas.Cliente;
import telas.CategoriaCarro;
import telas.Carro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaStopCar {
    List<Cliente> clientes;
    List <Carro> carros;

    public SistemaStopCar(){
        this.clientes = new ArrayList<>();
        this.carros = new ArrayList<>();
    }
    
    public boolean existeCarro(Carro carro){
         for(Carro c : this.carros){
            if(c.getPlaca().equals(carro.getPlaca())){
                return true;
            }
        }
         return false;
    }

    public boolean existeCliente(Cliente cliente){
         for(Cliente c : this.clientes){
            if(c.getId().equals(cliente.getId())){
                return true;
            }
        }
         return false;
    }

    public boolean cadastrarCliente(Cliente cliente){
         if(existeCliente(cliente)){
            return false;
        }
       clientes.add(cliente);
       return true;
    }

    public boolean cadastrarCarro(Carro carro){
        if(existeCarro(carro)){
            return false;
        }
        this.carros.add(carro);
        return true;

    }

    public ArrayList<Carro> buscaCarroPorCategoria (CategoriaCarro categoria){
        ArrayList<Carro> carrosAchados = new ArrayList<>();
        for(Carro c : this.carros){
            if(c.getCategoria().equals(categoria)){
                carrosAchados.add(c);
            }
        }
        return carrosAchados;
    }

    public Carro buscaCarroPorPlaca (String placa){
       Carro CarroAchado = null;
        for(Carro a : carros){
            if(a.getPlaca().equalsIgnoreCase(placa)){
                CarroAchado = a;
            }
        }
        return CarroAchado;
    }

    public Cliente buscaClientePorId(String id){
        Cliente clienteAchado = null;
        for (Cliente cl : clientes) {
            if (cl.getId().equals(id)) {
                clienteAchado = cl;
                break;
            }
        }
        return clienteAchado;
    }
    
    public boolean alugarCarro(String idCliente,String placa){
        boolean clientePass = false;
        boolean carroPass = false;
        
        for(Cliente c : this.clientes){
            if(c.getId().equals(idCliente)){
                clientePass = true;
            }
        }

        for(Carro c: this.carros){
            if(c.getPlaca().equals(placa) && c.isEstahAlugado() == false){
                carroPass = true;
            }
        }
        
        if(carroPass && clientePass){
            for(Carro carroAlugado : this.carros){
                carroAlugado.setEstahAlugado(true);
                return true;
            }return false;
        }
        return false;
        
    }

    public List<Cliente> retornaTodosOsClientes(){
        return this.clientes;  
    }

    public List<Carro> retornaTodosOsCarros(){
        return this.carros;
    }
    
    public void recadastrandoClientes(List<Cliente> retornandoAoSistema){
        this.clientes.addAll(retornandoAoSistema);
    }
    
    public void recadastrandoCarros(List<Carro> retornandoAoSistema){
        this.carros.addAll(retornandoAoSistema);
    }
}
