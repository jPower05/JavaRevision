import java.util.Arrays;

public class Algorithms2 {
    public static void main(String[] args){
        int[] numbers = new int[] {1,2,3,4,5,6,8,44};
        int[] unordered = new int[] {4, 6, 1, 9 , 2, 7, 11, 3};
        //int[] bubbleSorted = bubbleSort(unordered);
        //int[] selectionSorted = selectionSort(unordered);
        //int[] quickSorted = quickSort(unordered, 0, unordered.length-1);
        //int[] mergeSorted = mergeSort(unordered);
        //print(mergeSorted);
        //System.out.println(findIndexofValue(numbers,4));

        String reverse = "reverse";
        String palindrome = "aaa";
        //System.out.println("original : " + reverse + " reversed : " + reverse(reverse));
        System.out.println(isPalindrome(palindrome));
    }

    public static void print(int[] array){
        for(int i : array)
            System.out.print(i + " ");
    }
    public static int findIndexofValue(int[] array, int value){
        int start = 0;
        int end = array.length-1;

        while(end >= start){
            int mid = (start + end) /2;
            if(array[mid] == value){
                return mid;
            }
            else if(array[mid] < value){
                end = mid -1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
    public static int[] bubbleSort(int[] array){
        int length = array.length;
        int temp = 0;

        for(int i = 0; i < length-1; i++){
            for(int j = 0; j < length-1; j++){
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    public static int[] selectionSort(int[] array){
        int length = array.length;
        int temp = -1;
        int smallestIndex = 0;

        for(int i = 0; i < length-1; i++){
            smallestIndex = i;
            for(int j = i; j < length-1; j++){
                if(array[j] < array[smallestIndex]){
                    smallestIndex = j;
                }
            }
            // swap smallest to the start
            temp = array[i];
            array[smallestIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }
    public static int[] quickSort(int[] array, int start, int end){
        if(end >= start){
            return array;
        }
        int pivot = partition(array, start, end);
        quickSort(array, start, pivot-1);
        quickSort(array, pivot+1, end);
        return array;
    }
    public static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int i = start-1;
        int temp = -1;

        for(int j = start; j <= end; j++){
            if(array[j] < pivot){
                i++;
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        temp = array[end];
        array[end] = array[i];
        array[i] = temp;

        return i;
    }
    public static int[] mergeSort(int[] array){
        int length = array.length;
        if(length <= 1){
            return array;
        }
        int mid = length/2;

        int[] leftArray = new int[mid];
        int[] rightArray = new int[length - mid];

        int i = 0; int j = 0;

        for(; i < length; i++){
            if(i < mid){
                leftArray[i] = array[i];
            }
            else{
                rightArray[j] = array[i];
                j++;
            }
        }
        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, array);
        return array;
    }
    public static void merge(int[] leftArray, int[] rightArray, int[] array){
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int i = 0; int r = 0; int l = 0;

        while(r < rightLength && l < leftLength){
            if(leftArray[l] < rightArray[r]){
                array[i] = leftArray[l];
                i++;
                l++;
            }
            else{
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while(l < leftLength){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightLength){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
    public static String reverse(String str){
        char[] strArray = str.toCharArray();
        int start = 0;
        int end = strArray.length-1;
        char temp = '.';

        while(end >= start){
            if(start == end){
                return String.valueOf(strArray);
            }
            // otherwise swap start and end
            temp = strArray[start];
            strArray[start] = strArray[end];
            strArray[end] = temp;
            end --;
            start++;
        }
        return String.valueOf(strArray);
    }
    public static boolean isPalindrome(String str){
        boolean isPalindrome = false;
        char[] strArray = str.toCharArray();
        int start = 0;
        int end = strArray.length-1;

        while(end >= start){
            if(end == start){
                isPalindrome = true;
                return isPalindrome;
            }
            if(strArray[start] != strArray[end]){
                isPalindrome = false;
                return isPalindrome;
            }
            start++;
            end--;
        }
        isPalindrome = true;
        return isPalindrome;
    }
}


