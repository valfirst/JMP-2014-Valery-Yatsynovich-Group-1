package by.epam.bankexchange.entity;

import java.math.BigDecimal;

public class Money
{
	private Currency currency;
	private BigDecimal amount;
	
	public Money(Currency currency, BigDecimal amount)
	{
		this.currency = currency;
		this.amount = amount;
	}
	
	public BigDecimal getAmount()
	{
		return amount;
	}
	
	public Currency getCurrency()
	{
		return currency;
	}

	@Override
	public String toString()
	{
		return getAmount() + " " + getCurrency();
	}
}
