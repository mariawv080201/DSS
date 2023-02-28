
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CreditCardTest
{
    private CreditCard card;

    @Before
    protected void setUp()
    {
        card = new CreditCard("Maria", "123F", 100);
    }

    @After
    protected void tearDown()
    {
        card = null;
    }

    @Test
    public void testBalance()
    {
        assertEquals("Balance is not correct", 100, card.getBalance());
    }

    @Test
    public void testDeposit()
    {
        card.deposit(100);
        assertEquals("Balance is not correct", 200, card.getBalance());
    }

    @Test
    public void testWithdraw()
    {
        card.withdraw(100);
        assertEquals("Balance is not correct", 100, card.getBalance());
    }
}