package christmas.controller;

import christmas.service.RestaurantEventService;
import christmas.view.InputView;
import christmas.view.OutputView;

public class RestaurantEventController {
    private final RestaurantEventService restaurantEventService;
    private final InputView inputView;
    private final OutputView outputView;

    public RestaurantEventController(RestaurantEventService restaurantEventService,
                                     InputView inputView,
                                     OutputView outputView){
        this.restaurantEventService = restaurantEventService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void saveVisitDay(){
        int date = inputView.readDate();
        restaurantEventService.saveVisitDay(date);
    }

    public void saveOrderMenu(){
        String orderMenu = inputView.readOrderMenu();
        restaurantEventService.saveOrderMenu(orderMenu);
    }

    public void printEventBenefits(){
        outputView.printOrderMenu();
        outputView.printTotalPrice();
        outputView.printServiceMenu();
        outputView.printBenefit();
        outputView.printTotalBenefit();
        outputView.printExpectPrice();
        outputView.printEventBadge();
    }
}
