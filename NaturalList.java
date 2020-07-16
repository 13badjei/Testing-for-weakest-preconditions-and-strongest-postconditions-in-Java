import java.util.ArrayList;
import java.util.Collections;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant("numbers != null")
public class NaturalList {
	private ArrayList<Natural> numbers;

	// No contracts required for the following methods.
	private boolean arraySortedOrNot() {
		for(int i = 0; i < numbers.size() - 1; i++) {
			if(numbers.get(i).compareTo(numbers.get(i + 1)) > 0) {
				return false;
			}
		}
		return true;
	}

	private boolean binarySearch(Natural n, int i) {
		if(i == 0) {
			if(numbers.get(i).compareTo(n) == 0) {
				return true;
			}
		} else {
			int position = -(i + 1);
			if(i == -1 && numbers.get(position).compareTo(n)> 0){
				return true;
			} else if(numbers.get(position).compareTo(n) < 0 && numbers.get(position - 1).compareTo(n) > 0) {
				return true;
			}
		}
		return false;
	}

	public NaturalList(NaturalList o) { 
		numbers = new ArrayList<Natural>();
		for(Natural n : o.numbers) 
			numbers.add(new Natural(n));
	}

	public NaturalList() {
		numbers = new ArrayList<Natural>();
	}

	@Override
	public boolean equals(Object o) {
		if(!(o instanceof NaturalList)) return false;
		NaturalList other = (NaturalList) o;
		return numbers.equals(other.numbers);
	}

	@Override
	public String toString() {
		return numbers.toString(); 
	}

	// Add contracts to all following methods.
	@Requires("n != null")
	@Ensures("numbers.size() == numbers.size() + 1")
	public void push(Natural n) {
		numbers.add(n);
	}

	@Requires("i < numbers.size() && i >= 0")
	@Ensures("result == numbers.get(i)")
	public Natural get(int i) {
		return numbers.get(i);
	}

	@Requires("i < numbers.size() && i >= 0 && n!= null")
	@Ensures("numbers.get(i) == numbers.set(i, n)")
	public void set(int i, Natural n) {
		numbers.set(i, n);
	}
	
	@Requires("!(numbers.isEmpty())")
	@Ensures("arraySortedOrNot()")
	public void sort() {
		Collections.sort(numbers);
	}
	
	@Requires("!(numbers.isEmpty()) && arraySortedOrNot()")
	@Ensures("binarySearch(n, result)")
	public int search(Natural n) {
		return Collections.binarySearch(numbers, n);
	}
}