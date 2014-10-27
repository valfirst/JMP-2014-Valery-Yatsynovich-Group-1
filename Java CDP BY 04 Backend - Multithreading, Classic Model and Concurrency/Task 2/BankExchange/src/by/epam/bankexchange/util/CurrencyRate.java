package by.epam.bankexchange.util;

import java.math.BigDecimal;

import by.epam.bankexchange.entity.Currency;

public class CurrencyRate
{

	private static BigDecimal[][] rates = new BigDecimal[][]{
			{BigDecimal.ONE, BigDecimal.valueOf(1.27052), BigDecimal.valueOf(0.023858)}, 
			{BigDecimal.valueOf(0.787079306), BigDecimal.ONE, BigDecimal.valueOf(0.0187781381)},
			{BigDecimal.valueOf(41.9146617), BigDecimal.valueOf(53.253416), BigDecimal.ONE}};
	
	public static BigDecimal getCurrencyRate(Currency from, Currency to)
	{
		return rates[from.getId()][to.getId()];
	}

}
