package waitAndNotify;

public class MinusThread extends Thread{
private String nameT;
private SharedResource sr;

public MinusThread(SharedResource sr) {
	this.sr=sr;
	nameT="Minus";
}

@Override
public void run() {
	for (int i=0;i<5;i++) {
	sr.minus();
	}

}



public SharedResource getSr() {
	return sr;
}

public void setSr(SharedResource sr) {
	this.sr = sr;
}

public String getNameT() {
	return nameT;
}

public void setNameT(String nameT) {
	this.nameT = nameT;
}



}
