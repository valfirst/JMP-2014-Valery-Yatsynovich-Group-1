package by.epam.bankexchange;

import java.math.BigDecimal;

import org.junit.Test;

import by.epam.bankexchange.entity.Account;
import by.epam.bankexchange.entity.Currency;
import by.epam.bankexchange.entity.Money;
import by.epam.bankexchange.exception.InvalidInputException;
import by.epam.bankexchange.exception.PaymentOperationException;

import junit.framework.TestCase;

public class AccountTests  extends TestCase
{

	@Test
	public void testNewAccountCurrency() throws Exception
	{
		Currency currency = Currency.EUR;
		
		Account acc = new Account(currency);
		assertEquals(currency, acc.getAccountMoney().getCurrency());
	}
	
	@Test
	public void testNewAccountZeroAmount() throws Exception
	{
		Account acc = new Account(Currency.USD);
		assertEquals(BigDecimal.ZERO, acc.getAccountMoney().getAmount());
	}
	
	@Test
	public void testNewAccountInvalidInput() throws Exception
	{
		try 
		{
			new Account(null);
		}
		catch (InvalidInputException e) 
		{
			assertTrue("InvalidInputException was thrown", true);
			return;
		}
		fail("InvalidInputException wasn't thrown");
	}
	
	@Test
	public void testAccountPutMoney() throws Exception
	{
		Currency currency = Currency.EUR;
		BigDecimal amount = BigDecimal.TEN;
		
		Money money = new Money(currency, amount);
		Account acc = new Account(Currency.EUR);
		
		acc.putMoney(money);
		
		assertEquals(amount, acc.getAccountMoney().getAmount());
	}
	
	@Test
	public void testAccountPutMoneyInvalidInput() throws Exception
	{
		Account acc = new Account(Currency.USD);
		try 
		{
			acc.putMoney(null);
		}
		catch (InvalidInputException e) 
		{
			assertTrue("InvalidInputException was thrown", true);
			return;
		}
		fail("InvalidInputException wasn't thrown");
	}

	@Test
	public void testAccountPutMoneyCurrencyMissmatch() throws Exception
	{
		Account acc = new Account(Currency.USD);
		try 
		{
			acc.putMoney(new Money(Currency.RUR, BigDecimal.TEN));
		}
		catch (PaymentOperationException e) 
		{
			assertTrue("PaymentOperationException was thrown", true);
			return;
		}
		fail("PaymentOperationException wasn't thrown");
	}
	
	@Test
	public void testAccountPutMoneyOverrefund() throws Exception
	{
		Account acc = new Account(Currency.USD);
		try 
		{
			acc.putMoney(new Money(Currency.USD, BigDecimal.TEN.negate()));
		}
		catch (PaymentOperationException e) 
		{
			assertTrue("PaymentOperationException was thrown", true);
			return;
		}
		fail("PaymentOperationException wasn't thrown");
	}
}
