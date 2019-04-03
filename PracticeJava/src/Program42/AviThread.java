package Program42;

public class AviThread extends Thread 
{

	private YossiThread yossiThread;
	
	public AviThread(YossiThread yossiThread) 
	{
		this.yossiThread = yossiThread;
	}
	
	public void run()
	{
		
		try 
		{		
			this.yossiThread.aviStartedWorkingOnIt();
			Thread.sleep(5000);
			this.yossiThread.aviSentAReply();			
			
		} catch (InterruptedException e) 
		{
			System.out.println(e.getMessage());			
		}
	}	

}
