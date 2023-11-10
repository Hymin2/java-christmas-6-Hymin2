package christmas.controller;

public class RestaurantEventController {
    private final RestaurantEventService restaurantEventService;

    public RestaurantEventController(RestaurantEventService restaurantEventService){
        this.restaurantEventService = restaurantEventService;
    }

    public void saveVisitDay(){
        restaurantEventService.saveVisitDay();
    }

    public void saveOrderMenu(){
        restaurantEventService.saveOrderMenu();
    }

    public void printEventBenefits(){
        restaurantEventService.printEventBenefits();
    }
}
