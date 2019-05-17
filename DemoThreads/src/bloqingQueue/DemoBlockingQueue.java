package bloqingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DemoBlockingQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<String> queue=new ArrayBlockingQueue<String>(1);
		new Thread() {
			
			public void run() {
			for (int i=0;i<4;i++) {
				String string="first thread input "+i;
				try {
					
					queue.put(string);
					System.out.println(string);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		}.start();
		
		new Thread() {
			public void run() {
				for (int i=0;i<10;i++) {
					try {
						System.out.println("second "+queue.take());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
		
		
	}

}
