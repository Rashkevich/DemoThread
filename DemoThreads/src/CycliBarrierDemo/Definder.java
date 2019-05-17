package CycliBarrierDemo;

import java.util.ArrayList;

public class Definder implements Runnable {
	private ArrayList<Bid> bids;
	private Bid winner;
	
	
	public Definder(ArrayList<Bid> bids) {
		super();
		this.bids = bids;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		if(bids.size()>0) {
			winner=bids.get(0);
			for (int i=1;i<bids.size();i++) {
				if(winner.getBid()<bids.get(i).getBid()) {
					winner=bids.get(i);
				}
			}
			System.out.println("winner "+winner.getName()+" price="+winner.getBid());
		}
		
	}


	public ArrayList<Bid> getBids() {
		return bids;
	}


	public void setBids(ArrayList<Bid> bids) {
		this.bids = bids;
	}
	
	

}
