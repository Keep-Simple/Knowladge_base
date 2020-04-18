package BaseCourse.Testing.JUnit._1;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BankAccountTestParametrized {

    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParametrized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @Before
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testCond() {
        return Arrays.asList(new Object[][]{
                {100, true, 1100},
                {200, true, 1200},
                {325.14, true, 1489.33},
                {1000, true, 2000}
        });
    }

    @Test
    public void deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .0001);
    }
}
