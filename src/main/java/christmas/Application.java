package christmas;

import christmas.controller.RestaurantEventController;
import christmas.repository.ApplyEventRepository;
import christmas.repository.MenuRepository;
import christmas.repository.OrderRepository;
import christmas.service.RestaurantEventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RestaurantEventController restaurantEventController = new RestaurantEventController(
                new RestaurantEventService(new MenuRepository(), new OrderRepository(), new ApplyEventRepository()),
                new InputView(),
                new OutputView()
        );

        restaurantEventController.run();
    }
}
