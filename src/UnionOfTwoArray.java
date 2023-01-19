//UNION OF 2 ARRAYS
//Count the total number of elements in union of two arrays sets.
import java.util.*;
public class UnionOfTwoArray {
    public static int unionOfArray(int arr1[], int arr2[]){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr1.length ; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length ; i++) {
            set.add(arr2[i]);
        }
        return set.size();
    }
    public static void main(String[] args) {
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println(unionOfArray(arr1,arr2));
    }
}
