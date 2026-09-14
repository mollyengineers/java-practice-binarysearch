import java.util.*;

public class Searcher<T> {
	// Returns the index of the key in the sorted array, or -1 if the 
	// key is not found.
	public static <T> int binarySearch(T[] array, T key, 
			Comparator<T> comparer) {
			   
		// TODO: Type your code here	
        int startIndex = 0;
        int endIndex = array.length - 1;

        while (startIndex <= endIndex) {
            int middleIndex = (startIndex + endIndex) / 2;
            int isIt = comparer.compare(array[middleIndex], key);

            if (isIt == 0) {
                return middleIndex; // that is the key
            } else if (isIt < 0) {
                startIndex = middleIndex + 1; // key is on right
            } else {
                endIndex = middleIndex - 1; // key is on left
            }
        }
    // end of TODO ^ this is the code I did for this exercise
		return -1;
	}
}
