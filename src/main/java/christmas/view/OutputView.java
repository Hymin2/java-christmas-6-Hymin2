package christmas.view;

import christmas.domain.Menu;
import christmas.dto.OrderBenefitDto;
import christmas.dto.OrderMenuDto;
import java.text.DecimalFormat;
import java.util.Map;

public class OutputView {
    public void printEventMessage(int date){
        System.out.println(String.format("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", 12, date));
    }

    public void printOrderMenu(OrderMenuDto orderMenuDto){
        System.out.println();
        System.out.println("<주문 메뉴>");

        Map<Menu, Integer> menu = orderMenuDto.menu();
        for(Menu m : menu.keySet()){
            System.out.println(m + " " + menu.get(m) + "개");
        }
    }

    public void printServiceMenu(String gift){
        System.out.println();
        System.out.println("<증정 메뉴>");
        System.out.println(gift);
    }

    public void printTotalPrice(int allPrice){
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(toWon(allPrice));
    }

    public void printBenefit(OrderBenefitDto orderBenefitDto){
        System.out.println();
        System.out.println("<혜택 내역>");

        Map<String, Integer> benefits = orderBenefitDto.benefits();

        if(benefits.isEmpty()){
            System.out.println("없음");
        }

        for(String benefit : benefits.keySet()){
            System.out.println(benefit + ": " + toWon(benefits.get(benefit)));
        }
    }

    public void printTotalBenefit(int benefitPrice){
        System.out.println();
        System.out.println("<총혜택 금액>");
        System.out.println(toWon(benefitPrice));
    }

    public void printExpectPrice(int expectPrice){
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(toWon(expectPrice));
    }

    public void printEventBadge(String badge){
        System.out.println();
        System.out.println("<12월 이벤트 배지>");
        System.out.println(badge);
    }

    private String toWon(int price){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        return decimalFormat.format(price) + "원";
    }
}
