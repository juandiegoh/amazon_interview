import java.util.HashSet;
import java.util.Set;

public class ArraysAndStrings {

    /**
     * 1.1 Implement an algorithm to determine if a string has all unique characters What if you can not use additional
     * data structures?
     *
     * @return
     */
    public Boolean uniqueCharacters(String s) {
        Set<Character> characters = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.contains(c)) {
                return false;
            }
            characters.add(c);
        }
        return true;
    }

    /**
     * 1.1 Implement an algorithm to determine if a string has all unique characters What if you can not use additional
     * data structures?
     *
     * @return
     */
    public Boolean uniqueCharactersWithoutExtraDataStructure(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ci = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char cj = s.charAt(j);
                if (ci == cj) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 1 2 Write code to reverse a C-Style String (C-String means that “abcd” is represented as five characters,
     * including the null character )
     *
     * @param cs
     * @return
     */
    public char[] reverseCStyleString(char[] cs) {
        int i = 0;
        int j = cs.length - 1;
        while (i <= j) {
            char aux = cs[i];
            cs[i] = cs[j];
            cs[j] = aux;
            i++;
            j--;
        }
        return cs;
    }

    /**
     * 1.3 Design an algorithm and write code to remove the duplicate characters in a string without using any
     * additional buffer NOTE: One or two additional variables are fine An extra copy of the array is not
     */
    public String removeDuplicates(char[] s) {
        return null;
    }

    /**
     * 1.4 Write a method to decide if two strings are anagrams or not
     */
    public Boolean anagrams(char[] s1, char[] s2) {
        if ((s1 == null && s2 != null)
                || (s1 != null && s2 == null)
                || (s1.length != s2.length)) {
            return false;
        }

        if (s1 == null && s2 == null) {
            return true;
        }

        return compareArrays(bubbleSort(s1), bubbleSort(s2));
    }

    private char[] bubbleSort(char[] s) {
        for (int i = 0; i < s.length; i++) {
            boolean swap = false;
            for (int j = 0; j < s.length - i - 1; j++) {
                if (s[j] > s[j + 1]) {
                    char aux = s[j];
                    s[j] = s[j + 1];
                    s[j + 1] = aux;
                    swap = true;
                }
            }

            if (!swap) {
                return s;
            }
        }
        return s;
    }


    public static boolean compareArrays(char[] a1, char[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean compareIntArrays(int[] a1, int[] a2) {
        if (a1.length != a2.length) {
            return false;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 1 5 Write a method to replace all spaces in a string with ‘%20’
     * @param s
     * @return
     */
    public char [] replaceSpacesWithChar(char [] s) {
        int spaceCount = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                spaceCount++;
            }
        }

        int newLength = s.length + (spaceCount * 2);
        char [] res = new char[newLength];
        int newCounter = 0;
        for(int i = 0; i < s.length; i++) {
            if(s[i] == ' ') {
                res[newCounter] = '%';
                res[newCounter += 1] = '2';
                res[newCounter += 1] = '0';
                newCounter++;
            } else {
                res[newCounter] = s[i];
                newCounter++;
            }
        }
        return res;
    }
}
