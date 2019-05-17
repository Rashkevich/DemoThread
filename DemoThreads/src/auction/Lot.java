package auction;

public class Lot {
private int id;
private int currentPrice;
private boolean payed;
private Participant participant;



public Participant getParticipant() {
	return participant;
}


public void setParticipant(Participant participant) {
	this.participant = participant;
}


public Lot(int id) {
	this.id = id;
	payed=false;
	int startPrice=1+(int)(Math.random()*100);
	currentPrice=startPrice;
}


public int getCurrentPrice() {
	return currentPrice;
}

public void setCurrentPrice(int currentPrice) {
	this.currentPrice = currentPrice;
}

public boolean isPayed() {
	return payed;
}

public void setPayed(boolean payed) {
	this.payed = payed;
}

public int getId() {
	return id;
}


}
