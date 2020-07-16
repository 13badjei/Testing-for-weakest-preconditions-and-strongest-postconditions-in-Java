import org.junit.Test;
import com.google.java.contract.PreconditionError;
public class NaturalListTest {

	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfPush() {
		new Natural(null);
	}

	@Test
	public void testPushPostconditionSatisfaction() {
		new NaturalList().push(new Natural(1));
	}
	
	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfGet() {
		new NaturalList().get(-1);
	}

	@Test
	public void testGetPostconditionSatisfaction() {
		new NaturalList().push(new Natural(1));
		new NaturalList().get(1);
	}
	
	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfSet() {
		new NaturalList().set(-1, null);;
	}

	@Test
	public void testSetPostconditionSatisfaction() {
		new NaturalList().set(0, new Natural(1));
	}
	
	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfSort() {
		new NaturalList().sort();
	}

	@Test
	public void testSortPostconditionSatisfaction() {
		new NaturalList().sort();
	}
	
	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfSearch() {
		new NaturalList().search(new Natural(1));
	}

	@Test
	public void testSearchPostconditionSatisfaction() {
		new NaturalList().push(new Natural(1));
		new NaturalList().search(new Natural(1));
	}
}
