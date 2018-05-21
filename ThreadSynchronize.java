
import java.util.Random;

class Drop {  
    // Message sent from producer  
    // to consumer.  
    private String message;  
    // True if consumer should wait  
    // for producer to send message,  
    // false if producer should wait for  
    // consumer to retrieve message.  
    private boolean empty = true;  
  
    public synchronized String take() {  
        // Wait until message is  
        // available.  
        while (empty) {  
            try {  
				System.out.format("Thread ID[%s] Enter take .....\n", Thread.currentThread().getId());
                wait();  
            } catch (InterruptedException e) {}  
        }  
        // Toggle status.  
        empty = true;  
        // Notify producer that  
        // status has changed.  
		System.out.format("Thread ID[%s] Enter take notifyAll.\n", Thread.currentThread().getId());
        notifyAll();  
		System.out.format("Thread ID[%s] Enter take end.\n", Thread.currentThread().getId());
        return message;  
    }  
  
    public synchronized void put(String message) {  
        // Wait until message has  
        // been retrieved.  
        while (!empty) {  
            try {  
				System.out.format("Thread ID[%s] Enter put .....\n", Thread.currentThread().getId());
                wait();  
            } catch (InterruptedException e) {}  
        }  
        // Toggle status.  
        empty = false;  
        // Store message.  
        this.message = message;  
        // Notify consumer that status  
        // has changed.  
		System.out.format("Thread ID[%s] Enter put notifyAll.\n", Thread.currentThread().getId());
        notifyAll();  
		System.out.format("Thread ID[%s] Enter put end.\n", Thread.currentThread().getId());
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
            "A kid will eat ivy too"
        };
        Random random = new Random();

        for (int i = 0; i<importantInfo.length; i++) {
			System.out.format("Thread ID[%s] put data\n", Thread.currentThread().getId());
            drop.put(importantInfo[i]);
			
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {}
        }
		System.out.format("Thread ID[%s] put DONE\n", Thread.currentThread().getId());
        drop.put("DONE");
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
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {}
        }
    }
}