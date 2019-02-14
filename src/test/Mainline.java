package test;

import banking.Savings;
import banking.exceptions.DepositWithdrawTransferAmountNotPositiveException;
import banking.exceptions.InsufficientFundsException;

public class Mainline
{

	public static void main(String[] args)
	{

		Savings acct = new Savings("My 1st Savings Account");
		Savings sav = new Savings("My 2nd Savings Account");
		try
		{
			acct.deposit(1000);
			acct.withdraw(200);
			acct.payInterest();
			System.out.println("Balance is: " + acct.getBalance());
			acct.deposit(100);
			acct.withdraw(100);
			boolean success = acct.transferTo(sav, 500);
			System.out.println("Transfer was a success = " + success);
			System.out.println("Balance in acct is: " + acct.getBalance());
			System.out.println("Balance in sav is: " + sav.getBalance());

		} catch (InsufficientFundsException e)
		{
			System.out.println(e.getMessage());
		} catch (DepositWithdrawTransferAmountNotPositiveException e)
		{
			System.out.println(e.getMessage());
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

}
