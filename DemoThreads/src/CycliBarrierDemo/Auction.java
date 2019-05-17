package CycliBarrierDemo;

import java.util.ArrayList;
import java.util.concurrent.CyclicBarrier;

public class Auction {
private ArrayList<Bid> bids;
private CyclicBarrier cb;
private int countBids=3;

public Auction() {
	bids=new ArrayList<Bid>();
	Definder definder=new Definder(bids);
	cb=new CyclicBarrier(countBids, definder);
	
}

public void begin() {
	for (int i=0;i<countBids;i++) {
		String string="bid#"+i;
		Bid bid=new Bid(string);
		bid.setCb(cb);
		bids.add(bid);
		Thread bidThread=new Thread(bid, bid.getName());
		bidThread.start();
	//	System.out.println("!!!");
	}
}
	
}
