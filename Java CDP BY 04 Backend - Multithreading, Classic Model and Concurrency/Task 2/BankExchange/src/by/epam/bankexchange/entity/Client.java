package by.epam.bankexchange.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Client {

	private Long id;
	private String fio;
	
	private Map<Currency, Account> accounts = new HashMap<Currency, Account>();

	public Client(Long id, String fio)
	{
		this.id = id;
		this.fio = fio;
		
		System.out.printf("\nNew Client created: Id=%s, FIO=%s", id, fio);
	}
	
	public Long getId()
	{
		return id;
	}

	public String getFio()
	{
		return fio;
	}

	public void setFio(String fio)
	{
		this.fio = fio;
	}

	public Set<Entry<Currency, Account>> getAccounts()
	{
		return accounts.entrySet();
	}

	public  Account getAccountByCurrency(Currency currency)
	{
		return accounts.get(currency);
	}
	
	public void addAccount(Account account)
	{
		accounts.put(account.getAccountMoney().getCurrency(), account);
		System.out.printf("\nAccount with Currency=%s added for Client: Id=%s, FIO=%s", account.getAccountMoney().getCurrency(), getId(), getFio());
	}

}
