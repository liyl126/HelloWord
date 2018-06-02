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

class PrimitiveOverloading {
// boolean can't be automatically converted
	static void prt(String s) {
		System.out.println(s);
	}
	private void f1(char x) { prt("f1(char)"); }
	private void f1(byte x) { prt("f1(byte)"); }
	private void f1(short x) { prt("f1(short)"); }
	private void f1(int x) { prt("f1(int)"); }
	private void f1(long x) { prt("f1(long)"); }
	private void f1(float x) { prt("f1(float)"); }
	private void f1(double x) { prt("f1(double)"); }
	
	private void f2(byte x) { prt("f2(byte)"); }
	private void f2(short x) { prt("f2(short)"); }
	private void f2(int x) { prt("f2(int)"); }
	private void f2(long x) { prt("f2(long)"); }
	private void f2(float x) { prt("f2(float)"); }
	private void f2(double x) { prt("f2(double)");}
	
	private void f3(short x) { prt("f3(short)"); }
	private void f3(int x) { prt("f3(int)"); }
	private void f3(long x) { prt("f3(long)"); }
	private void f3(float x) { prt("f3(float)"); }
	private void f3(double x) { prt("f3(double)"); }
	
	private void f4(int x) { prt("f4(int)"); }
	private void f4(long x) { prt("f4(long)"); }
	private void f4(float x) { prt("f4(float)"); }
	private void f4(double x) { prt("f4(double)"); }
	
	private void f5(long x) { prt("f5(long)"); }
	private void f5(float x) { prt("f5(float)"); }
	private void f5(double x) { prt("f5(double)"); }
	
	private void f6(float x) { prt("f6(float)"); }
	private void f6(double x) { prt("f6(double)"); }
	
	private void f7(double x) { prt("f7(double)"); }
	
	private void fx1(char x)   { prt("fx1(char)"); }
	private void fx1(byte x)   { prt("fx1(byte)"); }
	private void fx1(short x)  { prt("fx1(short)"); }
	private void fx1(int x)    { prt("fx1(int)"); }
	private void fx1(long x)   { prt("fx1(long)"); }
	private void fx1(float x)  { prt("fx1(float)"); }
	private void fx1(double x) { prt("fx1(double)"); }
	
	private void fx2(char x)   { prt("fx2(char)"); }
	private void fx2(byte x)   { prt("fx2(byte)"); }
	private void fx2(short x)  { prt("fx2(short)"); }
	private void fx2(int x)    { prt("fx2(int)"); }
	private void fx2(long x)   { prt("fx2(long)"); }
	private void fx2(float x)  { prt("fx2(float)"); }
	
	private void fx3(char x)   { prt("fx3(char)"); }
	private void fx3(byte x)   { prt("fx3(byte)"); }
	private void fx3(short x)  { prt("fx3(short)"); }
	private void fx3(int x)    { prt("fx3(int)"); }
	private void fx3(long x)   { prt("fx3(long)"); }
	
	private void fx4(char x)   { prt("fx4(char)"); }
	private void fx4(byte x)   { prt("fx4(byte)"); }
	private void fx4(short x)  { prt("fx4(short)"); }
	private void fx4(int x)    { prt("fx4(int)"); }
	
	private void fx5(char x)   { prt("fx5(char)"); }
	private void fx5(byte x)   { prt("fx5(byte)"); }
	private void fx5(short x)  { prt("fx5(short)"); }
	
	private void fx6(char x)   { prt("fx6(char)"); }
	private void fx6(byte x)   { prt("fx6(byte)"); }
	
	private void fx7(char x)   { prt("fx7(char)"); }
	
	public void testDoubleConvert() {
		double x = 0;
		prt("\ndouble argument:(double)x");
		fx1(x);fx2((float)x);fx3((long)x);fx4((int)x);
		fx5((short)x);fx6((byte)x);fx7((char)x);
	}
	
	void testConstVal() {
		prt("\nConstVal Testing with 5");
			f1(5);f2(5);f3(5);f4(5);f5(5);f6(5);f7(5);
	}
	void testChar() {
		char x = 'x';
		prt("\nchar argument:'x'");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	void testByte() {
		byte x = 0;
		prt("\nbyte argument:0");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	void testShort() {
		short x = 0;
		prt("\nshort argument:0");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	void testInt() {
		int x = 0;
		prt("\nint argument:0");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	void testLong() {
		long x = 0;
		prt("\nlong argument:0");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	void testFloat() {
		float x = 0;
		prt("\nfloat argument:0");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}
	void testDouble() {
		double x = 0;
		prt("\ndouble argument:0");
		f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
	}	
}


