import org.junit.Test;
import com.google.java.contract.InvariantError;
import com.google.java.contract.PreconditionError;
public class NaturalTest {

	@Test(expected = InvariantError.class)
	public void testPreconditionFalsificationOfConstructor() {
		new Natural(-2);
	}

	@Test
	public void testConstructorPostconditionSatisfaction() {
		new Natural(1);
	}

	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfIncrement() {
		new Natural(255).increment();
	}

	@Test
	public void testIncrementPostconditionSatisfaction() {
		new Natural(1).increment();
	}

	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfDecrement() {
		new Natural(-1);
	}

	@Test
	public void testDecrementPostconditionSatisfaction() {
		new Natural(1).decrement();
	}

	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfAdd() {
		new Natural(255).add(new Natural(1));
	}

	@Test
	public void testAddPostconditionSatisfaction() {
		new Natural(1).add(new Natural(1));
	}
	
	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfSubtract() {
		new Natural(0).subtract(new Natural(1));
	}

	@Test
	public void testSubtractPostconditionSatisfaction() {
		new Natural(2).subtract(new Natural(1));
	}
	
	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfMultiply() {
		new Natural(255).multiply(new Natural(1));
	}

	@Test
	public void testMultiplyPostconditionSatisfaction() {
		new Natural(1).multiply(new Natural(1));
	}
	
	@Test(expected = PreconditionError.class)
	public void testPreconditionFalsificationOfDivide() {
		new Natural(0).divide(new Natural(0));
	}

	@Test
	public void testDividePostconditionSatisfaction() {
		new Natural(1).divide(new Natural(1));
	}
}
