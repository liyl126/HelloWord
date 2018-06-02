//package  com.mytest;
/*
//JDK 1.8
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

JDK1.7
import java.util.LocalDate;
import java.util.ZoneId;
import java.util.ZonedDateTime;
*/
// import java.util.LocalDate;
// import java.util.ZoneId;
// import java.util.ZonedDateTime;
// import java.util.Date;

public class HelloWorld
{
	
	public static void main(String[] args)
	{
		publictest pt = new publictest();
		System.out.println("HelloWorld");
		int il=1000;
		long l1 = 8888888998888l;
		char c1='\u534e';
		byte b1=10;
		byte b2=20;
		byte b3=0;
		b3=(byte)(b1+b2);
		System.out.println("il:"+il);
		System.out.println("l1:"+l1);
		System.out.println("c1:"+c1);
		System.out.println("b3:"+b3);
		
		float f1 = 0.9891f,f2;
		f2 = f1+78484;
		System.out.println("f2:"+f2);
		
		for (int i =3 ;i < 100; i+=2)
		{
			boolean f = true; 
			for (int j=2; j<i; j++)
			{
				if (i%j==0)
				{
					f = false;
					break;
				}
			}
			if (!f){continue;}
			System.out.println("输出值："+i);
			
		}
		pt.DatetimeTestfn();
		
		pt.BaseDataTypeInfo();
		pt.DatetimeTestfn();
		
		pt.ThreadSynTest();
		pt.DatetimeTestfn();

		pt.objectRefTest();
		pt.DatetimeTestfn();
		
		pt.PrintProperties();
		pt.DatetimeTestfn();
		
		pt.dataTypeTest();
		pt.DatetimeTestfn();
		//<< test
		// OperationTest();
		
		//mu thread test
		//ThreadTest(true);
		//pt.DatetimeTestfn();
		
		//ThreadTest(false);
		//pt.DatetimeTestfn();
		
		System.out.println(" ################## Main end ################## ");
	
	}
		
	private static void ThreadTest(boolean IsJoinTest)
	{
		SaleWindow sw = new SaleWindow();
		if (IsJoinTest){
				sw.TestThread();
		}
		else
		{
			Thread t1 = new Thread(sw);
			Thread t2 = new Thread(sw);
			Thread t3 = new Thread(sw);
			t1.setName("线程A");
			t2.setName("线程B");
			t3.setName("线程C");
			t3.start();
			t2.start();
			t1.start();
			
			try
			{
				t1.join();
				t2.join();
				t3.join();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			sw.PrintResut();
		}

	}
	

	
	private static void OperationTest()
	{	
		int capacity = 3;
		capacity <<= 1;
		System.out.println("capacity:"+capacity);
		capacity <<= 1;
		System.out.println("capacity:"+capacity);
		capacity <<= 1;
		System.out.println("capacity:"+capacity);
		capacity <<= 1;
		System.out.println("capacity:"+capacity);
		capacity <<= 2;
		System.out.println("capacity<<2:"+capacity);
		capacity <<= 5;
		System.out.println("capacity<<5:"+capacity);
	}
}

class HelloWorld1{
	static void printme()
	{
		System.out.println("HelloWorld1");
	}
}

