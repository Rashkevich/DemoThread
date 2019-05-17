package callCenter;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class CallCenter {
private LinkedList<Operator> operators;
private Semaphore semaphore;

public CallCenter(int countOperators) {
	semaphore=new Semaphore(countOperators);
	operators=new LinkedList<Operator>();
	for (int i=0;i<countOperators;i++) {
		Operator operator=new Operator(i);
		operators.add(operator);
	}
}

public Operator getOperator() {
	Operator operator=operators.pollFirst();
	return operator;
}

public void returnOperator(Operator operator) {
	operators.add(operator);
}

public Semaphore getSemaphore() {
	return semaphore;
}



}
