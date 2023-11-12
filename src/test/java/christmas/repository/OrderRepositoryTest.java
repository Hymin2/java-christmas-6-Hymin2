package christmas.repository;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderRepositoryTest {
    private static OrderRepository orderRepository;

    @BeforeAll
    static void setUp(){
        orderRepository = new OrderRepository();
        Menu menu = new Menu("메뉴", "메인 메뉴", 30000);
        orderRepository.save(menu, 2);
    }

    @Test
    @DisplayName("중복 메뉴를 주문할 경우 예외 테스트")
    void orderDuplicationMenuTest(){
        Menu menu = new Menu("메뉴", "메인 메뉴", 30000);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.save(menu, 2);
        });
    }

    @Test
    @DisplayName("메뉴 개수가 20개 초과인 경우 예외 테스트")
    void orderMenuNumberBiggerThanMax(){
        Menu menu = new Menu("메뉴메뉴", "메인 메뉴", 30000);

        assertThrows(IllegalArgumentException.class, () -> {
            orderRepository.save(menu, 19);
        });
    }
}