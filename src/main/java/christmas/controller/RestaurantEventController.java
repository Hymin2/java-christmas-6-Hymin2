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

    public void run(){
        saveVisitDay();
        saveOrderMenu();
        printEventBenefits();
    }

    public void saveVisitDay(){
        while(true) {
            try {
                int date = inputView.readDate();
                restaurantEventService.saveVisitDay(date);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveOrderMenu(){
        while(true) {
            try {
                String orderMenu = inputView.readOrderMenu();
                restaurantEventService.saveOrderMenu(orderMenu);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void printEventBenefits(){
        outputView.printEventMessage(restaurantEventService.getDate());
        outputView.printOrderMenu(restaurantEventService.getMenu());
        outputView.printTotalPrice(restaurantEventService.getAllPrice());
        outputView.printServiceMenu(restaurantEventService.getGift());
        outputView.printBenefit(restaurantEventService.getBenefits());
        outputView.printTotalBenefit(restaurantEventService.getBenefitPrice());
        outputView.printExpectPrice(restaurantEventService.getExpectPrice());
        outputView.printEventBadge(restaurantEventService.getBadge());
    }
}
