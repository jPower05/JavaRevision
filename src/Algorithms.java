public class Algorithms {
    public static void main(String[] args){

        int[] array = new int[] {5,9,4,3,11,2,6};
        int[] ordered = new int[] {1,2,3,4,5};
        //System.out.println(binarySearch(ordered,11));
        //int[] bubbleSorted = bubbleSort(array);
        //int[] selectionSorted = selectionSort(array);
        //int[] insertionSorted = insertionSort(array);
        //int[] quickSorted = quickSort(array, 0, array.length-1);
        int[] mergeSorted = mergeSort(array);
        print(mergeSorted);
    }

    public static void print(int[] array){
        for(int i : array)
            System.out.print(i + ", ");
    }

    public static int binarySearch(int[] array, int element){
        int index = -1;
        int start = 0;
        int end = array.length-1;

        while(start <= end){
            int middle = (start + end) / 2;
            if(array[middle] == element)
                return middle;
            else if(array[middle] < element){
                end = middle -1;
            }
            else{
                start = middle +1;
            }
        }
        return index;
    }

    public static int[] bubbleSort(int[] array){
        int length = array.length;
        int temp = 0;

        for(int i = 0; i < length -1; i++){
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
        // loop and put the smallest element at the start
        int smallestIndex = 0;
        int length = array.length;
        int temp = -1;
        for(int i = 0; i < length-1; i++){
            smallestIndex = i;
            for(int j = i; j < length-1; j++){
                if(array[j] < array[smallestIndex]){
                    smallestIndex = j;
                }
            }
            // swap smallest to first index
            temp = array[smallestIndex];
            array[smallestIndex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static int[] insertionSort(int[] array){
        for(int i = 1; i < array.length; i++){
            int temp = array[i];
            int j = i-1;

            while(j >= 0 && array[j] > temp){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
        return array;
    }

    public static int[] quickSort(int[] array, int start, int end){
        if (end <= start){
            return array;
        }

        int partition = partition(array, start, end);
        quickSort(array, start, partition-1);
        quickSort(array, partition+1, end);
        return array;
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int i = start-1;
        int temp = -1;

        for(int j = start ; j <= end -1; j++){
            if(array[j] < pivot){
                i++;
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        i++;
        temp = array[end];
        array[end] = array[i];
        array[i] = temp;
        return i;



    }

    private static int[] mergeSort(int[] array){
        int length = array.length;
        if(length <= 1){
            return array;
        }
        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int i = 0;
        int j =0;
        for(; i < length; i++){
            if(i < middle){
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

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;

        int i = 0; int l = 0; int r = 0;

        while(l < leftArraySize && r < rightArraySize){
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
        while(l < leftArraySize){
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while(r < rightArraySize){
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }
}
