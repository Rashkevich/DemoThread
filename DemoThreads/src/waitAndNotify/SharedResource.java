package waitAndNotify;

public class SharedResource {
private int i=0;
private boolean flag=false;

public synchronized void plus() {
while(i>=1) {
	try {
		wait();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	i=i+1;
	System.out.println(Thread.currentThread().getName()+" :"+i);
	notify();
	
}

public synchronized void minus() {
	while(i<1) {
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	i=i-1;
	System.out.println(Thread.currentThread().getName()+" :"+i);
	notify();
	
}

public int getI() {
	return i;
}

public boolean isFlag() {
	return flag;
}

public void setFlag(boolean flag) {
	this.flag = flag;
}



}
