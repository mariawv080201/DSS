
public class CreditCard
{
    private String id;
    private String owner;
    private double balance;

    public CreditCard(String id, String owner, double balance)
    {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public double getBalance()
    {
        return balance;
    }

    public double deposit(double amount)
    {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount)
    {
        balance -= amount;
        return balance;
    }
}