/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.playingcards24_fxml;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author jonat
 */
public class EvalMethodTest {
    
    public EvalMethodTest() {
    }

    /**
     * Test of solveSimpleOperation method, of class EvalMethod.
     */
    @Test
    public void testSolveSimpleOperation() {
        System.out.println("solveSimpleOperation");
        double num2 = 0.0;
        double num1 = 0.0;
        char op = ' ';
        double expResult = 0.0;
        double result = EvalMethod.solveSimpleOperation(num2, num1, op);
        assertEquals(expResult, result, 0.0);
    }

}
