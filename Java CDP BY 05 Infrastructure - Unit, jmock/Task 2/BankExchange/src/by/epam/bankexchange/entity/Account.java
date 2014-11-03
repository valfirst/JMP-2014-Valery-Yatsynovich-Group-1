package by.epam.bankexchange.entity;

import java.math.BigDecimal;

import by.epam.bankexchange.exception.InvalidInputException;
import by.epam.bankexchange.exception.PaymentOperationException;

public class Account
{
	private final static String CURRENCY_MISSMATCH_EXCEPTION = "Currency in operation don't match "
			+ "to currency in account";
	private final static String NOT_ENOUGHT_MONEY_EXCEPTION = "Not enought money to complete operation";
	
	private Money accountMoney;

	public Account(Currency currency)
	{
		if (currency == null)
		{
			throw new InvalidInputException();
		}
		accountMoney = new Money(currency, BigDecimal.ZERO);
	}
	
	public Money getAccountMoney()
	{
		return accountMoney;
	}

	public synchronized void putMoney(Money money) throws PaymentOperationException
	{
		if (money == null)
		{
			throw new InvalidInputException();
		}
		
		if (accountMoney.getCurrency() != money.getCurrency())
		{
			throw new PaymentOperationException(CURRENCY_MISSMATCH_EXCEPTION);
		}
		
		BigDecimal newAmount = accountMoney.getAmount().add(money.getAmount());
		if (newAmount.compareTo(BigDecimal.ZERO) < 0)
		{
			throw new PaymentOperationException(NOT_ENOUGHT_MONEY_EXCEPTION);
		}
		
		accountMoney = new Money(accountMoney.getCurrency(), newAmount);
		System.out.printf("\nMoney transfer of %s to Account completed. Current balance: %s", money, accountMoney);
	}

}
