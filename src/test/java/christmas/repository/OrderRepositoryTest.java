package christmas.repository;

import static org.junit.jupiter.api.Assertions.*;

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
        Menu menu1 = new Menu("메뉴1", "메인", 30000);
        Menu menu2 = new Menu("메뉴2", "디저트", 3000);
        Menu menu3 = new Menu("메뉴3", "메인", 20000);

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
        Menu menu = new Menu("메뉴1", "메인", 30000);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.saveMenu(menu, 2);
        });
    }

    @Test
    @DisplayName("메뉴 개수가 20개 초과인 경우 예외 테스트")
    void orderMenuNumberBiggerThanMaxTest(){
        Menu menu = new Menu("메뉴메뉴", "메인", 30000);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.saveMenu(menu, 19);
        });
    }

    @Test
    @DisplayName("주문 메뉴가 모두 음료일 때 예외 테스트")
    void orderMenuIsOnlyDrinkTest(){
        orderRepository.clear();

        Menu menu1 = new Menu("메뉴1", "음료", 3000);
        Menu menu2 = new Menu("메뉴2", "음료", 3000);
        Menu menu3 = new Menu("메뉴3", "음료", 2000);

        orderRepository.saveMenu(menu1, 2);
        orderRepository.saveMenu(menu2, 2);
        orderRepository.saveMenu(menu3, 2);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.getOrder().isAllDrink();
        });
    }
}