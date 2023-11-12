package christmas.repository;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {
    private static MenuRepository menuRepository;

    @BeforeAll
    static void setUp(){
        menuRepository = new MenuRepository();

        menuRepository.save(new Menu("메뉴", "메인 메뉴", 40000));
    }

    @Test
    @DisplayName("저장한 메뉴가 있는지 테스트")
    void existSavedMenuTest(){
        String menuName = "메뉴";

        boolean b = menuRepository.existMenuByName(menuName);

        assertEquals(true, b);
    }

    @Test
    @DisplayName("저장한 메뉴가 있는지 테스트")
    void notExistNonSavedMenuTest(){
        String menuName = "메뉴메뉴";

        boolean b = menuRepository.existMenuByName(menuName);

        assertEquals(false, b);
    }

    @Test
    @DisplayName("저장한 메뉴를 불러오기 테스트")
    void findSavedMenuTest(){
        String menuName = "메뉴";

        Menu menu = menuRepository.findMenuByName(menuName);
        boolean b = menu.equals(menuName);

        assertEquals(true, b);
    }

    @Test
    @DisplayName("없는 메뉴를 불러올 때 예외 테스트")
    void findNonSavedMenuTest(){
        String menuName = "메뉴메뉴";

        assertThrows(IllegalArgumentException.class, () -> {
            Menu menu = menuRepository.findMenuByName(menuName);
        });
    }
}