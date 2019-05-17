package CycliBarrierDemo;


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Bid implements Runnable{
private String name;
private double bid;
private CyclicBarrier cb;



public Bid(String name) {
	
	this.name = name;
}


@Override
public void run() {
	// TODO Auto-generated method stub
	bid=10*Math.random();
	System.out.println(name+" - "+bid);
	try {
		cb.await();
	} catch (InterruptedException | BrokenBarrierException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public double getBid() {
	return bid;
}


public void setBid(double bid) {
	this.bid = bid;
}


public CyclicBarrier getCb() {
	return cb;
}


public void setCb(CyclicBarrier cb) {
	this.cb = cb;
}



}
