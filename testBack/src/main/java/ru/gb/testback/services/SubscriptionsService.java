package ru.gb.testback.services;

import org.springframework.stereotype.Service;
import ru.gb.testback.model.SubscriptionDto;
import ru.gb.testback.model.SubscriptionResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscriptionsService {

    private Map<Long, SubscriptionResponse> subscriptionRepository;
    private Map<Long, SubscriptionResponse> userSubscriptions;

    public void init(){

        List<SubscriptionResponse> list = new ArrayList<>();

        // Функциональные
        list.add(new SubscriptionResponse(0L, "СИЛОВОЙ ТРЕНИНГ", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(1L, "СИЛОВОЙ тренинг + кардио", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(2L, "СИЛОВАЯ СО ШТАНГОЙ", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(3L, "ЭКСПРЕСС-ТРЕНИНГ", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(4L, "ИНТЕРВАЛЬНЫЙ ТРЕНИНГ", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(5L, "АКТИВ_БОДИ", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(6L, "СУПЕР ЯГОДИЦЫ", 10, 90, BigDecimal.valueOf(800.0)));

        // Гимнастические
        list.add(new SubscriptionResponse(7L, "ЙОГА", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(8L, "ЙОГА_ЛАТЕС", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(9L, "СТРЕТЧИНГ", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(10L, "ПИЛАТЕС POLESTAR", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(11L, "FT ПЕТЛИ TRX", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(12L, "КАЛЛАНЕТИКА", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(13L, "ГАМАКИ", 10, 90, BigDecimal.valueOf(600.0)));

        // Аэробные
        list.add(new SubscriptionResponse(14L, "BREAK_DANCE", 10, 90, BigDecimal.valueOf(800.0)));
        list.add(new SubscriptionResponse(15L, "БАЧАТА", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(16L, "ТРАЙБЛ", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(17L, "HIP - HOP", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(18L, "DANCE FITNESS", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(19L, "ТРАЙБЛ", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(20L, "СТЕП-АЭРОБИКА", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(21L, "ВОСТОЧНЫЕ ТАНЦЫ", 10, 90, BigDecimal.valueOf(600.0)));

        // Оздоровительные
        list.add(new SubscriptionResponse(22L, "ЛФК ФИТНЕСС", 10, 90, BigDecimal.valueOf(600.0)));
        list.add(new SubscriptionResponse(23L, "ЗДОРОВАЯ СПИНА", 5, 90, BigDecimal.valueOf(1200.0)));
        list.add(new SubscriptionResponse(24L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", 5, 90, BigDecimal.valueOf(1200.0)));

        subscriptionRepository = new HashMap<>();
        list.forEach(e -> subscriptionRepository.put(e.getId(), e));
    }

    public List<SubscriptionResponse> getAllSubscriptionList() {
        if (subscriptionRepository == null){
            init();
        }
        return subscriptionRepository.values().stream().toList();
    }

    public SubscriptionResponse getSubscription(Long id){
        return subscriptionRepository.get(id);
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
        System.out.println(id + " - " + userSubscriptions.size());
        userSubscriptions.put(id, subscriptionRepository.get(id));
    }


}
