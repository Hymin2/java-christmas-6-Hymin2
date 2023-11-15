package christmas.repository;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.MenuType;
import christmas.domain.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest {
    private static OrderRepository orderRepository;

    @BeforeEach
    void setUp(){
        orderRepository = new OrderRepository();
        Menu menu1 = new Menu("메뉴1", MenuType.MAIN, 30000);
        Menu menu2 = new Menu("메뉴2", MenuType.DESSERT, 3000);
        Menu menu3 = new Menu("메뉴3", MenuType.MAIN, 20000);

        orderRepository.saveMenu(menu1, 2);
        orderRepository.saveMenu(menu2, 2);
        orderRepository.saveMenu(menu3, 2);
    }

    @AfterEach
    void clear(){
        orderRepository.clear();
    }

    @Test
    @DisplayName("중복 메뉴를 주문할 경우 예외 테스트")
    void orderDuplicationMenuTest(){
        Menu menu = new Menu("메뉴1", MenuType.MAIN, 30000);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.saveMenu(menu, 2);
            assertEquals(null, orderRepository.getOrder().getMenu());
        });
    }

    @Test
    @DisplayName("메뉴 개수가 20개 초과인 경우 예외 테스트")
    void orderMenuNumberBiggerThanMaxTest(){
        Menu menu = new Menu("메뉴메뉴", MenuType.MAIN, 30000);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.saveMenu(menu, 19);
            assertEquals(null, orderRepository.getOrder().getMenu());
        });
    }

    @Test
    @DisplayName("주문 메뉴가 모두 음료일 때 예외 테스트")
    void orderMenuIsOnlyDrinkTest(){
        orderRepository.clear();

        Menu menu1 = new Menu("메뉴1", MenuType.DRINK, 3000);
        Menu menu2 = new Menu("메뉴2", MenuType.DRINK, 3000);
        Menu menu3 = new Menu("메뉴3", MenuType.DRINK, 2000);

        orderRepository.saveMenu(menu1, 2);
        orderRepository.saveMenu(menu2, 2);
        orderRepository.saveMenu(menu3, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.getOrder().isAllDrink();
        });
    }
}