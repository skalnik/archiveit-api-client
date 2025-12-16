package lu.bnl.archiveit.client.test;
import java.util.List;

import lu.bnl.archiveit.client.ArchiveitClient;
import lu.bnl.archiveit.client.model.Account;
import lu.bnl.archiveit.client.model.Collection;
import lu.bnl.archiveit.client.model.Seed;
import lu.bnl.archiveit.client.model.Warc;

public class AppTest 
{

	// Test connection parameters.
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	public static void main(String[] args)
	{
		try
		{
			testGetWarcs();
		}
		catch (Exception e)
		{
			System.out.println("Test FAILED: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static void testAuthentication() throws Exception
	{
		ArchiveitClient client = new ArchiveitClient(USERNAME, PASSWORD);
		client.connect();
		
		System.out.println();
	}
	
	private static void testGetWarcs() throws Exception
	{
		ArchiveitClient client = new ArchiveitClient(USERNAME, PASSWORD);
		client.connect();
		
		List<Warc> warcs = client.getWarcService().getWarcsByCollectionId(13253);
		
		for (Warc warc : warcs)
		{
			System.out.println(warc.toString());
		}
	}
	
	private static void testGetAccount() throws Exception
	{
		ArchiveitClient client = new ArchiveitClient(USERNAME, PASSWORD);
		client.connect();
		
		Account account = client.getAccountService().getMyAccount();
		
		if (account != null)
			System.out.println(account.toString());
		else
			System.out.println("No results");
	}
	
	private static void testGetCollection() throws Exception
	{
		ArchiveitClient client = new ArchiveitClient(USERNAME, PASSWORD);
		client.connect();
		
		Collection collection = client.getCollectionService().getCollectionById(13253);
		
		if (collection != null)
			System.out.println(collection.toString());
		else
			System.out.println("No results");
	}
	
	private static void testGetCollectionsInAccount() throws Exception
	{
		ArchiveitClient client = new ArchiveitClient(USERNAME, PASSWORD);
		client.connect();
		
		List<Collection> collections = client.getCollectionService().getCollectionsByAccountId(1687);
		
		for (Collection collection : collections)
		{
			System.out.println(collection.toString());
		}
		
		System.out.println("Total: " + collections.size());
	}
	
	private static void testGetSeed() throws Exception
	{
		ArchiveitClient client = new ArchiveitClient(USERNAME, PASSWORD);
		client.connect();
		
		Seed seed = client.getSeedService().getSeedById(0);
		
		if (seed != null)
			System.out.println(seed.toString());
		else
			System.out.println("No results");
	}
		
	private static void testGetSeedsInCollection() throws Exception
	{
		ArchiveitClient client = new ArchiveitClient(USERNAME, PASSWORD);
		client.connect();
		
		List<Seed> seeds = client.getSeedService().getSeedsByCollectionId(13253);
		
		for (Seed seed : seeds)
		{
			System.out.println(seed.toString());
		}
		
		System.out.println("Total: " + seeds.size()); 
	}
	
}
