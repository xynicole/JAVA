package assignment09;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;

class NaiveQuickSortTest {
	Random rand = new Random();
	List<String> list;
	
	NaiveQuickSortTest () {
		String[] strs = new String[1000];
		for(int i = 0; i < strs.length; i++) {
			int randomLength = 10 + rand.nextInt(20);
			byte[] bytes = new byte[randomLength];
			rand.nextBytes(bytes);
			for(int j = 0; j < bytes.length; j++) {
				bytes[j] = (byte)('A'+((bytes[j]+128) % ('z'-'A'+1)));
			}
			strs[i] = new String(bytes);
			System.out.println(i + 1 + ": " + strs[i]); //jsut to see what is happening!
		}
		list = new ArrayList<>(Arrays.asList(strs));
	}
	
	
	@Test
	void testLess() {
		Collections.shuffle(list);
		String s1 = list.get(0);
		List<String> testResult = NaiveQuickSort.less(list);
		Collections.sort(testResult);
		Collections.sort(list);
		int position = list.indexOf(s1);
		List<String> copy = new ArrayList<>();
		for(int i = 0; i <position; i++) copy.add(list.get(i));
		assertEquals(copy, testResult);
	}

	@Test
	void testGteq() {
		Collections.shuffle(list);
		String s1 = list.get(0);
		List<String> testResult = NaiveQuickSort.gteq(list);
		Collections.sort(testResult);
		Collections.sort(list);
		int position = list.indexOf(s1);
		List<String> copy = new ArrayList<>();
		for(int i = position + 1; i < list.size(); i++) copy.add(list.get(i));
		assertEquals(copy, testResult);
	}

	@Test
	void testInOrder() {
		Collections.shuffle(list);
		boolean result = NaiveQuickSort.inOrder(list);
		assertFalse(result); // chance of being in order is one in millions
		Collections.sort(list);
		result = NaiveQuickSort.inOrder(list);
		assertTrue(result);
	}

	@Test
	void testSort() {
		Collections.shuffle(list);
		List<String> testResult = NaiveQuickSort.sort(list);
		Collections.sort(list);
		assertEquals(list, testResult);
	}

}
