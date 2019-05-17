package auction;

public class MySinglenton {
private static MySinglenton mySinglenton=new MySinglenton();
private String information;

public static MySinglenton getMySinglenton() {
	return mySinglenton;
}

public String getInformation() {
	return information;
}

public void setInformation(String information) {
	this.information = information;
}


}
