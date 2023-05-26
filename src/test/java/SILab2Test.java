import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranch() {
        RuntimeException ex;
        ArrayList<User> nullUsers = new ArrayList<>();
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User(null, null, null), nullUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        User case2 = new User(null, "testhjkt&", "case2@gmail.com");
        List<User> listForCase2 = new ArrayList<>();
        listForCase2.add(new User(null, null, null));
        listForCase2.add(new User("case2@gmail.com", "testhjkt", "case2@gmail.com"));
        assertFalse(SILab2.function(case2, listForCase2));

        User case3 = new User("case3", "case3", "testtest");
        assertFalse(SILab2.function(case3, listForCase2));

        User case4 = new User("sadasd", "hhhhhhhhh ", "case4@gmail.com");
        assertFalse(SILab2.function(case4, listForCase2));
    }

    @Test
    void multipleCondition() {
        //CASE 1
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(null, null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //CASE 2
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("something", null, null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //CASE 3
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("something", "test", null), null));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //CASE 4
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(new User("something", "test", "testing@gmail.com"), null));
        assertFalse(ex.getMessage().contains("Mandatory information missing!"));
    }
}