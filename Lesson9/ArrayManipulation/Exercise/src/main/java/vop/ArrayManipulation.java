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
        sort(array,left);
        return array;
    }

    private void sort(int [] array, int splitIndex){
        Arrays.sort(array, 0, splitIndex);
        for (int i = splitIndex; i<array.length; i++){
            array[i] = -array[i];
        }

        Arrays.sort(array, splitIndex, array.length);
        for(int i = splitIndex; i < array.length; i++){
            array[i] = -array[i];
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

    
