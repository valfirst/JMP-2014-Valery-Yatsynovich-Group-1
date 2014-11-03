package by.epam.bankexchange.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import by.epam.bankexchange.entity.Client;

public class BankStorage {

	private static Map<Long, Client> clientList = new HashMap<Long, Client>();

	public static Collection<Client> getClients()
	{
		return clientList.values();
	}

	public static void addClient(Client client)
	{
		clientList.put(client.getId(), client);
	}
	
	public static Client getClient(Long clientId)
	{
		return clientList.get(clientId);
	}

}
