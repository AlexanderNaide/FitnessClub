package ru.gb.testback.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.testback.model.SubscriptionResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SubscriptionsRepository {

    private Map<Long, SubscriptionResponse> subscriptionRepository;

    @PostConstruct
    private void init(){
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

    public Map<Long, SubscriptionResponse> findAll(){
        return subscriptionRepository;
    }

    public SubscriptionResponse findById(Long id){
        return subscriptionRepository.get(id);
    }

    public SubscriptionResponse findByName(String discipline) {
        return subscriptionRepository.values().stream().filter(e -> e.getDiscipline().equals(discipline)).findFirst().orElse(null);
    }
}
