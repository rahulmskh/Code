// INTERSECTION OF 2 ARRAYS
// Count the total number of elements in intersection of two array's sets.
import java.util.*;

public class IntersectionOfTwoArray {
    public static int intersectionOfArray(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < arr1.length ; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i <arr2.length ; i++) {
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int arr1[] = {7,3,9,6};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println(intersectionOfArray(arr1,arr2));
    }
}
