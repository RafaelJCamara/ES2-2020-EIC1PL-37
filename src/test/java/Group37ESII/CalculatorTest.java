package Group37ESII;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class CalculatorTest {

	Calculator c1;
	
	@BeforeEach
	void init() {
		c1=new Calculator();
	}

	
	@Test
	void test() {
		assertEquals(2,c1.add(1, 1));
		assertNotEquals(3, c1.add(3, 5));
		assertEquals(2,c1.subtract(3, 1));
		assertNotEquals(3, c1.subtract(3, 5));
		assertEquals(1,c1.multiplication(1, 1));
		assertNotEquals(3, c1.multiplication(3, 5));
		assertEquals(1.5,c1.division(3, 2));
		assertNotEquals(3, c1.multiplication(3, 5));
	}

}

