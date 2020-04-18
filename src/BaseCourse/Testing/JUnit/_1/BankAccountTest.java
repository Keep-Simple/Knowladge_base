package BaseCourse.Testing.JUnit._1;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BankAccountTest {

    private BankAccount account;

    @BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases");
    }

    @Before
    //runs before every method test
    public void setup() {
        account = new BankAccount("Tim", "Buchalka", 1000.00, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200.00, balance, 0);
    }

    /**
     * If exception occurred test must pass -  use expected = Exception.class
     */
    @Test(expected = IllegalArgumentException.class)
    public void withdraw() {
        account.withdraw(600, false);
    }

    @Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @Test
    public void isChecking_true() {
        //assertEquals(true, account.isChecking());
        //better way, first param is to print in false case
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("This execute after any test cases");
    }


}