package basics.BaseCourse.Testing.JUnit._2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UtilitiesTest {


    private Utilities utilities;

    @Before
    public void setup() {
        utilities = new Utilities();
    }

    @Test
    public void everyNthChar() {
        assertArrayEquals(new char[]{'e', 'l'},
                utilities.everyNthChar(new char[]{'h', 'e', 'l', 'l', '0'}, 2));
        char[] ch = new char[]{'a', 'b', 'c'};
        assertArrayEquals(ch, utilities.everyNthChar(ch, 4));
    }

    @Test
    public void removePairs() {
        assertEquals("ABCD", utilities.removePairs("AAABCCCCCDDD"));
        assertNull("Did not get null returned", utilities.removePairs(null));
    }

    @Test
    public void converter() {
        assertEquals(300, utilities.converter(10, 5));
    }

    @Test(expected = ArithmeticException.class)
    public void converter_exception() {
        utilities.converter(10, 0);
    }

    @Test
    public void nullIfOddLength() {
        assertNull(utilities.nullIfOddLength("Odd"));
        assertEquals("String", utilities.nullIfOddLength("String"));
    }
}