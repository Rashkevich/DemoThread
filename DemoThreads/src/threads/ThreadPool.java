package threads;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
private List<SimpleThread> pool;
private FilePrnt fp;

public List<SimpleThread> getPool() {
	return pool;
}

public ThreadPool(FilePrnt fp) {
	
	pool=new ArrayList<SimpleThread>();
	for (int i=0;i<5;i++) {
		SimpleThread st=new SimpleThread(fp);
		String s=""+i;
		st.setNameOfThread("Thread#"+s);
		pool.add(st);
	}
}

public void startPool() {
	for (SimpleThread thread : pool) {
		
		thread.start();
	}
	
	
}
}
