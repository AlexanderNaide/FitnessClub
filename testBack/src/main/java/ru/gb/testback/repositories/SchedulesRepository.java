package ru.gb.testback.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.gb.testback.model.clubEvents.ClubEventResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SchedulesRepository {

    private Map<Long, ClubEventResponse> scheduleRepository;
    private Map<String, String> disciplineDescriptionRepository;

    @PostConstruct
    private void init() {
        List<ClubEventResponse> list = new ArrayList<>();
        list.add(new ClubEventResponse(0L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Понедельник", "09:00", "60 минут", 1));
        list.add(new ClubEventResponse(1L, "ЙОГА_ЛАТЕС", "", "Пономарева Вика", "Понедельник", "10:00", "60 минут", 1));
        list.add(new ClubEventResponse(2L, "BREAK_DANCE", "", "Ефимов Василий", "Понедельник", "16:00", "60 минут", 1));
        list.add(new ClubEventResponse(3L, "BREAK_DANCE", "", "Ефимов Василий", "Понедельник", "17:00", "60 минут", 1));
        list.add(new ClubEventResponse(4L, "ЗДОРОВАЯ СПИНА", "(по записи)", "Алексеева Катя", "Понедельник", "18:00", "60 минут", 3));
        list.add(new ClubEventResponse(5L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Понедельник", "19:00", "60 минут", 1));
        list.add(new ClubEventResponse(6L, "СТРЕТЧИНГ", "", "Иванова Анастасия", "Понедельник", "19:00", "60 минут", 2));
        list.add(new ClubEventResponse(7L, "ФУНКЦИОН. ПИЛАТЕС", "", "Белоусова Наталья", "Понедельник", "19:00", "60 минут", 3));
        list.add(new ClubEventResponse(8L, "ЛФК ФИТНЕСС", "(детский)", "Масликова Елена", "Понедельник", "19:00", "60 минут", 4));
        list.add(new ClubEventResponse(9L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Понедельник", "20:00", "60 минут", 1));
        list.add(new ClubEventResponse(10L, "СИЛОВАЯ СО ШТАНГОЙ", "", "Матушкина Мария", "Понедельник", "20:00", "60 минут", 2));
        list.add(new ClubEventResponse(11L, "БАЧАТА", "", "Пономарева Вика", "Понедельник", "20:00", "60 минут", 3));
        list.add(new ClubEventResponse(12L, "ТРАЙБЛ", "", "Марина Нечаева", "Понедельник", "21:00", "60 минут", 1));

        list.add(new ClubEventResponse(13L, "ПИЛАТЕС POLESTAR", "", "Белоусова Наталья", "Вторник", "10:00", "60 минут", 1));
        list.add(new ClubEventResponse(14L, "HIP - HOP", "(прод)", "Полетаев Павел", "Вторник", "18:00", "60 минут", 1));
        list.add(new ClubEventResponse(15L, "ЭКСПРЕСС-ТРЕНИНГ", "(30 мин)", "Васильева Кристина", "Вторник", "18:00", "30 минут", 3));
        list.add(new ClubEventResponse(16L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", "(детский)", "Ельчанин Юрий", "Вторник", "18:00", "60 минут", 4));
        list.add(new ClubEventResponse(17L, "КАЛЛАНЕТИКА", "", "Синаевская Галина", "Вторник", "19:00", "60 минут", 1));
        list.add(new ClubEventResponse(18L, "DANCE FITNESS", "(ЗУМБА)", "Васильева Кристина", "Вторник", "19:00", "60 минут", 2));
        list.add(new ClubEventResponse(19L, "ИНТЕРВАЛЬНЫЙ ТРЕНИНГ", "", "Корчуганова Соня", "Вторник", "19:00", "60 минут", 3));
        list.add(new ClubEventResponse(20L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Вторник", "20:00", "60 минут", 1));
        list.add(new ClubEventResponse(21L, "ЗДОРОВАЯ СПИНА", "(по записи)", "Корчуганова Соня", "Вторник", "20:00", "60 минут", 2));
        list.add(new ClubEventResponse(22L, "ЙОГА", "", "Ежикова Елена", "Вторник", "20:00", "60 минут", 3));

        list.add(new ClubEventResponse(23L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Среда", "09:00", "60 минут", 1));
        list.add(new ClubEventResponse(24L, "АКТИВ_БОДИ", "", "Пономарева Вика", "Среда", "10:00", "60 минут", 1));
        list.add(new ClubEventResponse(25L, "BREAK_DANCE", "", "Ефимов Василий", "Среда", "16:00", "60 минут", 1));
        list.add(new ClubEventResponse(26L, "BREAK_DANCE", "", "Ефимов Василий", "Среда", "17:00", "60 минут", 1));
        list.add(new ClubEventResponse(27L, "HIP - HOP", "(начинающие)", "Полетаев Павел", "Среда", "18:00", "60 минут", 3));
        list.add(new ClubEventResponse(28L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Среда", "19:00", "60 минут", 1));
        list.add(new ClubEventResponse(29L, "СИЛОВАЯ СО ШТАНГОЙ", "", "Матушкина Мария", "Среда", "19:00", "60 минут", 2));
        list.add(new ClubEventResponse(30L, "СТРЕТЧИНГ", "", "Иванова Анастасия", "Среда", "19:00", "60 минут", 3));
        list.add(new ClubEventResponse(31L, "ЛФК ФИТНЕСС", "(детский)", "Масликова Елена", "Среда", "19:00", "60 минут", 4));
        list.add(new ClubEventResponse(32L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Среда", "20:00", "60 минут", 1));
        list.add(new ClubEventResponse(33L, "СУПЕР ЯГОДИЦЫ", "", "Вяткина Мария", "Среда", "20:00", "60 минут", 2));
        list.add(new ClubEventResponse(34L, "ГАМАКИ", "(по записи)", "Иванова Настя", "Среда", "20:00", "60 минут", 3));
        list.add(new ClubEventResponse(35L, "ТРАЙБЛ", "", "Марина Нечаева", "Среда", "21:00", "60 минут", 1));

        list.add(new ClubEventResponse(36L, "ПИЛАТЕС POLESTAR", "", "Белоусова Наталья", "Четверг", "10:00", "60 минут", 1));
        list.add(new ClubEventResponse(37L, "HIP - HOP", "(прод)", "Полетаев Павел", "Четверг", "18:00", "60 минут", 1));
        list.add(new ClubEventResponse(38L, "ЭКСПРЕСС-ТРЕНИНГ", "(30 мин)", "Васильева Кристина", "Четверг", "18:00", "30 минут", 3));
        list.add(new ClubEventResponse(39L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", "(детский)", "Ельчанин Юрий", "Четверг", "18:00", "60 минут", 4));
        list.add(new ClubEventResponse(40L, "КАЛЛАНЕТИКА", "", "Синаевская Галина", "Четверг", "19:00", "60 минут", 1));
        list.add(new ClubEventResponse(41L, "DANCE FITNESS", "(ЗУМБА)", "Васильева Кристина", "Четверг", "19:00", "60 минут", 2));
        list.add(new ClubEventResponse(42L, "ИНТЕРВАЛЬНЫЙ ТРЕНИНГ", "", "Корчуганова Соня", "Четверг", "19:00", "60 минут", 3));
        list.add(new ClubEventResponse(43L, "СТЕП-АЭРОБИКА", "", "Корпачева Вероника", "Четверг", "19:00", "60 минут", 4));
        list.add(new ClubEventResponse(44L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Четверг", "20:00", "60 минут", 1));
        list.add(new ClubEventResponse(45L, "HOT POWER", "", "Корчуганова Соня", "Четверг", "20:00", "60 минут", 2));
        list.add(new ClubEventResponse(46L, "ЙОГА", "", "Ежикова Елена", "Четверг", "20:00", "60 минут", 3));
        list.add(new ClubEventResponse(47L, "СТЕП-АЭРОБИКА", "", "Карпачева Вероника", "Четверг", "20:00", "60 минут", 4));

        list.add(new ClubEventResponse(48L, "СИЛОВОЙ ТРЕНИНГ", "", "Соколова Алена", "Пятница", "09:00", "60 минут", 1));
        list.add(new ClubEventResponse(49L, "ЙОГА_ЛАТЕС", "", "Пономарева Вика", "Пятница", "10:00", "60 минут", 1));
        list.add(new ClubEventResponse(50L, "BREAK_DANCE", "", "Ефимов Василий", "Пятница", "16:00", "60 минут", 1));
        list.add(new ClubEventResponse(51L, "BREAK_DANCE", "", "Ефимов Василий", "Пятница", "17:00", "60 минут", 1));
        list.add(new ClubEventResponse(52L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Пятница", "18:00", "60 минут", 1));
        list.add(new ClubEventResponse(53L, "HIP - HOP", "(начинающие)", "Полетаев Павел", "Пятница", "18:00", "60 минут", 3));
        list.add(new ClubEventResponse(54L, "ЗДОРОВАЯ СПИНА", "(по записи)", "Корчуганова Соня", "Пятница", "18:00", "60 минут", 4));
        list.add(new ClubEventResponse(55L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Пятница", "19:00", "60 минут", 1));
        list.add(new ClubEventResponse(56L, "СИЛОВАЯ СО ШТАНГОЙ", "", "Матушкина Мария", "Пятница", "19:00", "60 минут", 2));
        list.add(new ClubEventResponse(57L, "СТРЕТЧИНГ", "", "Иванова Анастасия", "Пятница", "19:00", "60 минут", 3));
        list.add(new ClubEventResponse(58L, "СУПЕР ЯГОДИЦЫ", "", "Вяткина Мария", "Пятница", "20:00", "60 минут", 1));
        list.add(new ClubEventResponse(59L, "ГАМАКИ", "(по записи)", "Иванова Настя", "Пятница", "20:00", "60 минут", 2));

        list.add(new ClubEventResponse(60L, "ПИЛАТЕС POLESTAR", "", "Белоусова Наталья", "Суббота", "11:00", "60 минут", 1));
        list.add(new ClubEventResponse(61L, "АДАПТИВНАЯ ФИЗКУЛЬТУРА", "(детский)", "Ельчанин Юрий", "Суббота", "11:00", "60 минут", 4));
        list.add(new ClubEventResponse(62L, "ФИТНЕС ЙОГА", "(по записи)", "Пономарева Вика", "Суббота", "12:00", "60 минут", 1));

        list.add(new ClubEventResponse(65L, "ВОСТОЧНЫЕ ТАНЦЫ", "(взрослые)", "Синаевская Галя", "Воскресенье", "11:00", "60 минут", 1));
        list.add(new ClubEventResponse(66L, "КАЛЛАНЕТИКА", "", "Синаевская Галина", "Воскресенье", "12:00", "60 минут", 1));
        list.add(new ClubEventResponse(67L, "FT ПЕТЛИ TRX", "", "Соколов Михаил", "Воскресенье", "17:00", "60 минут", 1));
        list.add(new ClubEventResponse(68L, "СИЛОВОЙ тренинг + кардио", "", "Соколова Алена", "Воскресенье", "18:00", "60 минут", 1));
        list.add(new ClubEventResponse(69L, "ТРАЙБЛ", "", "Марина Нечаева", "Воскресенье", "19:00", "60 минут", 2));
        list.add(new ClubEventResponse(71L, "СТЕП-АЭРОБИКА", "", "Корпачева Вероника", "Воскресенье", "19:00", "60 минут", 3));

        scheduleRepository = new HashMap<>();
        list.forEach(e -> scheduleRepository.put(e.getId(), e));

        disciplineDescriptionRepository = new HashMap<>();
        disciplineDescriptionRepository.put("СИЛОВОЙ ТРЕНИНГ", "Силовая тренировка или тренировка сопротивления предполагает выполнение физических упражнений, направленных на повышение силы и выносливости. Это часто связано с поднятием тяжестей. Он также может включать в себя различные методы обучения, такие как гимнастика, изометрия и плиометрия.");
        disciplineDescriptionRepository.put("ЙОГА_ЛАТЕС", "Йогалатес — это направление фитнеса, совмещающее в себе две крупнейшие методики: Йога и система Пилатес. Благодаря «симбиозу» двух практик, за одну тренировку Вы обретаете равновесие, гармонию, умиротворение при помощи Йоги. А силу, подтянутость, тонус и заряд энергией — дают Вам упражнения по системе Пилатес.");
        disciplineDescriptionRepository.put("BREAK_DANCE", "Брейк-данс — это танец, уходящий своими истоками в уличную культуру хип-хопа. Зародился он в начале 70-х годов в Нью-Йорке. Сперва это были незамысловатые движения под «брейкс» — ломаную музыку диджеев тех лет. Поэтому его, собственно, и назвали «break» — ломать, ломаться. Изначально он назывался бибоинг — от слова b-boy (breakboy).\n" +
                "Сейчас брейк-данс принято называть брейкингом.");
        disciplineDescriptionRepository.put("ЗДОРОВАЯ СПИНА", "Здоровая спина (Fine Spine) – одна из самых мягких разновидностей фитнеса, направленных на проработку мышц, удерживающих позвоночник в правильном положении. Упражнения предназначены для безопасного растягивания мышц и связок: они улучшат и восстановят подвижность позвоночника, снимут излишнее напряжение и расслабят малоподвижные участки спины.");
        disciplineDescriptionRepository.put("СТРЕТЧИНГ", "Стретчинг – это комплекс физических упражнений, точнее поз, для растягивания отдельных частей тела, направленных на улучшение гибкости и развития подвижности в суставах, при котором чередуются напряжение и расслабление различных групп мышц. Определенным образом организуя мышечную деятельность, стретчинг повышает двигательную активность, улучшает подвижность суставов, быстро восстанавливает способность двигаться при травмах, заболеваниях.");
        disciplineDescriptionRepository.put("ФУНКЦИОН. ПИЛАТЕС", "Функциональный Пилатес — глубокий и объемный курс, направленный на заполнение пробелов в классическом курсе пилатеса: почти полное отсутствие вращений и скручивания позвоночника. Этот семинар предоставляет множество новых упражнений, основанных на методе Пилатес, но в более широкой форме.");
        disciplineDescriptionRepository.put("ЛФК ФИТНЕСС", "Лечебная гимнастика");
        disciplineDescriptionRepository.put("FT ПЕТЛИ TRX", "Петли TRX — это инновационный тренажер, который состоит из прочной ленты с двумя лямками, круглыми ручками для рук и петлями для ног. Данный тренажер компактен, что позволяет его использовать дома, в тренажерном зале и на уличной спортивной площадке. Его главная особенность — это работа с собственным весом, которая позволяет воздействовать практически на все мышцы тела за счет регулируемой нагрузки (длины лямок и угла их наклона).");
        disciplineDescriptionRepository.put("ТРАЙБЛ", "Трайбл — современный стиль танца, основанный на сочетании элементов фольклорных танцев Северной Африки, Ближнего Востока, Индии и фламенко.");
        disciplineDescriptionRepository.put("КАЛЛАНЕТИКА", "Калланетика — это комплекс гимнастических упражнений, разработанный американкой Кэллан Пинкни. Это система комплексных статических упражнений, направленных на сокращение и растяжение мышц.");
    }

    public Map<Long, ClubEventResponse> findAll() {
        return scheduleRepository;
    }

    public ClubEventResponse findById(Long id) {
        return scheduleRepository.get(id);
    }

    public String findDescriptionByTitle(String title) {
        return disciplineDescriptionRepository.get(title);
    }

    public ClubEventResponse findEventResponseByTitle (String title){
        return scheduleRepository.values().stream().filter(e -> e.getDiscipline().equals(title)).findFirst().orElse(null);
    }
}
