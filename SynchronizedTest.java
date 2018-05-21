//package  com.mytest;
public class SynchronizedTest {
    public synchronized static void test1(){
		System.out.println("synchronized void test1");
    }

    public void test2(){
        synchronized (this){
			System.out.println("void test2 synchronized");
        }
    }
	
	public static void main(String[] args){
			test1();
			//test2();
	}
}