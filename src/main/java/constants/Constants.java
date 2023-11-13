package constants;

import creator.ObjectCreator;

public class Constants {

	//input 오류
	public final static String INVALID_DATE_OUTPUT=ErrorMessages.INVALID_DATE_OUTPUT.detected();
	public final static String INVALID_MENU_OUTPUT=ErrorMessages.INVALID_MENU_OUTPUT.detected();
	
	//할인가정보
	public final static int D_DAY_DISCOUNT_BASIC=-1000;
	public final static int D_DAY_DISCOUNT_PER_DAY=-100;
	public final static int WEEK_DISCOUNT=-2023;
	public final static int SPECIAL_DISCOUNT=-1000;
	public final static int DISCOUNT_TYPES_CNT=4;
	
	public final static int DAYS_OF_A_WEEK=7;
	public final static int SUNDAY_METER=3;
	public final static int SATURDAY_METER=2;
	public final static int FRIDAY_METER=1;
	public final static int DATE_OF_CHRISTMAS=25;

	public final static ObjectCreator CREATE=new ObjectCreator();
}
