package christmas.dto;

import christmas.domain.Menu;
import java.util.Map;

public record OrderMenuDto(Map<Menu, Integer> menu) {

}
