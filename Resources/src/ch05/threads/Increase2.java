package ch05.threads;


public class Increase2 implements Runnable
{
	private SyncCounter c;
	private int amount;

	public Increase2 (SyncCounter sc, int amount)
	{
		this.c = sc;
		this.amount = amount;
	}
	
	public void run()
	{
		for (int i = 1; i <= amount; i++)
			c.increment();
	}
}