package auction;

public class RunSinglenton {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singlenton si=Singlenton.getInstance();
		Singlenton sii=Singlenton.getInstance();
		si.setInformation("some Information");
		System.out.println(si.getInformation());
		System.out.println(sii.getInformation());
		
		MySinglenton mySi=MySinglenton.getMySinglenton();
		MySinglenton mySii=MySinglenton.getMySinglenton();
		mySi.setInformation("new Information");
		System.out.println(mySi.getInformation());
		System.out.println(mySii.getInformation());
	}

}
