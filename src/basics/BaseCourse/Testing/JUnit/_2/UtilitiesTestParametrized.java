package basics.BaseCourse.Testing.JUnit._2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class UtilitiesTestParametrized {
    private String input;
    private String output;
    private Utilities utl;

    public UtilitiesTestParametrized(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Before
    public void setUp() throws Exception {
        utl = new Utilities();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][] {
                {"ABCDEFF","ABCDEF"},
                {"AB88EFFG","AB8EFG"},
                {"112233445566","123456"},
                {"ZYZQQB","ZYZQB"},
                {"A","A"}
        });
    }


    @Test
    public void removePairs() {
        assertEquals(output, utl.removePairs(input));
    }
}