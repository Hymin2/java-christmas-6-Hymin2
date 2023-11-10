package christmas.repository;

import christmas.domain.Menu;
import java.util.ArrayList;

public class MenuRepository {
    private static ArrayList<Menu> menu;

    public MenuRepository(){
        this.save(new Menu("양송이수프", "에피타이저", 6000));
        this.save(new Menu("타파스", "에피타이저", 5500));
        this.save(new Menu("시저샐러드", "에피타이저", 8000));

        this.save(new Menu("티본스테이크", "메인", 55000));
        this.save(new Menu("바비큐립", "메인", 54000));
        this.save(new Menu("해산물파스타", "메인", 35000));
        this.save(new Menu("크리스마스파스타", "메인", 25000));

        this.save(new Menu("초코케이크", "디저트", 15000));
        this.save(new Menu("아이스크림", "디저트", 5000));

        this.save(new Menu("제로콜라", "음료", 3000));
        this.save(new Menu("레드와인", "음료", 60000));
        this.save(new Menu("샴페인", "음료", 25000));
    }

    public void save(Menu menu){
        menu().add(menu);
    }

    public boolean existMenuByName(String name){
        return menu().contains(name);
    }

    private ArrayList<Menu> menu(){
        return MenuRepository.menu;
    }
}
