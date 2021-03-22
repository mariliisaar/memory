package Egle;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class MyTest {
    static My my;
    
    @BeforeClass
    public static void init(){
        my= new My();
    }
        
    //assertEquals - testib kahte tulemust
    //assertEquals(expected, actual)
    @Test
    public void squareTestTrue(){
        int output  = my.square(5);
        assertEquals(25,output);
    }

    //assertNotEquals - testib kahte tulemust lähtudes, et tuleb vale vastus
    //assertNotEquals(first, second)
    ////assertEquals(expected, actual)
    @Test
    public void squareTestFalse(){
        int output=my.square(5);
        assertNotEquals(24, output);
    }

    //assertArrayEquals-testib kahte array tulemust
    //assertArrayEquals(expected, actual)
    @Test
    public void toArrayTest(){
        int[] arr= new int[]{2,3,4,5};
        assertArrayEquals(arr, my.toArray(2,3,4,5));
    }

    //assertTrue - booleani testimine, kas tõsi 
    //assertTrue(condition)
    //assertTrue(message, condition);
    @Test
    public void trueTest(){
        assertTrue(true);
    }

    //assertFalse - booleani testimine, kas väär
    //assertFalse(condition)
    //assertFalse(message, condition);
    @Test
    public void falseTest(){
        assertFalse(false);
    }
    
    //assertNotNull - kontrollib väärtuse olemasolu
    //assertNotNull(object)
    @Test
    public void notNullTest(){
        int output=my.square(5);
        assertNotNull(output);
    }

    //assertNull - kontrollib väärtuse mitte olemasolu
    //assertNull(object)
    @Test
    public void nullTest(){
        assertNull(0);
    }

    //assertNotSame - kontrollib, kas objektid on identsed
    //assertNotSame(unexpected, actual)
    @Test
    public void notSameTest(){
        int output=my.square(5);
        assertNotSame(24, output);
    }

    
    //assertSame
    //assertThat
}
