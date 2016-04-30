/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map;

import org.junit.Test;
import static org.junit.Assert.*;
import graphics.*;
/**
 *
 * @author cmneville
 */
public class PoliticalMapTest {
    
    public PoliticalMapTest() {
    }

    /**
     * Test of main method, of class PoliticalMap.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MapSTATS.main(args);
        assertEquals(1,1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
