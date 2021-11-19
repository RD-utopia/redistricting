package swdmt.redistricting;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.Test;
/**
 * Tests for Voter objects.
 *
 * @author  Dr. Jody Paul
 * @version 20211119
 */
public class VoterTest {
    /**
    * Voter's party affiliation should match Party.None when passed Party.None
    */
    @Test
    public void affiliationAttributeSpecifiedTest() {
        Voter voter1 = new Voter(Party.NONE, new Location(0, 0));
        assertEquals(voter1.affiliation(), Party.NONE);
    }

    /**
    * Voter's party affiliation should be Party.None when passed null
    */
    @Test
    public void affiliationAttributeNullTest() {
        Voter voter2 = new Voter(null,
                                 new Location(Integer.MIN_VALUE,
                                              Integer.MAX_VALUE));
        assertEquals(voter2.affiliation(), Party.NONE);
    }

    /**
    * When passed a null location should throw an illegal argument exception
    */
    @Test
    public void invalidLocationTest() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> {
            Voter voter1 = new Voter(Party.NONE, null);
        });
    }

    /**
    * When passed various location attributes they match expected values
    */
    @Test
    public void locationAttributeTest() {
        Voter voter1 = new Voter(Party.NONE, new Location(0, 0));
        Voter voter2 = new Voter(null,
                                 new Location(Integer.MIN_VALUE,
                                              Integer.MAX_VALUE));
        assertAll("locations",
            () -> assertEquals(voter1.location(), new Location(0, 0)),
            () -> assertEquals(voter2.location().xCoordinate(), Integer.MIN_VALUE),
            () -> assertEquals(voter2.location().yCoordinate(), Integer.MAX_VALUE)
        );
    }
}
