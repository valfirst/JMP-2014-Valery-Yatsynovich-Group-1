package by.epam.bankexchange;

import java.math.BigDecimal;

import org.junit.Test;

import by.epam.bankexchange.entity.Account;
import by.epam.bankexchange.entity.Currency;
import by.epam.bankexchange.entity.Money;
import by.epam.bankexchange.util.CurrencyRate;
import by.epam.bankexchange.util.MoneyExchange;
import junit.framework.TestCase;

public class MoneyExchangeTests extends TestCase
{

	@Test
	public void testCalculateExchange() throws Exception
	{
		Currency from = Currency.USD;
		Currency to = Currency.EUR;
		BigDecimal toAmount = BigDecimal.valueOf(100);

		BigDecimal rate = CurrencyRate.getCurrencyRate(from, to);
		BigDecimal actualRate = MoneyExchange.calculateExchange(from, to, toAmount);
		
		assertEquals(toAmount.multiply(rate), actualRate);
	}
	
	@Test
	public void testTransfer() throws Exception
	{
		Account from = new Account(Currency.USD);
		BigDecimal fromBalance = new BigDecimal(100);
		from.putMoney(new Money(Currency.USD, fromBalance));
		Account to = new Account(Currency.EUR);
		BigDecimal toAmount =BigDecimal.TEN;
		
		MoneyExchange.exchangeFromToAccounts(from, to, toAmount);

		assertTrue(from.getAccountMoney().getAmount().compareTo(new BigDecimal(100)) == -1);
		assertEquals(toAmount, to.getAccountMoney().getAmount());
	}
}
