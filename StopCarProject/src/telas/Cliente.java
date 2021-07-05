/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author vinic
 */
public abstract class Cliente {
    private String nome;
    private String endereco;
    
    public abstract String getId();
    
    public Cliente(String nome,String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEndereco(){
        return this.endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String toString (){
        return "nome:"+this.nome+"\nEndereço: "+this.endereco;
    }
}
