package Egle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class AppTest {
    static App app;
    int width=2;
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
        String[] arr= new String[]{"֍","☼","◊","⌂","♫","§","¤","Ѫ"};
        String[] symbols={"֍","☼","◊","⌂","♫","§","¤","Ѫ"};
        assertArrayEquals(arr, app.shuffleArray(symbols));
    }

    //3. kas mäng keerab õigele poole 
    @Test
    public void playerTurnTest(){
        assertEquals("LEFT", app.playerTurn("a"));
    }

    //3.1 kas mäng käitub õigesti, kui tühi string sisestatakse
    @Test
    public void playerTurnTest2(){
        assertEquals("Player moves to their original location", app.playerTurn(""));
    }

    //4. Kas õige kaart keerati
    @Test
    public void clearCardTest(){
        assertEquals(9, app.clearCard(3,3,width));
    }

    //5. kas kaart on vabastatud
    @Test
    public void isCardClearedTest(){
        assertFalse(app.isCleared());
    }









}
