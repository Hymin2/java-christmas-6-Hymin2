package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.config.EventConfig;
import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private final InputValidator inputValidator = new InputValidator();

    public int readDate(){
        System.out.println(String.format("안녕하세요! 우테코 식당 %d월 이벤트 플래너입니다.", EventConfig.EVENT_MONTH.getValue()));
        System.out.println(String.format("%d월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)", EventConfig.EVENT_MONTH.getValue()));
        String input = Console.readLine();

        inputValidator.validateNumber(input);
        inputValidator.validateDate(toInt(input));

        return toInt(input);
    }

    public String readOrderMenu(){
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        String input = Console.readLine();

        Arrays.stream(input.split(","))
                .forEach(inputValidator::validateMenuOrder);

        return input;
    }

    private int toInt(String input){
        return Integer.parseInt(input);
    }
}
