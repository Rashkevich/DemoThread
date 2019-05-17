package threads;

import java.io.ObjectInputStream.GetField;
import java.util.concurrent.Semaphore;

public class PoolRunner {

	public static void main(String[] args) {
		Semaphore sem=new Semaphore(1);
		FilePrnt fp=new FilePrnt("C:\\Users\\rashkevich\\eclipse-workspace\\DemoThreads\\src\\threads\\1.txt", sem);
		ThreadPool pool=new ThreadPool(fp);
		pool.startPool();
		
		
		Thread t=Thread.currentThread();
		try {
			t.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("End of the main thread");
		fp.closeFilePrnt();
	}
}

