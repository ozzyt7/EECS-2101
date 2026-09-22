package q1Arrays;

/**
 * Finds the 5 repeated integers in array B
 * 
 * This class implements three sorting algorithms:
 * 1. Bubble Sort
 * 2. Selection Sort
 * 3. Insertion Sort
 * 4.Frequency Counting Array
 * 
 * Each method sorts the array and then finds duplicates
 */
    
public class Q1 {
		    // ==================== METHOD 1: BUBBLE SORT ====================
	    
	    /**
	     * Sorts array using Bubble Sort algorithm
	     * Repeatedly steps through the list, compares adjacent elements and swaps them if wrong order
	     * 
	     * @param arr array to be sorted (will be modified)
	     */
	    private static void bubbleSort(int[] arr) {
	        int n = arr.length;
	        
	        for (int i = 0; i < n - 1; i++) {
	        	for (int j = 0; j < n - i - 1; j++) {
	        		if (arr[j] > arr[j + 1]) {
	        			int temp = arr[j];
	        			arr[j] = arr[j + 1];
	        			arr[j + 1] = temp;
	        		}
	        	}
	        }
	    }
	    
	    /**
	     * Finds repeated numbers using Bubble Sort approach
	     * 
	     * @param B array of size n containing integers from 1 to n-5
	     * @return array containing exactly 5 repeated integers
	     */
	    public static int[] findRepeatedNumbersBubbleSort(int[] B) {
	    	if (B == null || B.length < 10) {
	    		throw new IllegalArgumentException("Array must not be null and have atleast 10 elements");
	    	}
	    	
	    	int[] newCount = new int[5];
	    	bubbleSort(B);
	    	int r = 0;
	    	
	    	for (int i = 0; i < B.length - 1; i++) {
	    		if (B[i] == B[i + 1]) {
	    			newCount[r++] = B[i + 1];
	    		}
	    	}
	        return newCount;
	    }
	    
	    // ==================== METHOD 2: SELECTION SORT ====================
	    
	    /**
	     * Sorts array using Selection Sort algorithm
	     * Divides array into sorted and unsorted regions, repeatedly selects minimum from unsorted
	     * 
	     * @param arr array to be sorted (will be modified)
	     */
	    private static void selectionSort(int[] arr) {
	    	if (arr == null) {
	    		throw new IllegalArgumentException("Array must not be empty");
	    	}
	    	
	    	if (arr.length <= 1) return;
	    	
	    	int n = arr.length;
	    	for (int i = 0; i < n - 1; i++) {
	    		int minIndex = i;
	    		
	    		for (int j = i + 1; j < n; j++) {
	    			if (arr[j] < arr[minIndex]) {
	    				minIndex = j;
	    			}
	    		}
	    		
	    		if (minIndex != i) {
	    			int temp = arr[i];
	    			arr[i] = arr[minIndex];
	    			arr[minIndex] = temp;
	    		}
	    	}
	    }
	    
	    /**
	     * Finds repeated numbers using Selection Sort approach
	     * 
	     * @param B array of size n containing integers from 1 to n-5
	     * @return array containing exactly 5 repeated integers
	     */
	    public static int[] findRepeatedNumbersSelectionSort(int[] B) {
	    	if (B == null || B.length < 10) {
	    		throw new IllegalArgumentException("Array must not be null and have atleast 10 elements");
	    	}
	    	
	    	int[] numCount = new int[5];
	    	selectionSort(B);
	    	int r = 0;
	    	
	    	for (int i = 0; i < B.length - 1; i++) {
	    		if (B[i] == B[i + 1]) {
	    			numCount[r++] = B[i + 1];
	    		}
	    	}
	    	
	        return numCount;
	    }
	    
	    // ==================== METHOD 3: INSERTION SORT ====================
	    
	    /**
	     * Sorts array using Insertion Sort algorithm
	     * Builds final sorted array one item at a time by inserting each element in correct position
	     * 
	     * @param arr array to be sorted (will be modified)
	     */
	    private static void insertionSort(int[] arr) {
	    	if (arr == null) {
	    		throw new IllegalArgumentException("Array must not be null");	
	    	}
	    	
	    	if (arr.length <= 1) {
	    		return;
	    	}
	    	
	    	for (int i = 0; i < arr.length; i++) {
	    		int key = arr[i];
	    		int j;
	    		
	    		for (j = i - 1; j >= 0; j--) {
	    			if (arr[j] > key) {
	    				arr[j + 1] = arr[j];
	    			}
	    			else {
	    				break;
	    			}
	    		}
	    		
	    		arr[j + 1] = key;
	    	}
	    	
	    }
	    
	    /**
	     * Finds repeated numbers using Insertion Sort approach
	     * 
	     * @param B array of size n containing integers from 1 to n-5
	     * @return array containing exactly 5 repeated integers
	     */
	    public static int[] findRepeatedNumbersInsertionSort(int[] B) {
	    	if (B == null || B.length < 10) {
	    		throw new IllegalArgumentException("Array must not be null and have atleast 10 elements");
	    	}
	    	
	    	int[] numCount = new int[5];
	    	insertionSort(B);
	    	int r = 0;
	    	
	    	for (int k = 0; k < B.length - 1; k++) {
	    		if (B[k] == B[k + 1]) {
	    			numCount[r++] = B[k + 1];
	    		}
	    	}
	    	return numCount;
	    }
	    
	    // ==================== METHOD 4: Frequency Counting Array ====================
	    /**
	     * Finds repeated numbers using frequency counting approach
	     * 
	     * @param B array of size n containing integers from 1 to n-5
	     * @return array containing exactly 5 repeated integers
	     * <pre> B.length >= 10
	     * <pre> B contains integers in range [1, n-5]
	     * <pre> exactly 5 integers are repeated (appear twice)
	     */
	    public static int[] findRepeatedNumbers(int[] B) {
	    	if (B == null || B.length < 10) {
	    		throw new IllegalArgumentException("Array must not be null and must have atleast 10 elements");
	    	}
	    	int num = B.length - 5;
	    	int[] freqArr = new int[num];
	    	
	    	for (int i = 0; i < B.length; i++) {
	    		int a = B[i];
	    		int count = 1;
	    		
	    		for (int j = i + 1; j < B.length; j++) {
	    			if (B[j] == a) {
	    				count = 2;
	    				break;
	    			}
	    		}
	    		
	    		if (freqArr[a - 1] == 2) {
	    			continue;
	    		}
	    		
	    		freqArr[a - 1] = count;
	    		
	    	}
	    	int[] rep = new int[5];
	    	int r = 0;
	    	for (int k = 0; k < freqArr.length; k++) {
	    		if (freqArr[k] == 2) {
	    			rep[r++] = k + 1;
	    		}
	    	}
	    	
	    	
	    	return rep;
	    }
	    
	}