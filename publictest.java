//package  com.mytest;
// import DatetimeTest;
import java.util.*;
public class publictest
{
	private long bgdt=0;
	private long predt=0;
	private DatetimeTest dt;
	
	public publictest()
	{
		System.out.println("publictest create ");
		//DatetimeTest 
		dt = new DatetimeTest();
		bgdt = dt.getMillis();
		predt = bgdt; 
		System.out.println("Current Millis = "+bgdt);
	}
	
	public int objectRefTest(){
		String strBuff = new String("This is test String.");
		objectRefModifyTest(strBuff);
		System.out.printf("call after String is：%s  length=%d%n",strBuff,strBuff.length());
		return strBuff.length();
	}
	
	private int objectRefModifyTest (String aRef){
		System.out.printf("mobdify before String is：%s  length=%d%n",aRef,aRef.length());
		aRef += " add String!";
		System.out.printf("modify after String is：%s  length=%d%n",aRef,aRef.length());
		return aRef.length();
	}
	
	public void DatetimeTestfn(){
		//DatetimeTest 
		//dt = new DatetimeTest();
		long temp = dt.getMillis();
		if (predt == 0){
			System.out.println("Current Millis = "+temp);
		}
		else
		{
			System.out.println("Current Millis = "+temp+ " Current Millis=" + (temp-predt) + " Total Millis=" +(temp-bgdt) );
		}
		predt = temp;
		
		dt.formatTest();
		System.out.println("\n\n*****************************************************\n");
	}
	
	public void BaseDataTypeInfo(){
		 System.out.println("基本类型演示");  
		 // byte  
        System.out.println("基本类型：byte 二进制位数：" + Byte.SIZE);  
        System.out.println("包装类：java.lang.Byte");  
        System.out.println("最小值：Byte.MIN_VALUE=" + Byte.MIN_VALUE);  
        System.out.println("最大值：Byte.MAX_VALUE=" + Byte.MAX_VALUE);  
        System.out.println();  
  
        // short  
        System.out.println("基本类型：short 二进制位数：" + Short.SIZE);  
        System.out.println("包装类：java.lang.Short");  
        System.out.println("最小值：Short.MIN_VALUE=" + Short.MIN_VALUE);  
        System.out.println("最大值：Short.MAX_VALUE=" + Short.MAX_VALUE);  
        System.out.println();  
  
        // int  
        System.out.println("基本类型：int 二进制位数：" + Integer.SIZE);  
        System.out.println("包装类：java.lang.Integer");  
        System.out.println("最小值：Integer.MIN_VALUE=" + Integer.MIN_VALUE);  
        System.out.println("最大值：Integer.MAX_VALUE=" + Integer.MAX_VALUE);  
        System.out.println();  
  
        // long  
        System.out.println("基本类型：long 二进制位数：" + Long.SIZE);  
        System.out.println("包装类：java.lang.Long");  
        System.out.println("最小值：Long.MIN_VALUE=" + Long.MIN_VALUE);  
        System.out.println("最大值：Long.MAX_VALUE=" + Long.MAX_VALUE);  
        System.out.println();  
  
        // float  
        System.out.println("基本类型：float 二进制位数：" + Float.SIZE);  
        System.out.println("包装类：java.lang.Float");  
        System.out.println("最小值：Float.MIN_VALUE=" + Float.MIN_VALUE);  
        System.out.println("最大值：Float.MAX_VALUE=" + Float.MAX_VALUE);  
        System.out.println();  
  
        // double  
        System.out.println("基本类型：double 二进制位数：" + Double.SIZE);  
        System.out.println("包装类：java.lang.Double");  
        System.out.println("最小值：Double.MIN_VALUE=" + Double.MIN_VALUE);  
        System.out.println("最大值：Double.MAX_VALUE=" + Double.MAX_VALUE);  
        System.out.println();  
  
        // char  
        System.out.println("基本类型：char 二进制位数：" + Character.SIZE);  
        System.out.println("包装类：java.lang.Character");  
        // 以数值形式而不是字符形式将Character.MIN_VALUE输出到控制台  
        System.out.println("最小值：Character.MIN_VALUE="  
                + (int) Character.MIN_VALUE);  
        // 以数值形式而不是字符形式将Character.MAX_VALUE输出到控制台  
        System.out.println("最大值：Character.MAX_VALUE="  
                + (int) Character.MAX_VALUE);   
	}
	
	public void ThreadSynTest(){
 
        Drop drop = new Drop();  
        Thread t1 = new Thread(new Producer(drop)); 
		
		System.out.printf("Produce create, ThreadID:%d%n", t1.getId());
        Thread t2 = new Thread(new Consumer(drop));
		System.out.printf("Consumer create, ThreadID:%d%n", t2.getId());
		Thread t3 = new Thread(new Consumer(drop));
		System.out.printf("Consumer create, ThreadID:%d%n", t3.getId());
		Thread t4 = new Thread(new Consumer(drop));
		System.out.printf("Consumer create, ThreadID:%d%n", t4.getId());
		t1.start();   
		t2.start();  
		t3.start(); 
		t4.start();
		try
		{
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			System.out.println("Thread run OVER. Consumer totale:"+drop.getConsumerTotal());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void PrintProperties()
	{
		Properties p = System.getProperties();
		p.list(System.out);
		System.out.println("\n\n----Memory Usage:");
		Runtime t = Runtime.getRuntime();
		System.out.printf("\tTotal Memory:%d\n\tFree  Memory:%d%n",t.totalMemory(),t.freeMemory());
	}
	
	public void dataTypeTest() {
		PrimitiveOverloading p = new PrimitiveOverloading();
		p.testConstVal();
		p.testChar();
		p.testByte();
		p.testShort();
		p.testInt();
		p.testLong();
		p.testFloat();
		p.testDouble();
		p.testDoubleConvert();
	}
}