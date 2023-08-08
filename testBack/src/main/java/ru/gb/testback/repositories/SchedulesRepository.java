package ru.gb.testback.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.testback.model.ClassDto;
import ru.gb.testback.model.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SchedulesRepository {

    private Map<Long, Event> scheduleRepository;

    @PostConstruct
    private void init(){
        List<ClassDto> list = new ArrayList<>();
        list.add(new ClassDto(0L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Понедельник", "09:00", 1));
        list.add(new ClassDto(1L, "ЙОГА_ЛАТЕС", "", "Пономарева Вика", "Понедельник", "10:00", 1));
        list.add(new ClassDto(2L, "BREAK_DANCE", "", "Ефимов Василий", "Понедельник", "16:00", 1));
        list.add(new ClassDto(3L, "BREAK_DANCE", "", "Ефимов Василий", "Понедельник", "17:00", 1));
        list.add(new ClassDto(4L, "ЗДОРОВАЯ СПИНА", "(по записи)", "Алексеева Катя", "Понедельник", "18:00", 3));
        list.add(new ClassDto(5L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Понедельник", "19:00", 1));
        list.add(new ClassDto(6L, "СТРЕТЧИНГ", "", "Иванова Анастасия", "Понедельник", "19:00", 2));
        list.add(new ClassDto(7L, "ФУНКЦИОН. ПИЛАТЕС", "", "Белоусова Наталья", "Понедельник", "19:00", 3));
        list.add(new ClassDto(8L, "ЛФК ФИТНЕСС", "(детский)", "Масликова Елена", "Понедельник", "19:00", 4));
        list.add(new ClassDto(9L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Понедельник", "20:00", 1));
        list.add(new ClassDto(10L, "СИЛОВАЯ СО ШТАНГОЙ", "", "Матушкина Мария", "Понедельник", "20:00", 2));
        list.add(new ClassDto(11L, "БАЧАТА", "", "Пономарева Вика", "Понедельник", "20:00", 3));
        list.add(new ClassDto(12L, "ТРАЙБЛ", "", "Марина Нечаева", "Понедельник", "21:00", 1));

        list.add(new ClassDto(13L, "ПИЛАТЕС POLESTAR", "", "Белоусова Наталья", "Вторник", "10:00", 1));
        list.add(new ClassDto(14L, "HIP - HOP", "(прод)", "Полетаев Павел", "Вторник", "18:00", 1));
        list.add(new ClassDto(15L, "ЭКСПРЕСС-ТРЕНИНГ", "(30 мин)", "Васильева Кристина", "Вторник", "18:00", 3));
        list.add(new ClassDto(16L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", "(детский)", "Ельчанин Юрий", "Вторник", "18:00", 4));
        list.add(new ClassDto(17L, "КАЛЛАНЕТИКА", "", "Синаевская Галина", "Вторник", "19:00", 1));
        list.add(new ClassDto(18L, "DANCE FITNESS", "(ЗУМБА)", "Васильева Кристина", "Вторник", "19:00", 2));
        list.add(new ClassDto(19L, "ИНТЕРВАЛЬНЫЙ ТРЕНИНГ", "", "Корчуганова Соня", "Вторник", "19:00", 3));
        list.add(new ClassDto(20L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Вторник", "20:00", 1));
        list.add(new ClassDto(21L, "ЗДОРОВАЯ СПИНА", "(по записи)", "Корчуганова Соня", "Вторник", "20:00", 2));
        list.add(new ClassDto(22L, "ЙОГА", "", "Ежикова Елена", "Вторник", "20:00", 3));

        list.add(new ClassDto(23L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Среда", "09:00", 1));
        list.add(new ClassDto(24L, "АКТИВ_БОДИ", "", "Пономарева Вика", "Среда", "10:00", 1));
        list.add(new ClassDto(25L, "BREAK_DANCE", "", "Ефимов Василий", "Среда", "16:00", 1));
        list.add(new ClassDto(26L, "BREAK_DANCE", "", "Ефимов Василий", "Среда", "17:00", 1));
        list.add(new ClassDto(27L, "HIP - HOP", "(начинающие)", "Полетаев Павел", "Среда", "18:00", 3));
        list.add(new ClassDto(28L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Среда", "19:00", 1));
        list.add(new ClassDto(29L, "СИЛОВАЯ СО ШТАНГОЙ", "", "Матушкина Мария", "Среда", "19:00", 2));
        list.add(new ClassDto(30L, "СТРЕТЧИНГ", "", "Иванова Анастасия", "Среда", "19:00", 3));
        list.add(new ClassDto(31L, "ЛФК ФИТНЕСС", "(детский)", "Масликова Елена", "Среда", "19:00", 4));
        list.add(new ClassDto(32L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Среда", "20:00", 1));
        list.add(new ClassDto(33L, "СУПЕР ЯГОДИЦЫ", "", "Вяткина Мария", "Среда", "20:00", 2));
        list.add(new ClassDto(34L, "ГАМАКИ", "(по записи)", "Иванова Настя", "Среда", "20:00", 3));
        list.add(new ClassDto(35L, "ТРАЙБЛ", "", "Марина Нечаева", "Среда", "21:00", 1));

        list.add(new ClassDto(36L, "ПИЛАТЕС POLESTAR", "", "Белоусова Наталья", "Четверг", "10:00", 1));
        list.add(new ClassDto(37L, "HIP - HOP", "(прод)", "Полетаев Павел", "Четверг", "18:00", 1));
        list.add(new ClassDto(38L, "ЭКСПРЕСС-ТРЕНИНГ", "(30 мин)", "Васильева Кристина", "Четверг", "18:00", 3));
        list.add(new ClassDto(39L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", "(детский)", "Ельчанин Юрий", "Четверг", "18:00", 4));
        list.add(new ClassDto(40L, "КАЛЛАНЕТИКА", "", "Синаевская Галина", "Четверг", "19:00", 1));
        list.add(new ClassDto(41L, "DANCE FITNESS", "(ЗУМБА)", "Васильева Кристина", "Четверг", "19:00", 2));
        list.add(new ClassDto(42L, "ИНТЕРВАЛЬНЫЙ ТРЕНИНГ", "", "Корчуганова Соня", "Четверг", "19:00", 3));
        list.add(new ClassDto(43L, "СТЕП-АЭРОБИКА", "", "Корпачева Вероника", "Четверг", "19:00", 4));
        list.add(new ClassDto(44L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Четверг", "20:00", 1));
        list.add(new ClassDto(45L, "HOT POWER", "", "Корчуганова Соня", "Четверг", "20:00", 2));
        list.add(new ClassDto(46L, "ЙОГА", "", "Ежикова Елена", "Четверг", "20:00", 3));
        list.add(new ClassDto(47L, "СТЕП-АЭРОБИКА", "", "Карпачева Вероника", "Четверг", "20:00", 4));

        list.add(new ClassDto(48L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Пятница", "09:00", 1));
        list.add(new ClassDto(49L, "ЙОГА_ЛАТЕС", "", "Пономарева Вика", "Пятница", "10:00", 1));
        list.add(new ClassDto(50L, "BREAK_DANCE", "", "Ефимов Василий", "Пятница", "16:00", 1));
        list.add(new ClassDto(51L, "BREAK_DANCE", "", "Ефимов Василий", "Пятница", "17:00", 1));
        list.add(new ClassDto(52L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Пятница", "18:00", 1));
        list.add(new ClassDto(53L, "HIP - HOP", "(начинающие)", "Полетаев Павел", "Пятница", "18:00", 3));
        list.add(new ClassDto(54L, "ЗДОРОВАЯ СПИНА", "(по записи)", "Корчуганова Соня", "Пятница", "18:00", 4));
        list.add(new ClassDto(55L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Пятница", "19:00", 1));
        list.add(new ClassDto(56L, "СИЛОВАЯ СО ШТАНГОЙ", "", "Матушкина Мария", "Пятница", "19:00", 2));
        list.add(new ClassDto(57L, "СТРЕТЧИНГ", "", "Иванова Анастасия", "Пятница", "19:00", 3));
        list.add(new ClassDto(58L, "СУПЕР ЯГОДИЦЫ", "", "Вяткина Мария", "Пятница", "20:00", 1));
        list.add(new ClassDto(59L, "ГАМАКИ", "(по записи)", "Иванова Настя", "Пятница", "20:00", 2));

        list.add(new ClassDto(60L, "ПИЛАТЕС POLESTAR", "", "Белоусова Наталья", "Суббота", "11:00", 1));
        list.add(new ClassDto(61L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", "(детский)", "Ельчанин Юрий", "Суббота", "11:00", 4));
        list.add(new ClassDto(62L, "ФИТНЕС ЙОГА", "(по записи)", "Пономарева Вика", "Суббота", "12:00", 1));
//        list.add(new ClassDto(63L, "ФИТНЕСС ЗАЛ", "", "", "Суббота", "20:00", 1));
//        list.add(new ClassDto(64L, "ЗЕЛЕНЫЙ ЗАЛ", "(2 этаж)", "", "Суббота", "20:00", 3));

        list.add(new ClassDto(65L, "ВОСТОЧНЫЕ ТАНЦЫ", "(взрослые)", "Синаевская Галя", "Воскресенье", "11:00", 1));
        list.add(new ClassDto(66L, "КАЛЛАНЕТИКА", "", "Синаевская Галина", "Воскресенье", "12:00", 1));
        list.add(new ClassDto(67L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Воскресенье", "17:00", 1));
        list.add(new ClassDto(68L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Воскресенье", "18:00", 1));
        list.add(new ClassDto(69L, "ТРАЙБЛ", "", "Марина Нечаева", "Воскресенье", "19:00", 2));
        list.add(new ClassDto(71L, "СТЕП-АЭРОБИКА", "", "Корпачева Вероника", "Воскресенье", "19:00", 3));
//        list.add(new ClassDto(72L, "ТАНЦЕВАЛЬНЫЙ ЗАЛ", "", "", "Воскресенье", "20:00", 2));
//        list.add(new ClassDto(73L, "МАЛЫЙ ЗАЛ", "(2 этаж)", "", "Воскресенье", "20:00", 4));

        scheduleRepository = new HashMap<>();
        list.forEach(e -> scheduleRepository.put(e.getId(), e));
    }

    public Map<Long, Event> findAll(){
        return scheduleRepository;
    }

    public Event findById(Long id){
        return scheduleRepository.get(id);
    }
}