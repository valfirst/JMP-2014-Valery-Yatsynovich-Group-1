package by.epam.bankexchange;

import java.math.BigDecimal;

import org.junit.Test;

import by.epam.bankexchange.entity.Currency;
import by.epam.bankexchange.entity.Money;
import junit.framework.TestCase;

public class MoneyTests extends TestCase
{
	
	@Test
	public void testMoneyGetAmount() throws Exception
	{
		BigDecimal amount = BigDecimal.TEN;
		Money money = new Money(Currency.USD, amount);
		
		assertEquals(amount, money.getAmount());
	}
	
	@Test
	public void testMoneyGetCurrency() throws Exception
	{
		Currency currency = Currency.RUR;
		Money money = new Money(currency, BigDecimal.TEN);
		
		assertEquals(currency, money.getCurrency());
	}
}
