package data;

import static constants.Constants.CREATE;

import java.util.Map;

public class EventData {
	
	//날짜 데이터
	private int visitDate=CREATE.reader().readDate();
	//주문 데이터
	private Map<String, Integer> orders=CREATE.reader().readOrder();
	
	private int totalCostOrigin;
	private boolean presentation;
	private int[] discountDetails;
	
	public int getVisitDate() {
		return visitDate;
	}
	public Map<String, Integer> getOrders() {
		return orders;
	}

	public int getTotalCostOrigin() {
		return totalCostOrigin;
	}
	public void setTotalCostOrigin(int totalCostOrigin) {
		this.totalCostOrigin = totalCostOrigin;
	}
	public boolean isPresentation() {
		return presentation;
	}
	public void setPresentation(boolean presentation) {
		this.presentation = presentation;
	}
	public int[] getDiscountDetails() {
		return discountDetails;
	}
	public void setDiscountDetails(int[] discountDetails) {
		this.discountDetails = discountDetails;
	}
}
