package waitAndNotify;

public class Runner {

	public static void main(String[] args) {
		SharedResource sr=new SharedResource();
		PlusThread plusT=new PlusThread(sr);
		MinusThread minusT=new MinusThread(sr);
		plusT.start();
		minusT.start();

	}

}
