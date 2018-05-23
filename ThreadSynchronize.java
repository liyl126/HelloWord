
import java.util.Random;
import java.util.HashMap;

class Drop {  
    // Message sent from producer  
    // to consumer.  
    private String message;  
    // True if consumer should wait  
    // for producer to send message,  
    // false if producer should wait for  
    // consumer to retrieve message.  
    private boolean empty = true; 
	private HashMap<String,Integer> ConsumerTotal;
	
	private void ConsumerTotalAdd(String thID){
		Integer intCt = ConsumerTotal.get(thID);
		if (null == intCt)
		{
			intCt = 0;
		}
		else
		{
			intCt++;
		}
		ConsumerTotal.put(thID,intCt);
	}
	
	public String getConsumerTotal(){
		return ConsumerTotal.toString();
	}

	public Drop(){
		ConsumerTotal = new HashMap<String,Integer>();
	}
	
	
  
    public synchronized String take() {  
        // Wait until message is  
        // available.  
		System.out.format("Thread ID[%s] [TAKE BEGIN] EMPTY=%s Enter .....\n", Thread.currentThread().getId(),empty);
        while (empty/* && !message.equals("DONE")*/) {  
            try {  
				if (message != null && message.equals("DONE")){
					break;
				}
				System.out.format("Thread ID[%s] [TAKE WAIT BEGIN]   ......\n", Thread.currentThread().getId());
                wait();  
				System.out.format("Thread ID[%s] [TAKE WAIT END] \n", Thread.currentThread().getId());
				
            } catch (InterruptedException e) {}  
        }  
		
		ConsumerTotalAdd(Long.toString(Thread.currentThread().getId()));
        // Toggle status.  
        empty = true;  
        // Notify producer that  
        // status has changed.  
		System.out.format("Thread ID[%s] [TAKE NOTIFYALL BEGIN] Enter ......\n", Thread.currentThread().getId());
        notifyAll();  
		System.out.format("Thread ID[%s] [TAKE NOTIFYALL END] Enter.\n", Thread.currentThread().getId());
		System.out.format("Thread ID[%s] [TAKE END] EMPTY=%s .\n", Thread.currentThread().getId(),empty);
        return message;  
    }  
  
    public synchronized void put(String message) {  
        // Wait until message has  
        // been retrieved.  
		System.out.format("Thread ID[%s] [PUT BEGIN] EMPTY=%s  .....\n", Thread.currentThread().getId(),empty);
        while (!empty) {  
            try {  
				System.out.format("Thread ID[%s] [PUT WAIT BEGIN]  .....\n", Thread.currentThread().getId());
                wait();  
				System.out.format("Thread ID[%s] [PUT WAIT END]   \n", Thread.currentThread().getId());
            } catch (InterruptedException e) {}  
        }  
        // Toggle status.  
        empty = false;  
        // Store message.  
        this.message = message;  
        // Notify consumer that status  
        // has changed.  
		System.out.format("Thread ID[%s] [PUT NOTIFYALL BEGIN]  ......\n", Thread.currentThread().getId());
        notifyAll();  
		System.out.format("Thread ID[%s] [PUT NOTIFYALL END] .\n", Thread.currentThread().getId());
		System.out.format("Thread ID[%s] [PUT END] EMPTY=%s .\n", Thread.currentThread().getId(),empty);
    }  
}  

class Producer implements Runnable {
    private Drop drop;

    public Producer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
			"Sencond Mares eat oats",
            "Sencond Does eat oats",
            "Sencond Little lambs eat ivy",
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i<importantInfo.length; i++) {
			System.out.format("Thread ID[%s] Producer put data[%d/%d] into Syncronized...... \n",Thread.currentThread().getId(), i+1,importantInfo.length);
            drop.put(importantInfo[i]);
			
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {}
        }
		System.out.format("Thread ID[%s] Producer put DONE\n", Thread.currentThread().getId());
        drop.put("DONE");
		System.out.format("Thread ID[%s] Producer OVER%n",Thread.currentThread().getId());
    }
}

class Consumer implements Runnable {
    private Drop drop;

    public Consumer(Drop drop) {
        this.drop = drop;
    }

    public void run() {
        Random random = new Random();
        for (String message = drop.take();
             ! message.equals("DONE");
             message = drop.take()) {
            System.out.format("Thread ID[%s] Consumer MESSAGE RECEIVED: %s%n",Thread.currentThread().getId(), message);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {}
        }
		System.out.format("Thread ID[%s] Consumer OVER%n",Thread.currentThread().getId());
    }
}