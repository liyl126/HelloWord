//package  com.mytest;
//import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;
import java.util.Formatter;

public class SaleWindow implements Runnable {
    private int ticketCount = 30;
	private HashMap<String,Integer> threadCount;
	//private Map<String,Integer> threadCount;
	
	public void PrintResut()
	{
		System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + " HashMap value = "+threadCount);
	}
 
    @Override
    public void run() {
        // TODO Auto-generated method stub

        for (int i = 0; i < 30; i++) {
            saleticket();
        }
    }
	
	private synchronized void saleticket(){
		if (ticketCount > 0) {
			
			
			String thid = Long.toString(Thread.currentThread().getId());
			Integer iv = 1;
			try
			{
				if (threadCount == null)
				{
					threadCount = new HashMap<String,Integer>();
				}
				else
				{
					iv = (Integer)threadCount.get(thid);
					if (null == iv)
					{
						iv = 1;
					}
					else
					{
						iv++;
					}
				}
				System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + "  Âô³öµÚ  "  + ticketCount-- + "  ÕÅÆ±  ");
				try{
					threadCount.put(thid,iv);
				}
				catch(Exception e){
					System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + " Exception threadCount.put(thid,iv) ");
					e.printStackTrace();
				}
			}
			catch(Exception e){
				System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + " Exception others ");
				e.printStackTrace();
			}
			//ticketCount--;
			try {
				Thread.sleep(50); 
			} catch (InterruptedException e) {
				System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + " Exception Thread.sleep ");
				e.printStackTrace();
			}
		}
	}
	
	// join(milli) test
	public void TestThread()
	{
		JoinParameter t= new JoinParameter();  
        t.start();  
        try {  
            t.join(2000);  
        } catch (InterruptedException e) {  
                e.printStackTrace();  
        }   
        for(int i = 0 ; i < 5 ; i++){  
            try {  
				t.sleep(1000);  
			} catch (InterruptedException e) {  
                e.printStackTrace();  
			} 
            System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + " " + i);  
        }
		System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + " End");  
		try {  
            t.join();  
        } catch (InterruptedException e) {  
                e.printStackTrace();  
        }  		
	}
	
 }
 
class JoinParameter extends Thread{  
    public void run(){  
        for(int i = 0 ; i < 10 ;i++){  
			System.out.println("ThreadID:["+ Thread.currentThread().getId()+"] "+Thread.currentThread().getName() + " " + i);  

            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
          
        }  
    }  
}  

class DatetimeTest{
	public long getMillis(){
		long dts = System.currentTimeMillis();
		//System.out.println("dts:"+dts + " String format:"+String.valueOf(dts));
		return dts; // String.valueOf(dts);
	}
	
	public String formatTest(){
		StringBuilder stringBuilder = new StringBuilder();

        Formatter formatter = new Formatter(stringBuilder);
	    System.out.println("\nUsage:\n tr  hour and minute\n "+
"tA  the day of the week\n "+
"tB  the name of the month\n "+
"te  the number of the day of the month\n "+
"tY  the year");
		formatter.format("\nFormat[Right now it is %%tr on %%<tA, %%<tB %%<te, %%<tY.%%n]\nRight now it is %tr on " +

                         "%<tA, %<tB %<te, %<tY.%n",

                         Calendar.getInstance());
		System.out.println(stringBuilder);
		return stringBuilder.toString();
	}
	
}


