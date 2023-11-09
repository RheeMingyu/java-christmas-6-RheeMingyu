package features;

import static constants.Constants.*;

import java.util.HashMap;
import java.util.Map;

public class Validator {
	
	private static Map<String, Integer> orders=new HashMap<>();

	public int dateValidator(String input) {
		return validDayOfDecember(isNumber(input));
	}
	
	private int isNumber(String input) {
		try {
			return Integer.parseInt(input);
		} catch(NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_DATE_INPUT);
		}
	}
	
	private int validDayOfDecember(int input) {
		if(input<1||input>31) {
			throw new IllegalArgumentException(INVALID_DATE_INPUT);
		}
		return input;
	}
	
	public Map<String, Integer> orderValidator(String input){
		for(String individual:splitOrders(input)) {
			finalOrderDetails(dishAndServings(individual));
		}
		//중복메뉴 검사 메서드
		//총 메뉴수 20개 이상 검사 메서드
		//존재하는 메뉴인지 검사하는 메서드
		//기타등등 아직 미완의 메서드임
		return orders;
	}
	
	private void noDuplicates(String[] wholeOrders) {
		if(wholeOrders.length!=orders.size()) {
			throw new IllegalArgumentException(INVALID_MENU_INPUT);
		}
	}
	
	private void lessThanTwenty() {
		if(orders.size()>20) {
			throw new IllegalArgumentException(INVALID_MENU_INPUT);
		}
	}
	
	private String[] splitOrders(String wholeOrder) {
		String [] ordersSplitted=wholeOrder.split(",");
		
		for(String individual:ordersSplitted) {
			checkEmpty(individual);
		}
		return ordersSplitted;
	}
	
	private void checkEmpty(String input) {
		if(input==null||input.equals("")) {
			throw new IllegalArgumentException(INVALID_MENU_INPUT);
		}
	}
	
	private String[] dishAndServings(String individual) {
		String [] dish_servings=individual.split("-");
		
		if(dish_servings.length!=2) {
			throw new IllegalArgumentException(INVALID_MENU_INPUT);
		}
		return dish_servings;
	}
	
	private void finalOrderDetails(String[] dish_servings){
		orders.put(dish_servings[0], moreThanOne(isNumber(dish_servings[1])));	
	}
	
	private int moreThanOne(int servings) {
		if(servings<1) {
			throw new IllegalArgumentException(INVALID_MENU_INPUT);
		}
		return servings;
	}
	
	private void existentDish(String dish) {
		//enum을 비교해 입력한 메뉴명이 존재하는 메뉴명인지 확인하는 메서드
		//enum도 for each문 사용가능
		//enum(e1,e2)는 enum.(e1에 부여한 변수명(final어쩌구)) => enum.e1.equals(문자열)로 비교
		//여기서 각 메뉴별 가격도 추출하여 이용
		//enum.dish,enum.price
		
	}
}
