package by.epam.bankexchange;

import org.junit.Test;

import by.epam.bankexchange.entity.Client;
import by.epam.bankexchange.storage.BankStorage;
import junit.framework.TestCase;

public class BankStorageTests extends TestCase
{

	@Test
	public void testBankStorageAddClients() throws Exception
	{
		int size = 5;
		int currentSize = BankStorage.getClients().size();

		for (int i = 0; i < size; i++)
		{
			BankStorage.addClient(new Client(Long.valueOf(100l + i ), "FIO"));
		}
		
		assertEquals(size + currentSize, BankStorage.getClients().size());
	}
	
	@Test
	public void testBankStorageAddDuplicate() throws Exception
	{
		int currentSize = BankStorage.getClients().size();

		for (int i = 0; i < 2; i++)
		{
			BankStorage.addClient(new Client(Long.valueOf(200), "FIO"));
		}
		
		assertEquals(currentSize + 1, BankStorage.getClients().size());
	}
	
	@Test
	public void testBankStorageGetAccount() throws Exception
	{
		Long id =Long.valueOf(300l);

		BankStorage.addClient(new Client(Long.valueOf(id), "FIO"));
		
		assertNotNull(BankStorage.getClient(id));
	}
}
