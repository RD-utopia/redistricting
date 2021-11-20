package swdmt.redistricting;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
/**
 * Tests for Voter objects.
 *
 * @author  Dr. Jody Paul
 * @version 20211120
 */
public class VoterTest {
    /**
    * Voter's party affiliation should match Party. None when passed Party.None
    */
    @Test
    public void affiliationAttributeSpecifiedTest() {
        Voter voter1 = new Voter(Party.NONE, new Location(0, 0));
        assertThat(voter1.affiliation(), is(Party.NONE));
    }

    /**
    * Voter's party affiliation should be Party. None when passed null
    */
    @Test
    public void affiliationAttributeNullTest() {
        Voter voter2 = new Voter(null,
                                 new Location(Integer.MIN_VALUE,
                                              Integer.MAX_VALUE));
        assertThat(voter2.affiliation(), is(Party.NONE));
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
            () -> assertThat(voter1.location(), is(new Location(0, 0))),
            () -> assertThat(voter2.location().xCoordinate(), is(Integer.MIN_VALUE)),
            () -> assertThat(voter2.location().yCoordinate(), is(Integer.MAX_VALUE))
        );
    }
}
