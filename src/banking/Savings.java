package banking;

import banking.exceptions.DepositWithdrawTransferAmountNotPositiveException;

public class Savings extends Account
{
	private double intRate = 0.02;

	public double getIntRate()
	{
		return intRate;
	}

	private void setIntRate(double newIntRate)
	{
		intRate = newIntRate;
	}

	public void payInterest() throws DepositWithdrawTransferAmountNotPositiveException
	{
		deposit(getBalance() * getIntRate());
	}

	// constructors

	public Savings(String newDescription, double newIntRate)
	{
		this(newDescription);
		setIntRate(newIntRate);
	}

	public Savings(String newDescription)
	{
		super(newDescription);
	}

	public Savings()
	{
		super();
	}

}
