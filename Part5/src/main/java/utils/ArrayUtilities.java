package utils;

/**
 *
 * @author michelle
 */
public class ArrayUtilities {
    /**
     * @param array The array to be checked
     * @param value The value that needs to be overwritten
     * @param replaceValue The replaced value
     * @return The number of times the value is overwritten
     */
            public static int replace(int[] array, int value, int replaceValue){
//                Validation
                if(array == null){
                    throw new IllegalArgumentException("Array cannot be empty");
                }
//                SETUP
                int count = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i]==value){
                        value = replaceValue;
                        count++;
                    }
                }
//                OUTPUT
                return count;
            }
//            QUESTION 1.2
    /**
     * @param array The array to be checked if sorted or not in Ascending order
     * @return True or false if the array is sorted
     */
    public static boolean isSortedAsc(int[] array){
//                Validation
                if(array == null || array.length <= 1 ){
                    throw new IllegalArgumentException("Array cannot be empty");
                }
//                SETUP
        for (int i = 0; i < array.length -1; i++) {
            if(array[i] > array[i+1]){
                     return false;
                    }
        }
//        OUTPUT
        return true;
    }
//    QUESTION 1.3
    /**
     * @param array The array that needs to be checked
     * @param value The value to be inserted
     * @return True or false if the value is being replaced
     */
    public static boolean shiftInsert(int[] array, int value){
//      VALIDATION
        if(array == null || array.length<= 1) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if(!isSortedAsc(array)) {
            throw new IllegalArgumentException("Array is not sorted");
        }
//        SETUP
        int pos = 0;
        for (int i = array.length - 1; i > pos; i--) {
            if (value > array[i]) {
                pos = i;
            }
        }
        for (int i = array.length - 1; i > pos; i--) {
            array[i] = array[i - 1];
        }
        array[pos] = value;
//        OUTPUT
return  true;
    }

    /**
     * @param array The array to be sorted
     * @return True or false if the array is sorted in descending order or not
     */
//QUESTION 1.4
    public static boolean isSortedDesc(int[] array){
//        VALIDATION
        if (array==null){
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if(array== null || array.length <= 1){
           return true;

        }
//        SETUP
        for (int i = 0; i < array.length-1; i++) {
            if(array[i] < array[i+1]){
                return false;
            }
        }
//        OUTPUT
        return  true;
}

    /**
     * @param array The array that needs a value inserted in
     * @param value The inserted value
     * @return The new resized array
     */
//QUESTION 1.5
    public static int[] resizeInsert(int[] array, int value){
//        VALIDATION
        if(array == null) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        if(!isSortedDesc(array)) {
            throw new IllegalArgumentException("Array is not sorted in Descending order");
        }

//        SETUP
        int tracker = 0;
        int pos =0;
         int [] resized = new int [array.length + 1];
        for (int i = 0; i < pos ; i++) {
            if(pos < array.length && value > array[pos]){
                pos++;
            }
            array[i] = resized[tracker];
            tracker++;
        }
        for (int i = pos; i < array.length ; i++) {
            array[i] = resized[tracker];
            tracker++;
        }
        resized[pos] = value;
//        OUTPUT
        return resized;
    }
}
