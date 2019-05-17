package auction;

import java.util.concurrent.Phaser;

public class Runner {

	public static void main(String[] args) {
		int countParticipants=4;
		Phaser phaser=new Phaser();
		Auction auction=new Auction(5, phaser);
		auction.start();
		for (int i=0;i<countParticipants;i++) {
			Participant participant=new Participant(i, auction, phaser);
			participant.start();
		}

	}

}
