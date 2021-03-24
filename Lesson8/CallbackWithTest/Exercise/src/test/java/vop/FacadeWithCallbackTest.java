/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;

/**
 *
 * @author fsan
 */
public class FacadeWithCallbackTest {

    FacadeWithCallback facade;
    CallBackInterface soutCallBack;
    Dice dice;

    public FacadeWithCallbackTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() throws URISyntaxException {
//        TODO
//        Instantiate your CallBackInterface
//        Instantiate and start your Facade Thread
        soutCallBack = new CallBackInterface() {
            @Override
            public void updateMessage(String message) {
                System.out.println(message);
            }

            @Override
            public void updateImages(File i1, File i2) {
                System.out.println("Pics: " + i1.getName() + " " + i2.getName());
            }
        };
        facade = new FacadeWithCallback(soutCallBack);
        dice = new Dice();
        dice = facade.getDice();
        facade.start();
    }

    @After
    public void tearDown() {
//        TODO
//        Interrupt your facade Thread
        facade.interrupt();
    }

    /**
     * Test of run method, of class FacadeWithCallback.
     */

    @Test
    public void testRun() {
//        TODO
//        Test the run() method
//        Assert if the dice.getDie1() and dice.getDie2() are equal to integer 6
        try{
            facade.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(dice.getDie1() == 6 && dice.getDie2() == 6);
    }

}
