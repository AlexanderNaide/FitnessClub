package ru.gb.testback.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.testback.model.subscriptions.SubscriptionResponse;

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
        list.add(new SubscriptionResponse(0L, "СИЛОВОЙ ТРЕНИНГ", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Соколова Алена", "../images/class/tr1.jpg"));
        list.add(new SubscriptionResponse(1L, "СИЛОВОЙ тренинг + кардио", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Соколова Алена", "../images/class/tr2.jpg"));
        list.add(new SubscriptionResponse(2L, "СИЛОВАЯ СО ШТАНГОЙ", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Матушкина Мария", "../images/class/tr3.jpg"));
        list.add(new SubscriptionResponse(3L, "ЭКСПРЕСС-ТРЕНИНГ", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Васильева Кристина", "../images/class/tr4.jpg"));
        list.add(new SubscriptionResponse(4L, "ИНТЕРВАЛЬНЫЙ ТРЕНИНГ", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Корчуганова Соня", "../images/class/tr5.jpg"));
        list.add(new SubscriptionResponse(5L, "АКТИВ_БОДИ", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Пономарева Вика", "../images/class/tr6.jpg"));
        list.add(new SubscriptionResponse(6L, "СУПЕР ЯГОДИЦЫ", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Вяткина Мария", "../images/class/tr7.jpg"));

        // Гимнастические
        list.add(new SubscriptionResponse(7L, "ЙОГА", 10, 90, BigDecimal.valueOf(800.0), "Гимнастические", "Ежикова Елена", "../images/class/tr8.jpg"));
        list.add(new SubscriptionResponse(8L, "ЙОГА_ЛАТЕС", 10, 90, BigDecimal.valueOf(800.0), "Гимнастические", "Пономарева Вика", "../images/class/tr9.jpg"));
        list.add(new SubscriptionResponse(9L, "СТРЕТЧИНГ", 10, 90, BigDecimal.valueOf(600.0), "Гимнастические", "Иванова Анастасия", "../images/class/tr10.jpg"));
        list.add(new SubscriptionResponse(10L, "ПИЛАТЕС POLESTAR", 10, 90, BigDecimal.valueOf(600.0), "Гимнастические", "Белоусова Наталья", "../images/class/tr11.jpg"));
        list.add(new SubscriptionResponse(11L, "FT ПЕТЛИ TRX", 10, 90, BigDecimal.valueOf(600.0), "Гимнастические", "Соколов Михаил", "../images/class/tr12.jpg"));
        list.add(new SubscriptionResponse(12L, "КАЛЛАНЕТИКА", 10, 90, BigDecimal.valueOf(600.0), "Гимнастические", "Синаевская Галина", "../images/class/tr13.jpg"));
        list.add(new SubscriptionResponse(13L, "ГАМАКИ", 10, 90, BigDecimal.valueOf(600.0), "Гимнастические", "Иванова Настя", "../images/class/tr14.jpg"));

        // Аэробные
        list.add(new SubscriptionResponse(14L, "BREAK_DANCE", 10, 90, BigDecimal.valueOf(800.0), "Аэробные", "Ефимов Василий", "../images/class/tr15.jpg"));
        list.add(new SubscriptionResponse(15L, "БАЧАТА", 10, 90, BigDecimal.valueOf(600.0), "Аэробные", "Пономарева Вика", "../images/class/tr16.jpg"));
        list.add(new SubscriptionResponse(16L, "ТРАЙБЛ", 10, 90, BigDecimal.valueOf(600.0), "Аэробные", "Марина Нечаева", "../images/class/tr17.jpg"));
        list.add(new SubscriptionResponse(17L, "HIP - HOP", 10, 90, BigDecimal.valueOf(600.0), "Аэробные", "Полетаев Павел", "../images/class/tr18.jpg"));
        list.add(new SubscriptionResponse(18L, "DANCE FITNESS", 10, 90, BigDecimal.valueOf(600.0), "Аэробные", "Васильева Кристина", "../images/class/tr19.jpg"));
        list.add(new SubscriptionResponse(19L, "СТЕП-АЭРОБИКА", 10, 90, BigDecimal.valueOf(600.0), "Аэробные", "Корпачева Вероника", "../images/class/tr20.jpg"));
        list.add(new SubscriptionResponse(20L, "ВОСТОЧНЫЕ ТАНЦЫ", 10, 90, BigDecimal.valueOf(600.0), "Аэробные", "Синаевская Галя", "../images/class/tr21.jpg"));

        // Оздоровительные
        list.add(new SubscriptionResponse(21L, "ЛФК ФИТНЕСС", 10, 90, BigDecimal.valueOf(600.0), "Оздоровительные", "Масликова Елена", "../images/class/tr22.jpg"));
        list.add(new SubscriptionResponse(22L, "ЗДОРОВАЯ СПИНА", 5, 90, BigDecimal.valueOf(1200.0), "Оздоровительные", "Корчуганова Соня", "../images/class/tr23.jpg"));
        list.add(new SubscriptionResponse(23L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", 5, 90, BigDecimal.valueOf(1200.0), "Оздоровительные", "Ельчанин Юрий", "../images/class/tr24.jpg"));

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
