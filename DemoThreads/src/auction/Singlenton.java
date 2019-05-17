package auction;

public class Singlenton {
private static Singlenton instance;
private String information;

static {
	instance=new Singlenton();
}
public static Singlenton getInstance() {
	return instance;
}
public String getInformation() {
	return information;
}
public void setInformation(String information) {
	this.information = information;
}


}
