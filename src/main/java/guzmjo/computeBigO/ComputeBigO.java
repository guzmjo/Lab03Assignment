/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package guzmjo.computeBigO;

/**Finds and shows how to display the Big O for
 * an algorithm that returns the largest product
 * between two elements in an array
 *
 * @author Jakob
 */
public class ComputeBigO {

        public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int[] arr2 = {1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] arr4 = {1, 2, 3, 4, 5, 6};
        int[] arr5 = {1, 2, 3, 4, 5, 6, 7};
        int []arr6 = {1, 2, 3, 4, 5, 6, 7, 8};
        int []arr7 = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        displayResults(arr, arr.length);
        displayResults(arr2, arr2.length);
        displayResults(arr3, arr3.length);
        displayResults(arr4, arr4.length);
        displayResults(arr5, arr5.length);
        displayResults(arr6, arr6.length);
        displayResults(arr7, arr7.length);
        
        System.out.println("The number of steps increases by approximately the power of 2 when n increases.");
        System.out.println("Therefore, the Big O of n is approximately O(n^2)");
           
    }

    public static int getLargest(int arr[], int sz) {
        int iterate1 = 0;
        int iterate2 = 0;
        int largest = 0;

        while (iterate1 <sz - 1) {
            iterate2++;
            
            if (iterate2 == sz) {
                iterate1++;
                iterate2 = iterate1;
                continue;
            }

            int product = arr[iterate1] * arr[iterate2];

            if (product > largest) {
                largest = product;
            }
        }

        return largest;

    }

    
    /**Count steps it takes to getLargest finish 
     * 
     * @param arr array of integers
     * @param sz length of the array
     * @return the amount of steps it takes getLargest to finish
     */
    public static int countSteps(int arr[], int sz) {
        int iterate1 = 0;
        int iterate2 = 0;
        int largest = 0;
        int steps = 4; //initiliazed to 4 because of the 3 declarations and the return statement 
        
        while (iterate1 <sz - 1) {
            iterate2++;
            steps++;
            
            if (iterate2 == sz) {
                iterate1++;
                iterate2 = iterate1;
                steps += 2;
                continue;
            }

            int product = arr[iterate1] * arr[iterate2];
            steps++;

            if (product > largest) {
                largest = product;
                steps++;
            }
        }

        return steps;
    }

    
    /**Display the results of calling getLargest() & countSteps()
     * 
     * @param arr array of integers
     * @param sz size of the array
     */
    public static void displayResults(int[] arr, int sz) {
        int largestVal = getLargest(arr, sz);
        int steps = countSteps(arr, sz);

        System.out.println("Given an array of " + arr.length + " integers: ");
        System.out.print("{ ");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("}");

        System.out.println("Greatest Product Between Two Elements: " + largestVal);
        System.out.println("    Number of Steps: " + steps);

        System.out.println();
    }
}
