/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import telas.*;

/**
 *
 * @author vinic
 */
public class SistemaTest {
    SistemaStopCar sistema = new SistemaStopCar();
    
    
    public SistemaTest() {
        Carro novoCarro = new Carro("ferrari","123PB",1.50,CategoriaCarro.PICAPE);
        assertTrue(sistema.cadastrarCarro(novoCarro));
    }
    
   
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
