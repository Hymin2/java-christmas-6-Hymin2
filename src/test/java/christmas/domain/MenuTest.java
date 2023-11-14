package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.MenuType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @Test
    @DisplayName("같은 메뉴일 때 equals 테스트")
    void sameMenuEqualsTest(){
        Menu menu1 = new Menu("메뉴", MenuType.MAIN, 20000);
        Menu menu2 = new Menu("메뉴", MenuType.MAIN, 20000);

        boolean b = menu1.equals(menu2);

        assertEquals(true, b);
    }

    @Test
    @DisplayName("다른 메뉴일 때 equals 테스트")
    void differentMenuEqualsTest(){
        Menu menu1 = new Menu("메뉴1", MenuType.MAIN, 20000);
        Menu menu2 = new Menu("메뉴2", MenuType.MAIN, 10000);

        boolean b = menu1.equals(menu2);

        assertEquals(false, b);
    }
}