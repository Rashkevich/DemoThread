
package auction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

public class Auction extends Thread{
private List<Lot> lots;
private Lot currentLot;
private int lotCount;
private Phaser phaser;

public List<Lot> getLots() {
	return lots;
}

public void setLots(List<Lot> lots) {
	this.lots = lots;
}

public Lot getCurrentLot() {
	return currentLot;
}

public void setCurrentLot(Lot currentLot) {
	this.currentLot = currentLot;
}

public int getLotCount() {
	return lotCount;
}

public void setLotCount(int lotCount) {
	this.lotCount = lotCount;
}

public Auction(int count, Phaser phaser) {
	this.phaser=phaser;
	lotCount=count;
	lots=new ArrayList<Lot>();
	for (int i=0;i<count;i++) {
		Lot lot=new Lot(i);
		lots.add(lot);
	}
}

@Override
public void run() {
	phaser.register();
	for (int i=0;i<lotCount;i++) {
		currentLot=lots.get(i);
		phaser.arriveAndAwaitAdvance(); //1
		phaser.arriveAndAwaitAdvance(); //2
		defineWinner();
		definePayment();
	}
}

private void definePayment() {
	if(!currentLot.isPayed()) {
		Participant participant=currentLot.getParticipant();
		participant.setStopFlag(true);
		participant.setMissLots(2);
	};
	
}

private void defineWinner() {
	System.out.println("Winner:"+currentLot.getParticipant().getId()+" price:"+currentLot.getCurrentPrice());
}




}
