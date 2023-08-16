package ru.gb.testback.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.testback.model.subscriptions.SubscriptionResponse;
import ru.gb.testback.repositories.SubscriptionsRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SubscriptionsService {

    private final SubscriptionsRepository subscriptionRepository;
    private Map<Long, SubscriptionResponse> userSubscriptions;

    public boolean isSubscribe(String discipline){
        return userSubscriptions.containsValue(getSubscriptionByName(discipline));
    }

    public List<SubscriptionResponse> getAllSubscriptionList() {
        return subscriptionRepository.findAll().values().stream().toList();
    }

    public SubscriptionResponse getSubscription(Long id){
        return subscriptionRepository.findById(id);
    }

    public SubscriptionResponse getSubscriptionByName(String discipline){
        return subscriptionRepository.findByName(discipline);
    }

    public List<SubscriptionResponse> getUserSubscriptionList() {
        if (userSubscriptions == null || userSubscriptions.size() == 0){
            return new ArrayList<>();
        } else {
            return userSubscriptions.values().stream().toList();
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
