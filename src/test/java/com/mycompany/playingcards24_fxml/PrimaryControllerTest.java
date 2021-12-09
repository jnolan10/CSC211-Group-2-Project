package com.mycompany.playingcards24_fxml;

import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * test suite for functions in the 
 * primary controller class
 * @author jonat
 */
public class PrimaryControllerTest {
    
    public PrimaryControllerTest() {
    }
    
    /**
     * Test of helper method, of class PrimaryController.
     */
    @Test
    public void testHelper() {
        System.out.println("helper");
        int[] int1 = {1,2,3,4};
        int[] int2 = {1,2,3,4};
        PrimaryController instance = new PrimaryController();
        boolean expResult = true;
        boolean result = instance.helper(int1, int2);
        assertEquals(expResult, result);
    }
    
}
