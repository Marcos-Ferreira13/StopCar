package telas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class testeDados {
    public static void main(String[] args) {
        DataCar save = new DataCar();

        List<Cliente> c = new ArrayList<>();
        c.add(new ClientePF("Maria","bs","123"));
        try {
            save.gravaClienteEmArquivo(c);
        } catch (IOException e) {
            
            e.printStackTrace();
        }

        try {
            save.recuperaUsuariosDeArquivo();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Carro novoCarro = new Carro("GOL","123",1.5,CategoriaCarro.PICAPE);
        if(novoCarro.getCategoria().toString().equals("PICAPE")){
            System.out.println("aaaaass");
        }else{
            System.err.println("bbb");
        }

    }
}
