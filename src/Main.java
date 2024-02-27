import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        Cat myCat = new Cat("Freddy", "Iams");
//        myCat.introduce();
//        myCat.aboutMe();
//        myCat.howIMove();
//
//
//        Cat.Collar collar = new Cat.Collar("red");
//        System.out.println(collar.colour);
//
//        Dog myDog = new Dog("Harry", 74);
//
//        ArrayList<Animal> animals = new ArrayList<Animal>();
//        animals.add(myCat);
//        animals.add(myDog);
//
//        animalStuff(animals);
//
//        listDangerLevels();

        //System.out.println(gridPaths(4,4));

        //printAllStrings("abc");

        //int[] values = {0, 2, 7, 9, 14, 25, 52, 63, 79, 100};
        //System.out.println(findIndexofValue(values, 25));

        int[] unsortedValues = {1,7, 2, 5, 9, 3};

        int[] sortedValues = jQuickSort(unsortedValues, 0 , unsortedValues.length-1);

        //int[] sortedValues = mergeSort(unsortedValues);

        printValues(sortedValues);

    }

    public static void animalStuff(ArrayList<Animal> animals){
        animals.forEach(x -> {
            x.introduce();

            if (x instanceof Dog){
                System.out.println(((Dog) x).getRegNum());
            }

            if (x instanceof Cat){
                System.out.println(((Cat) x).getBreed());
            }

        });



    }

    public static int gridPaths(int n, int m){
        System.out.println("Grid Path " + n + " : " + m);
        if (n == 1 || m == 1){
            return 1;
        }
        else{
            int gridPathM = gridPaths(n, m-1);
            //System.out.println("Grid path m-1 " + gridPathM);
            int gridPathN = gridPaths(n-1, m);
            //System.out.println("Grid path n-1 " + gridPathN);
            int totalPath = gridPathM + gridPathN;
            System.out.println("Total for m: " + m + " n: " + n + " is : " + totalPath);
            return  totalPath;
        }
    }

    public static void listDangerLevels(){
        for(DangerLevel dl : DangerLevel.values()){
            System.out.println(dl.toString());
        }
    }

    public static void printAllStrings(String input){
        printAllStringsHelper("", input);

    }

    public static void printAllStringsHelper(String prefix, String remaining){
        System.out.println("Prefix:: " + prefix);

        for(int i = 0; i < remaining.length(); i++){
            //System.out.println("Current int < Remaining.length :: "+ i + " < " + remaining.length());
            String newPrefix = prefix + remaining.charAt(i);
            //System.out.println("New Prefix:: " + newPrefix);
            String newRem = remaining.substring(0,i) + remaining.substring(i+1);
            //System.out.println("New Remainder:: " + newRem);
            printAllStringsHelper(newPrefix, newRem);
        }
        //System.out.println("Out of for loop");
    }

    public static int findIndexofValue(int[] values, int value){
        // binary search
        int leftIndex = 0;
        int endIndex = values.length-1;
        while (leftIndex <= endIndex){
            int middleIndex = (leftIndex + endIndex) / 2;
            //System.out.println(middleIndex);
            if (values[middleIndex] == value){
                System.out.println("found");
                return middleIndex;
            }
            else if(values[middleIndex] < value){
                leftIndex = middleIndex -1;
            }
            else{
                endIndex = middleIndex + 1;
            }
        }

        return -1;
    }

    public static int[] bubbleSort(int[] values){
        int temp = 0;
        int size = values.length;

        for(int j = 0; j < size; j++){
            for(int i = 0; i < size-j-1; i++){
                if(values[i] > values[i+1]){
                    temp = values[i];
                    values[i] = values[i+1];
                    values[i+1] = temp;
                }
            }
        }
        return values;
    }

    public static int[] selectionSort(int[] values){
        int minIndex = -1;
        int temp = 0;
        int size = values.length;

        for(int i = 0; i < size-1; i++){
            minIndex = i;
            for(int j = i+1 ; j < size; j++){
                if (values[minIndex] > values[j]){
                    minIndex = j;
                }
            }
            temp = values[minIndex];
            values[minIndex] = values[i];
            values[i] = temp;
        }
        return values;
    }

    public static int[] insertionSort(int[] values){
        int size = values.length;

        for(int i = 1; i < size; i++){
            int key = values[i];
            int j = i-1;

            while(j >= 0 && values[j] > key){
                values[j+1] = values[j];
                j--;
            }

            values[j+1] = key;
        }
        return values;
    }

    public static int[] quickSort(int [] values, int start, int end){

        if (end <= start){
            return values;
        }

        int pivot = partition(values, start, end);
        quickSort(values, start, pivot-1);
        quickSort(values, pivot+1, end);

        return values;
    }

    /*
        // need an j variable (starting at index 0)
        // a an i variable (starting at index -1)
        // a temp variable for swapping
        // a pivot (by choosing the last array element

        // iterate until j reaches the pivot

        // each iteration check if the value at index j is less that the value of the pivot
        // if it is -> increment i , then swap i and j using the temp variable
        // if not do nothing

        // once j reaches the pivot
        // increment i and swap i and the pivot
        // elements to the left of the pivot will be less than the pivot
        // elements to the right of the pivot will be greater than the pivot

        // recursively call the partion logic above on the arrays one less than pivot and 1 greater than pivot
     */
    public static int partition(int [] values, int start, int end){
        int pivot = values[end];
        int i = start -1;
        int temp = -1;
        for (int j = start; j <= end -1; j++){
            if(values[j] < pivot){
                i++;
                temp = values[j];
                values[j] = values[i];
                values[i] = temp;
            }
        }
        i++;
        temp = values[i];
        values[i] = values[end];
        values[end] = temp;

        return i;
    }

    public static int[] mergeSort(int[] array){
        int length = array.length;
        if (length <= 1) return array;

        int middle = length/2;
        int[] leftArray = new int[middle];
        int[] rightArray = new int[length-middle];

        int i = 0; // left array
        int j = 0; // right array
        for(; i < length; i++){
            if(i < middle)
                leftArray[i] = array[i];
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
    private static void merge(int[] leftArray, int[] rightArray, int[] array){
        //cache array sizes
        int leftArraySize = leftArray.length;
        int rightArraySize = rightArray.length;

        int i =0, l = 0, r =0; //array indices

        // compare the arrays and find which array holds the smallest value
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

    public static void printValues(int[] values){
        for (int val : values) {
            System.out.print(val + ",");
        }
        System.out.println(" ");
    }

    public static int[] jQuickSort(int[] array, int start, int end){
        if (end <= start)
            return array;

        int pivot = jPartition(array, start, end);
        jQuickSort(array, start, pivot-1);
        jQuickSort(array, pivot +1 , end);

        return array;
    }

    public static int jPartition(int[] array, int start, int end){
        int pivot = array[end];

        int i = start-1;
        int temp = -1;

        for(int j = start; j <= end-1; j++){
            if(array[j] < pivot){
                i++;
                temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        i++;
        temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }
}