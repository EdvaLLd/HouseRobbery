package se.edvard.houserobbery.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EntityTest {
    @Test
    void testPunch() {
        Burglar burglar = new Burglar();
        Resident resident = new Resident();
        resident.punch(burglar);
        Assertions.assertEquals(9, burglar.getHealth());
    }
    @Test
    void testTakeHit()
    {
        Burglar burglar = new Burglar();
        burglar.takeHit(5);
        Assertions.assertEquals(7, burglar.getHealth());
    }

    @Test
    void testIsConscious()
    {
        Burglar burglar = new Burglar();
        Resident resident = new Resident();
        resident.punch(burglar);
        Assertions.assertTrue(burglar.isConscious());
        for (int i = 0; i <3; i++) {
            resident.punch(burglar);
        }
        Assertions.assertFalse(burglar.isConscious());
    }
}
