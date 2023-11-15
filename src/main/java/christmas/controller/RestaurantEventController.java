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
        saveVisitDate();
        saveOrderMenu();
        applyEvent();
        printOrderDetails();

        restaurantEventService.clearMenu();
        restaurantEventService.clearOrder();
        restaurantEventService.clearApplyEvent();
    }

    private void saveVisitDate(){
        while(true) {
            try {
                int date = inputView.readDate();
                restaurantEventService.saveVisitDate(date);

                break;
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void saveOrderMenu(){
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

    private void applyEvent(){
        restaurantEventService.applyDiscountEvent();
        restaurantEventService.applyGiftEvent();
    }

    private void printOrderDetails(){
        outputView.printEventMessage(restaurantEventService.getDate());

        outputView.printOrderMenu(restaurantEventService.getMenu());
        outputView.printTotalAmount(restaurantEventService.getAllAmount());

        outputView.printGiftMenu(restaurantEventService.getGift());
        outputView.printBenefit(restaurantEventService.getBenefits());
        outputView.printTotalBenefit(restaurantEventService.getAllBenefitAmount());

        outputView.printExpectAmount(restaurantEventService.getExpectAmount());

        outputView.printEventBadge(restaurantEventService.getBadge());
    }
}
