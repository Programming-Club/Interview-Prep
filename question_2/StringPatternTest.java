package programming_club;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringPatternTest {

	@Test
	void test() {
		
		assertEquals(StringPattern.stringPattern("1232 ab+cd"), 44);
		assertEquals(StringPattern.stringPattern("1234 ab-cd"), -22);
		assertEquals(StringPattern.stringPattern("1203 ab+cd"), 15);
		assertEquals(StringPattern.stringPattern("34097 aa+bbcde"), 44130);
		assertEquals(StringPattern.stringPattern("6785493 abc-ade"), 24);
		
	}
}