package banking;

import banking.exceptions.DepositWithdrawTransferAmountNotPositiveException;
import banking.exceptions.InsufficientFundsException;

public class Account
{

	private static int nextId = 1;

	private int id;
	private double balance;
	private String description;

	// in c# public int id {get;set;}
	public int getId()
	{
		return id;
	}

	public double getBalance()
	{
		return balance;
	}

	private void setBalance(double newBalance)
	{
		balance = newBalance;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String newDescription)
	{
		description = newDescription;
	}

	public void deposit(double amount) throws DepositWithdrawTransferAmountNotPositiveException
	{
		checkAmountGtZero(amount);
		setBalance(getBalance() + amount);
	}

	public void withdraw(double amount)
			throws DepositWithdrawTransferAmountNotPositiveException, InsufficientFundsException
	{
		checkAmountGtZero(amount);
		if (getBalance() < amount)
		{
			throw new InsufficientFundsException("Insufficient funds");
		}
		setBalance(getBalance() - amount);
	}

	private void checkAmountGtZero(double amount) throws DepositWithdrawTransferAmountNotPositiveException
	{
		if (amount <= 0)
		{
			// throw exception
			throw new DepositWithdrawTransferAmountNotPositiveException("Amount must be positive.");
		}
	}

	public boolean transferTo(Account account, double amount) throws DepositWithdrawTransferAmountNotPositiveException
	{
		try
		{
			withdraw(amount);
		} catch (InsufficientFundsException e)
		{
			return false;
		}
		account.deposit(amount);
		return true;

	}

	// constructors
	// in c# public Account(string NewDescription) : this()
	public Account(String newDescription)
	{
		this();
		description = newDescription;
	}

	public Account()
	{

		id = nextId++;
		balance = 0;
		description = "*New Account*";
	}

}
