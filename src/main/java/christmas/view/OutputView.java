package christmas.view;

public class OutputView {
    public void printEventMessage(){
        System.out.println("12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void printOrderMenu(){
        System.out.println("<주문 메뉴>");
    }

    public void printServiceMenu(){
        System.out.println("<증정 메뉴>");
    }

    public void printTotalPrice(){
        System.out.println("<할인 전 총주문 금액>");
    }

    public void printBenefit(){
        System.out.println("<혜택 내역>");
    }

    public void printTotalBenefit(){
        System.out.println("<총혜택 금액>");
    }

    public void printExpectPrice(){
        System.out.println("<할인 후 예상 금액>");
    }

    public void printEventBadge(){
        System.out.println("<12월 이벤트 배지>");
    }
}
