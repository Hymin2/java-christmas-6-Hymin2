package christmas.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ApplyEvent {
    private final Map<String, Integer> discountBenefits = new HashMap<>();
    private final Map<String, Integer> giftBenefits = new HashMap<>();

    public void saveDiscountBenefit(String eventName, int benefitAmount){
        discountBenefits.put(eventName, benefitAmount);
    }
    public void saveGiftBenefit(String eventName, int benefitAmount){
        giftBenefits.put(eventName, benefitAmount);
    }

    public int getDiscountAmount(){
        return discountBenefits.values()
                .stream()
                .reduce(0, (benefit1, benefit2) -> benefit1 + benefit2)
                .intValue();
    }

    public int getAllBenefitAmount(){
        return discountBenefits.values()
                .stream()
                .reduce(0, (benefit1, benefit2) -> benefit1 + benefit2)
                .intValue() + getDiscountAmount();
    }

    public Map<String, Integer> getAllBenefits(){
        Map<String, Integer> allBenefits = new HashMap<>();

        allBenefits.putAll(discountBenefits);
        allBenefits.putAll(giftBenefits);

        return Collections.unmodifiableMap(allBenefits);
    }

    public void clear(){
        discountBenefits.clear();
        giftBenefits.clear();
    }
}
