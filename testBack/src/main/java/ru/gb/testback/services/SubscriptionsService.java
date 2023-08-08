package ru.gb.testback.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.testback.model.SubscriptionDto;
import ru.gb.testback.model.SubscriptionResponse;
import ru.gb.testback.repositories.SubscriptionsRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SubscriptionsService {

    private final SubscriptionsRepository subscriptionRepository;
    private Map<Long, SubscriptionResponse> userSubscriptions;

    public List<SubscriptionResponse> getAllSubscriptionList() {
        return subscriptionRepository.findAll().values().stream().toList();
    }

    public SubscriptionResponse getSubscription(Long id){
        return subscriptionRepository.findById(id);
    }

    public List<SubscriptionDto> getUserSubscriptionList() {
        if (userSubscriptions == null){
            return null;
        } else {
            return userSubscriptions.values().stream().map(e -> new SubscriptionDto(e.getId(), e.getWorkoutCount(), e.getDiscipline(), LocalDate.now().plusDays(e.getDaysToExpire()))).toList();
        }
    }

    public void addSubscriptionForUser(Long id){
        if (userSubscriptions == null){
            userSubscriptions = new HashMap<>();
        }
        userSubscriptions.put(id, subscriptionRepository.findById(id));
    }

    public void deleteSubscriptionForUser(Long id){
        userSubscriptions.remove(id);
    }


}
