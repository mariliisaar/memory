package Egle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
    /**
     * Rigorous Test :-)
     */
public class AppTest {
    static App app;
    
    @BeforeClass
    public static void init(){
        app= new App();
    }
        

    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );
    }

    @Test
    public void squareTest(){
        int output  = app.square(5);
        assertEquals(25,output);
    }
}
