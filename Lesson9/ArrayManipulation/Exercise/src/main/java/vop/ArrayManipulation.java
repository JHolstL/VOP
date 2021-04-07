package vop;


import java.util.Arrays;
import java.util.Random;


/**
 * OOP test eksamen f09 opg 1
 * @author erso
 */
public class ArrayManipulation {

    public int[] evenOdd(int[] array) {
        int left = 0, right = array.length - 1;
        while (left<right){
            while(array[right]%2 == 0 && left<right)
                right--;

            while(array[left]%2 == 1 && left < right)
                left++;

            if (left < right){
                int temp = array[right];
                array[right] = array[left];
                array[left] = temp;
                left++;
                right--;
            }
        }
        sort(array,5);
        return array;
    }

    private void sort(int [] array, int splitIndex){
        int temp;
        if (array[0]< splitIndex) {
            for (int i = 0; i < splitIndex; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i++] = temp;
                }
            }
        }
    }

    public static void main(String [] arg){
        Random generator = new Random(222);
        int[] array = new int [10];
        for(int i = 0; i < array.length; i++){
            array[i] = generator.nextInt(100);
        }
        System.out.println("Input:  "+Arrays.toString(array));

        ArrayManipulation arrMani = new ArrayManipulation();
    
        int[] result = arrMani.evenOdd(array);
        System.out.println("Output: " +Arrays.toString(result));
    }
}

    
