// didn't do this code
import java.util.*;

public class PrintSearches<T> {
   public void print(T[] sortedArray, T[] searchKeys, Comparator <T> comparer,
      int[] expectedResults, boolean keyInQuotes) {
      // If keyInQuotes is true, " characters surround the key in output
      // statements. Otherwise empty strings surround the key.
      String extra = keyInQuotes ? "\"" : "";
      
      // Iterate through array of search keys and search for each
      int passCount = 0;
      for (int i = 0; i < searchKeys.length; i++) {
         // Get the key to search for
         T searchKey = searchKeys[i];
         
         // Perform the search
         Searcher<T> searcher = new Searcher<T>();
         int index = searcher.binarySearch(sortedArray,
               searchKey, comparer);
         
         // Compare actual result against expected
         int expected = expectedResults[i];
         if (index == expected) {
            System.out.print("PASS: Search for key ");
            System.out.print(extra);
            System.out.print(searchKey);
            System.out.print(extra);
            System.out.print(" returned ");
            System.out.print(expected);
            System.out.print(".");
            System.out.print("\n");
            
            passCount++;
         }
         else {
            System.out.print("FAIL: Search for key ");
            System.out.print(extra);
            System.out.print(searchKey);
            System.out.print(extra);
            System.out.print(" should have returned ");
            System.out.print(expected);
            System.out.print(", but returned ");
            System.out.print(index);
            System.out.print(".");
            System.out.print("\n");
         }
      }
      
      // Print how many tests passed
      System.out.println(passCount + " of " + searchKeys.length +
         " tests passed");
   }
}
