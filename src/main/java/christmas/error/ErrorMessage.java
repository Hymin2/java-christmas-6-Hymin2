package christmas.error;

public enum ErrorMessage {
    INCORRECT_ORDER_TYPE_ERROR_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INCORRECT_DATE_TYPE_ERROR_MESSAGE ("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    INCORRECT_DATE_RANGE_ERROR_MESSAGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

    DUPLICATION_ORDER_ERROR_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),

    NOT_EXIST_MENU_ORDER_ERROR_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),

    ORDER_MENU_IS_ONLY_DRINK_ERROR_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),

    EXCEED_MAX_ORDER_NUMBER_ERROR_MESSAGE("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    LESS_MIN_ORDER_NUMBER_ERROR_MESSAGE  ("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");

    private String message;

    ErrorMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
