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
public class Carro {
    
    private String modelo;
    private String placa;
    private double valorAluguelPorKmRodado;
    private boolean estahAlugado;
    private CategoriaCarro categoria;
    
    public Carro(String modelo,String placa,double valorAluguelKmRodado,CategoriaCarro categoria){
        this.modelo = modelo;
        this.placa = placa;
        this.valorAluguelPorKmRodado = valorAluguelKmRodado;
        this.estahAlugado = false;
        this.categoria = categoria;
    }
    
    public Carro (){
        this("","",0.0,CategoriaCarro.DESCONHECIDO);
        this.estahAlugado = false;
    }
    

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the valorAluguelPorKmRodado
     */
    public double getValorAluguelPorKmRodado() {
        return valorAluguelPorKmRodado;
    }

    /**
     * @param valorAluguelPorKmRodado the valorAluguelPorKmRodado to set
     */
    public void setValorAluguelPorKmRodado(double valorAluguelPorKmRodado) {
        this.valorAluguelPorKmRodado = valorAluguelPorKmRodado;
    }

    /**
     * @return the estahAlugado
     */
    public boolean isEstahAlugado() {
        return estahAlugado;
    }

    /**
     * @param estahAlugado the estahAlugado to set
     */
    public void setEstahAlugado(boolean estahAlugado) {
        this.estahAlugado = estahAlugado;
    }

    /**
     * @return the categoria
     */
    public CategoriaCarro getCategoria() {
        return categoria;
    }

    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(CategoriaCarro categoria) {
        this.categoria = categoria;
    }
    @Override
    public String toString(){
        return "modelo:"+getModelo()+"Placa: "+this.placa+"\nEstá alugado? "+this.estahAlugado;
    }
}
