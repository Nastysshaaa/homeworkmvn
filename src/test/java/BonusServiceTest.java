import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.BonusService;
//import ru.netology.javaqa;

public class BonusServiceTest {

    @Test
    public void testRegisteredUnderLimit() {
        BonusService service = new BonusService();

        int expected = 150;
        int actual = (int) service.calculate(5_000, true);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testUnregisteredUnderLimit() {
        BonusService service = new BonusService();

        int expected = 50;
        int actual = (int) service.calculate(5_000, false);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        //Рассчитать для зарегистрированных и меньше лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        //Рассчитать для зарегистрированных и сверх лимита
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }
}

