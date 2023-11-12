package christmas.view;

public class InputValidator {
    private final String numberRegex = "^[0-9]*$";
    private final String menuOrderRegex = "^[ㄱ-ㅎ|가-힣]+-[0-9]{1,2}";

    public void validateNumber(String input){
        if(isNotNumber(input)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDate(int input){
        if(isNotDateRange(input)){
            throw new IllegalArgumentException();
        }
    }

    public void validateMenuOrder(String input){
        if(isNotCorrectMenuOrder(input)){
            throw new IllegalArgumentException();
        }
    }

    private boolean isNotCorrectMenuOrder(String input){
        return !input.matches(menuOrderRegex);
    }

    private boolean isNotDateRange(int input){
        return input < 1 || input > 31;
    }

    private boolean isNotNumber(String input){
        return !input.matches(numberRegex);
    }
}
