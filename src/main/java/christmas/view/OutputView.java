package christmas.view;

import christmas.config.EventConfig;
import christmas.domain.Menu;
import christmas.dto.OrderBenefitDto;
import christmas.dto.OrderMenuDto;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Set;

public class OutputView {
    public void printEventMessage(int date){
        System.out.println(String.format("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", EventConfig.EVENT_MONTH.getValue(), date));
    }

    public void printOrderMenu(OrderMenuDto orderMenuDto){
        System.out.println();
        System.out.println("<주문 메뉴>");

        Map<Menu, Integer> menu = orderMenuDto.menu();
        for(Menu m : menu.keySet()){
            System.out.println(String.format("%s %d개", m, menu.get(m)));
        }
    }

    public void printGiftMenu(Set<String> gifts){
        System.out.println();
        System.out.println("<증정 메뉴>");

        if(isNotExistGift(gifts)){
            System.out.println("없음");

            return;
        }

        for(String gift : gifts){
            System.out.println(gift);
        }
    }

    public void printTotalAmount(int totalAmount){
        System.out.println();
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(toWon(totalAmount));
    }

    public void printBenefit(OrderBenefitDto orderBenefitDto){
        System.out.println();
        System.out.println("<혜택 내역>");

        Map<String, Integer> benefits = orderBenefitDto.benefits();

        if(isNotExistBenefit(benefits)){
            System.out.println("없음");

            return;
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

    public void printExpectAmount(int expectAmount){
        System.out.println();
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(toWon(expectAmount));
    }

    public void printEventBadge(String badge){
        System.out.println();
        System.out.println(String.format("<%d월 이벤트 배지>", EventConfig.EVENT_MONTH.getValue()));
        System.out.println(badge);
    }

    private boolean isNotExistGift(Set<String> gifts){
        return gifts.isEmpty();
    }

    private boolean isNotExistBenefit(Map<String, Integer> benefits){
        return benefits.isEmpty();
    }

    private String toWon(int price){
        DecimalFormat decimalFormat = new DecimalFormat("###,###");

        return decimalFormat.format(price) + "원";
    }
}
