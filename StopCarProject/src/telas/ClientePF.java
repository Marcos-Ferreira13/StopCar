/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import telas.Cliente;

/**
 *
 * @author vinic
 */
public class ClientePF extends Cliente {
    private String cpf;
    
    @Override
    public String getId(){
        return this.cpf;
    }
    
    public ClientePF(String nome,String endereco,String cpf){
        super(nome,endereco);
        this.cpf = cpf;
    }
    
    public ClientePF (){
        this("","","");
    }
    
   
}
