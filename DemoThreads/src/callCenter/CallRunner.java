package callCenter;

public class CallRunner {

	public static void main(String[] args) {
	CallCenter center=new CallCenter(2);
	for (int i=0;i<20;i++) {
		Client client=new Client(i, center);
		client.start();
	}
	}

}
