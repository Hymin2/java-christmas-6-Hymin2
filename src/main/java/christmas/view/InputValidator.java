package christmas.view;

public class InputValidator {
    private final String numberRegex = "^[0-9]*$";
    private final String menuOrderRegex = "^[ㄱ-ㅎ|가-힣]+-[0-9]{1,2}";
    public void validateNumber(String input){
        if(!input.matches(numberRegex)) {
            throw new IllegalArgumentException();
        }
    }

    public void validateDate(int input){
        if(input < 1 || input > 31){
            throw new IllegalArgumentException();
        }
    }

    public void validateMenuOrder(String input){
        if(!input.matches(menuOrderRegex)){
            throw new IllegalArgumentException();
        }
    }
}
