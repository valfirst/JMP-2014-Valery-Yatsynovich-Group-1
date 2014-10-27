package by.epam.bankexchange.util;

import java.math.BigDecimal;

import by.epam.bankexchange.entity.Account;
import by.epam.bankexchange.entity.Currency;
import by.epam.bankexchange.entity.Money;
import by.epam.bankexchange.exception.PaymentOperationException;

public class MoneyExchange {

	public static void exchangeFromToAccounts(Account from, Account to, BigDecimal toAmount) throws PaymentOperationException
	{
		Currency fromCurrency = from.getAccountMoney().getCurrency();
		Currency toCurrency = to.getAccountMoney().getCurrency();
		
		Money toMoney = new Money(toCurrency, toAmount);
		Money fromMoney = new Money(fromCurrency, calculateExchange(fromCurrency, toCurrency, toAmount).negate());
		
		from.putMoney(fromMoney);
		to.putMoney(toMoney);
	}

	private static BigDecimal calculateExchange(Currency from, Currency to, BigDecimal toAmount)
	{
		BigDecimal currencyRate = CurrencyRate.getCurrencyRate(from, to);
		System.out.printf("\nGeting %s to %s convertion coefficient: %s", from, to, currencyRate.toString());
		
		return toAmount.multiply(currencyRate);
	}
}
