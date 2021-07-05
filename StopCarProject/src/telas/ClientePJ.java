
package telas;

import telas.Cliente;

/**
 *
 * @author vinic
 */
public class ClientePJ extends Cliente {
    private String cnpj;
    
    @Override
    public String getId(){
        return this.cnpj;
    }
    
    public ClientePJ(String nome,String endereco,String cnpj){
        super(nome,endereco);
        this.cnpj = cnpj;
    }
    
    public ClientePJ (){
        this("","","");
    }
    
    
    
}
