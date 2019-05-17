package waitAndNotify;

public class PlusThread extends Thread{
private String nameT;
private SharedResource sr;

public PlusThread(SharedResource sr) {
	this.sr=sr;
	nameT="Plus";
}

public String getNameT() {
	return nameT;
}

public void setNameT(String nameT) {
	this.nameT = nameT;
}

@Override
public void run() {
	for (int i=0;i<5;i++) {
	sr.plus();
	}
}


}
