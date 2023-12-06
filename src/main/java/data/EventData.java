package data;

import java.util.Map;

public class EventData {

	private int visitDate;
	private Map<String, Integer> orders;
	
	public int getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(int visitDate) {
		this.visitDate = visitDate;
	}
	public Map<String, Integer> getOrders() {
		return orders;
	}
	public void setOrders(Map<String, Integer> orders) {
		this.orders = orders;
	}
}
