package threads;

public class SimpleThread extends Thread{
	private String nameOfThread;
	private FilePrnt fp;
	
	public SimpleThread(FilePrnt fp) {
		this.fp=fp;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			fp.getSem().acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SimpleThread:"+fp);
		for (int i=0;i<4;i++) {
			
			String string=""+getNameOfThread()+" tak"+i;
			fp.writeInFile(string+"\r\n");
			
		}
		
		fp.getSem().release();
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}

	public String getNameOfThread() {
		return nameOfThread;
	}

	public void setNameOfThread(String nameOfThread) {
		this.nameOfThread = nameOfThread;
	}
	
	

}
