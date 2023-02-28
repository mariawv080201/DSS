
import org.junit.*;


public class CreditCardTest
{
    private CreditCard card;

    @Before
    public void setUp()
    {
        card = new CreditCard("Maria", "123F", 100);
    }

    @After
    public void tearDown()
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