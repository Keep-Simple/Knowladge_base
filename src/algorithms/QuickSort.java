package algorithms;

public class QuickSort {
    private static void quickSort(int array[], int lowerIndex, int higherIndex) {
        int i = lowerIndex;
        int j = higherIndex;

        // calculate pivot number
        int pivot = array[(lowerIndex+higherIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) i++;
            while (array[j] > pivot) j--;

            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                //move index to next position on both sides
                i++;
                j--;
            }
        }

        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(array,lowerIndex, j);
        if (i < higherIndex)
            quickSort(array,i, higherIndex);
    }

    public static void sort(int[] array) {
        quickSort(array, 0, array.length-1);
    }

   }



