import org.junit.Test;

import static org.junit.Assert.*;

public class ArraysAndStringsTest {

    ArraysAndStrings arraysAndStrings = new ArraysAndStrings();

    @Test
    public void testUniqueCharacters() throws Exception {
        assertTrue(arraysAndStrings.uniqueCharacters("abcde"));
        assertFalse(arraysAndStrings.uniqueCharacters("aabcde"));
        assertFalse(arraysAndStrings.uniqueCharacters("abccde"));
        assertFalse(arraysAndStrings.uniqueCharacters("abcdee"));
    }

    @Test
    public void testUniqueCharactersWithoutExtraDataStructure() throws Exception {
        assertTrue(arraysAndStrings.uniqueCharactersWithoutExtraDataStructure("abcde"));
        assertFalse(arraysAndStrings.uniqueCharactersWithoutExtraDataStructure("aabcde"));
        assertFalse(arraysAndStrings.uniqueCharactersWithoutExtraDataStructure("abccde"));
        assertFalse(arraysAndStrings.uniqueCharactersWithoutExtraDataStructure("abcdee"));
    }

    @Test
    public void testReverseCStyleString() {
        assertEquals("abcd", String.valueOf(arraysAndStrings.reverseCStyleString("dcba".toCharArray())));
        assertEquals("abcde", String.valueOf(arraysAndStrings.reverseCStyleString("edcba".toCharArray())));
        assertEquals("", String.valueOf(arraysAndStrings.reverseCStyleString("".toCharArray())));
        assertEquals("a", String.valueOf(arraysAndStrings.reverseCStyleString("a".toCharArray())));
        assertEquals("ba", String.valueOf(arraysAndStrings.reverseCStyleString("ab".toCharArray())));
    }

    @Test
    public void testAnagrams() {
        assertTrue(arraysAndStrings.anagrams(new char[]{'a', 'b', 'c'}, new char[]{'b', 'c', 'a'}));
        assertFalse(arraysAndStrings.anagrams(new char[]{'a', 'b', 'b'}, new char[]{'b', 'c', 'a'}));
        assertFalse(arraysAndStrings.anagrams(new char[]{'a', 'b', 'c', 'a'}, new char[]{'b', 'c', 'a'}));
        assertTrue(arraysAndStrings.anagrams(new char[]{' '}, new char[]{' '}));
        assertFalse(arraysAndStrings.anagrams(null, new char[]{' '}));
    }

    @Test
    public void testReplaceSpacesWithChar() {
        assertTrue(arraysAndStrings.compareArrays(new char[]{'a', '%', '2', '0', 'b'}, arraysAndStrings.replaceSpacesWithChar(new char[]{'a', ' ', 'b'})));
        assertTrue(arraysAndStrings.compareArrays(new char[]{'a', 'b', 'c'}, arraysAndStrings.replaceSpacesWithChar(new char[]{'a', 'b', 'c'})));
        assertTrue(arraysAndStrings.compareArrays(new char[]{'%', '2', '0', '%', '2', '0', '%', '2', '0'}, arraysAndStrings.replaceSpacesWithChar(new char[]{' ', ' ', ' '})));
    }
}