package Egle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class AppTest {
    static App app;
    
    @BeforeClass
    public static void init(){
        app= new App();
    }
        
    //1. testin, kas ühekorne nimi annab tagasi sama nime
    @Test
    public void createPlayerTest1(){
        assertEquals("Teele",app.createPlayer("Teele"));
    }

    //1.1 testin tühja stringi
    @Test
    public void createPlayerTest2(){
        assertEquals("no name",app.createPlayer(""));
    }

    //2. alati peab failed tulema, sest me ei tea, mis shufffelist tuleb
    @Test 
    public void shuffleArrayTest(){
        //marilii /andres
        String[] arr= new String[]{"֍","☼","◊","⌂","♫","§","¤","Ѫ"};
        String[] symbols={"֍","☼","◊","⌂","♫","§","¤","Ѫ"};
        assertArrayEquals(arr, app.shuffleArray(symbols));
    }





}
