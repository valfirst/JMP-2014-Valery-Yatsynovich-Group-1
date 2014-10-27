package by.epam.bankexchange.main;

import java.math.BigDecimal;

import by.epam.bankexchange.entity.Account;
import by.epam.bankexchange.entity.Client;
import by.epam.bankexchange.entity.Currency;
import by.epam.bankexchange.entity.Money;
import by.epam.bankexchange.exception.PaymentOperationException;
import by.epam.bankexchange.storage.BankStorage;
import by.epam.bankexchange.util.MoneyExchange;

public class Main {

	public static void main(String[] args)
	{
		initApplication();
		
		Client client = BankStorage.getClients().iterator().next();
		Account newAcc = new Account(Currency.USD);
		client.addAccount(newAcc);
		
		try
		{
			MoneyExchange.exchangeFromToAccounts(client.getAccountByCurrency(Currency.RUR), newAcc, BigDecimal.TEN);
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private static void initApplication()
	{
		Long clientId1 = 11111111l;
		Client client = new Client(clientId1, "Ivanov Ivan Ivanovich");
		BankStorage.addClient(client);
		Account account = new Account(Currency.RUR);
		BankStorage.getClient(clientId1).addAccount(account);
		try
		{
			account.putMoney(new Money(Currency.RUR, new BigDecimal(1000)));
		}
		catch (PaymentOperationException e)
		{
			e.printStackTrace();
		}
	}
}
