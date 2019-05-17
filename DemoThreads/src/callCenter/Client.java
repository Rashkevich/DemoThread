package callCenter;

import java.util.concurrent.TimeUnit;

public class Client extends Thread{
private int clientId;
private CallCenter center;

public Client(int clientId, CallCenter center) {
	this.clientId = clientId;
	this.center = center;
}

@Override
public void run() {
	try {
		boolean flag=center.getSemaphore().tryAcquire(100, TimeUnit.MILLISECONDS);
			if(flag) {
				callOperation();
			} else {
				flag=center.getSemaphore().tryAcquire(100, TimeUnit.MILLISECONDS);
				if (flag) {
					callOperation();
				}
			}
			
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

private void callOperation() throws InterruptedException {
	Operator operator=center.getOperator();
	if(operator!=null) {
		System.out.println(operator.speak(clientId));
		sleep(1);
	}
	center.returnOperator(operator);
	
	center.getSemaphore().release();
}

}
