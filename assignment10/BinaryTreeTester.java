package assignment10;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Comparator;

public class BinaryTreeTester {
    private final List<String> data = new ArrayList<>(Arrays.asList("a", "ab", "d", "cdef", "abscde", "we", "x")); 
    private final Comparator<String> strComp = Comparator.comparingInt(String::length);
    private BSTwithListData<String> strs;

    @BeforeEach
    public void setup() {
        strs = new BSTwithListData<>(strComp);
        for (String i : data) {
            strs.insert(i);
        }
    }

    @Test
    @DisplayName("testing find method")
    public void testingFind() {
        for (String i : data) {
            assertNotNull(strs.find(i));
        }
        assertNull(strs.find("b"));
        assertNull(strs.find("c"));
        assertNull(strs.find("e"));
    }

    @Test
    @DisplayName("testing getElements")
    public void testingGetElements() {
        List<String> elems = strs.getElements();
        List<String> gotten = new ArrayList<>();
        for (String i : elems) {
            assertNotNull(strs.find(i));
            assertFalse(gotten.contains(i));
            gotten.add(i);
        }
        for (String i : data) {
            assertTrue(elems.contains(i));
        }
        assertEquals(7, elems.size());
        
        for (int i = 1; i < elems.size(); i++) {
        	assertTrue(strComp.compare(elems.get(i-1),elems.get(i)) <= 0);
        }
    }
}
