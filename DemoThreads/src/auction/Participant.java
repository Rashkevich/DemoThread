package auction;

import java.util.concurrent.Phaser;

public class Participant extends Thread{
private int participantId;
private Lot currentLot;
private Auction auction;
private boolean stopFlag;
private int missLots;
private int lotCount;
private Phaser phaser;

public int getLotCount() {
	return lotCount;
}

public void setLotCount(int lotCount) {
	this.lotCount = lotCount;
}

public int getParticipantId() {
	return participantId;
}

public Participant(int id, Auction auction, Phaser phaser) {
	this.phaser=phaser;
	this.participantId=id;
	this.auction=auction;
	setStopFlag(false);
	setMissLots(0);
}

public void increaseState() {
	int riseTimes=1+(int)(Math.random()*10);
	for (int i=0;i<riseTimes;i++) {
		try {
			sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int price=currentLot.getCurrentPrice()+(int)(Math.random()*10);
		currentLot.setCurrentPrice(price);
		currentLot.setParticipant(this);
	}
}
	@Override
	public void run() {
	 phaser.register();
		lotCount=auction.getLotCount();
		
		
				for(int i=0;i<lotCount;i++) {
					if(missLots<1) {
						phaser.arriveAndAwaitAdvance(); //1
						getCurrentLot();
							increaseState();
							phaser.arriveAndAwaitAdvance();//2
								if(isWinner()) {
									payment();
								}
					} else {
						missLots=missLots-1;
					}
				}
			
			 
	 
	}	
	private void payment() {
		try {
			sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		currentLot.setPayed(true);
		
	}

	private boolean isWinner() {
		boolean flag=false;
		int id=currentLot.getParticipant().getParticipantId();
		if(id==participantId) {
			flag=true;
		}
		return flag;
	}
	
	

	private Lot getCurrentLot() {
		currentLot=auction.getCurrentLot();
		
		return currentLot;
	}

	public boolean isStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(boolean stopFlag) {
		this.stopFlag = stopFlag;
	}

	public int getMissLots() {
		return missLots;
	}

	public void setMissLots(int missLots) {
		this.missLots = missLots;
	}

}
