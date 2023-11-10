package constants;

public enum ErrorMessages {
	
	//private final static String INVALID_DATE_PROVIDED=;
	//private final static String INVALID_MENU_PROVIDED=;

	INVALID_DATE_OUTPUT("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
	INVALID_MENU_OUTPUT("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
	
	private final String msg;
	
	ErrorMessages(String msg) {
		this.msg=msg;
	}
	
	public String detected() {
		return msg;
	}
}
