package christmas.config;

public enum EventConfig {
    MENU_NUMBER_MIN_VALUE(1),
    MENU_NUMBER_MAX_VALUE(20),

    EVENT_MONTH(12),

    DAY_RANGE_MIN_VALUE(1),
    DAY_RANGE_MAX_VALUE(31);


    private int value;

    EventConfig(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
