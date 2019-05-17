package callCenter;

public class Operator {
private int id;
	public Operator(int i) {
		id=i;
	}
	public int getId() {
		return id;
	}
	
	public String speak(int clientId) {
		return "Client#"+clientId+" spoke operator#"+id;
	}

}
