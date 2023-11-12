package christmas.view;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {
    private static InputValidator inputValidator;

    @BeforeAll
    static void setUp(){
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("날짜 입력이 숫자가 아닐 경우")
    void dateIsNotNumberTest(){
        String input = "a";

        assertThrows(IllegalArgumentException.class, () -> {
           inputValidator.validateNumber(input);
        });
    }

    @Test
    @DisplayName("날짜 입력이 숫자인 경우")
    void dateIsNumberTest(){
        String input = "13";

        inputValidator.validateNumber(input);
    }

    @Test
    @DisplayName("날짜 입력이 1 미만인 경우")
    void dateIsLowerThanCorrectRange(){
        int input = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateDate(input);
        });
    }

    @Test
    @DisplayName("날짜 입력이 31 초과인 경우")
    void dateIsBiggerThanCorrectRange(){
        int input = 32;

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateDate(input);
        });
    }

    @Test
    @DisplayName("메뉴 입력이 형식에 올바르지 않은 경우")
    void menuOrderIsNotCorrectType(){
        String input = "메뉴메뉴-";

        assertThrows(IllegalArgumentException.class, () -> {
            inputValidator.validateMenuOrder(input);
        });
    }

    @Test
    @DisplayName("메뉴 입력이 형식에 올바른 경우")
    void menuOrderIsCorrectType(){
        String input = "메뉴메뉴-12";

        inputValidator.validateMenuOrder(input);
    }
}