package banking;

import java.util.*;

import banking.exceptions.*;

//using composition
public class Checking
{
	private Account acct;
	private static int nextCheckNbr = 100;
	private static ArrayList<Check> chks = new ArrayList<Check>();
	
	public int getId()
	{
		return acct.getId();
	}
	
	public double getBalance()
	{
		return acct.getBalance();
	}
	
	public String getDescription()
	{
		return acct.getDescription();
	}
	
	public void setDescription(String newDescription)
	{
		acct.setDescription(newDescription);
	}
	
	public void deposit(double amount) throws DepositWithdrawTransferAmountNotPositiveException
	{
		acct.deposit(amount);
	}
	
	public void withdraw(double amount) throws DepositWithdrawTransferAmountNotPositiveException, InsufficientFundsException
	{
		acct.withdraw(amount);
	}
	
	public boolean transferTo(Account account, double amount) throws DepositWithdrawTransferAmountNotPositiveException
	{
		return acct.transferTo(account, amount);
	}
	
	public void writeCheck(String payee, double amount) throws DepositWithdrawTransferAmountNotPositiveException, InsufficientFundsException
	{
		Check chk = new Check(nextCheckNbr++, new Date(), amount, this.getId(), payee);
		chks.add(chk);
		this.withdraw(amount);
	}
	
	//ctors
	public Checking()
	{
		acct = new Account();
	}
	public Checking(String newDescription)
	{
		acct = new Account(newDescription);
	}
}
