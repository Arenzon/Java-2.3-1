import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusMilesServiceTest {

    @Test
    void shouCalculateRegisteredAndUnderLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouCalculateRegisteredAndOverLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 1000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouCalculateNoRegisteredAndUnderLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouCalculateNoRegisteredAndOverLimit() {
        BonusMilesService service = new BonusMilesService();

        long amount = 100_000_500;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }

    @Test
    void shouCalculateIsNull() {
        BonusMilesService service = new BonusMilesService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);

    }
}