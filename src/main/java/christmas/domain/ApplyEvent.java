package christmas.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplyEvent {
    private final Map<String, Integer> discountBenefits = new HashMap<>();
    private final Map<String, Integer> giftBenefits = new HashMap<>();
    private final List<String> gifts = new ArrayList<>();

    public void saveDiscountBenefit(String eventName, int benefitAmount){
        discountBenefits.put(eventName, benefitAmount);
    }
    public void saveGiftBenefit(String eventName, int benefitAmount){
        giftBenefits.put(eventName, benefitAmount);
    }

    public void saveGift(String gift){
        gifts.add(gift);
    }

    public int getDiscountAmount(){
        return discountBenefits.values()
                .stream()
                .reduce(0, (benefit1, benefit2) -> benefit1 + benefit2)
                .intValue();
    }

    public int getTotalBenefitAmount(){
        return giftBenefits.values()
                .stream()
                .reduce(0, (benefit1, benefit2) -> benefit1 + benefit2)
                .intValue() + getDiscountAmount();
    }

    public List<String> getGift(){
        return Collections.unmodifiableList(gifts);
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
