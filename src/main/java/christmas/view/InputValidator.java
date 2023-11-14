package christmas.view;

import christmas.config.EventConfig;
import christmas.error.ErrorMessage;

public class InputValidator {
    private final String numberRegex = "^[0-9]*$";
    private final String menuOrderRegex = "^[ㄱ-ㅎ|가-힣]+-[0-9]{1,2}";

    public void validateNumber(String input){
        if(isNotNumber(input)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_DATE_TYPE_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateDate(int input){
        if(isNotDateRange(input)){
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_DATE_RANGE_ERROR_MESSAGE.getMessage());
        }
    }

    public void validateMenuOrder(String input){
        if(isNotCorrectMenuOrder(input)){
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_ORDER_TYPE_ERROR_MESSAGE.getMessage());
        }
    }

    private boolean isNotCorrectMenuOrder(String input){
        return !input.matches(menuOrderRegex);
    }

    private boolean isNotDateRange(int input){
        return input < EventConfig.DAY_RANGE_MIN_VALUE.ordinal() || input > EventConfig.DAY_RANGE_MAX_VALUE.getValue();
    }

    private boolean isNotNumber(String input){
        return !input.matches(numberRegex);
    }
}
