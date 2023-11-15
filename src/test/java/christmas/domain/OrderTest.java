package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.MenuType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderTest {
    private Order order;

    @BeforeEach
    void setUp(){
        order = new Order();

        order.saveMenu(new Menu("양송이수프", MenuType.APPETIZER, 6000), 2);
        order.saveMenu(new Menu("타파스", MenuType.APPETIZER, 5500), 1);
        order.saveMenu(new Menu("티본스테이크", MenuType.MAIN, 55000), 2);
        order.saveMenu(new Menu("해산물파스타", MenuType.MAIN, 35000), 3);
        order.saveMenu(new Menu("초코케이크", MenuType.DESSERT, 15000), 1);
        order.saveMenu(new Menu("샴페인", MenuType.DRINK, 25000), 1);
    }

    @Test
    @DisplayName("주문한 메뉴의 총 가격 테스트")
    void totalOrderAmountTest(){
        int totalOrderAmount = order.getAllAmount();

        assertEquals(272500, totalOrderAmount);
    }

    @Test
    @DisplayName("메인 메뉴의 총 개수 테스트")
    void mainMenuCountTest(){
        int mainMenuCount = order.getMainMenuCount();

        assertEquals(5, mainMenuCount);
    }

    @Test
    @DisplayName("디저트의 총 개수 테스트")
    void dessertCountTest(){
        int dessertCount = order.getDessertCount();

        assertEquals(1, dessertCount);
    }

    @Test
    @DisplayName("모두 음료가 아닐 때 모두 음료인지 확인하는 테스트")
    void isNotAllDrinkTest(){
        order.isAllDrink();
    }

    @Test
    @DisplayName("모두 음료일 때 예외 발생 테스트")
    void isAllDrinkTest(){
        order.clear();

        order.saveMenu(new Menu("샴페인", MenuType.DRINK, 25000), 1);
        order.saveMenu(new Menu("레드와인", MenuType.DRINK, 60000), 2);

        assertThrows(IllegalArgumentException.class, () -> {
            order.isAllDrink();
        });
    }
}