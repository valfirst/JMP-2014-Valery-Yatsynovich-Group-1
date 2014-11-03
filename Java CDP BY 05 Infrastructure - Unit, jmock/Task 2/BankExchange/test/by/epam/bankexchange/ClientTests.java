package by.epam.bankexchange;

import org.junit.Test;

import by.epam.bankexchange.entity.Account;
import by.epam.bankexchange.entity.Client;
import by.epam.bankexchange.entity.Currency;
import junit.framework.TestCase;

public class ClientTests extends TestCase
{
	@Test
	public void testClientGetId() throws Exception
	{
		Long id = Long.valueOf(123456l);
		Client client = new Client(id, "FIO");
		
		assertTrue(id.equals(client.getId()));
	}
	
	@Test
	public void testClientGetFio() throws Exception
	{
		String fio = "asdf";
		Client client = new Client(Long.valueOf(123l), "FIO");
		
		client.setFio(fio);
		
		assertTrue(fio.equals(client.getFio()));
	}
	
	@Test
	public void testClientAddAccounts() throws Exception
	{
		Client client = new Client(Long.valueOf(123l), "FIO");
		
		Account account1 = new Account(Currency.USD);
		client.addAccount(account1);
		Account account2 = new Account(Currency.EUR);
		client.addAccount(account2);

		assertEquals(2, client.getAccounts().size());
	}
}
