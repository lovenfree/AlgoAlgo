package me.jeiyai.sort;

public class sort {

	public static int[] selectionSort(int[] array) {
		int min;
		int minIdx;
		
		for(int i=0;i<array.length-1;i++) {

			minIdx = i;
			min = array[minIdx];
			
			for(int j=i+1;j<array.length;j++) {
				if (array[j] < min) {
					minIdx = j;
					min = array[j];
						
				}
			}
			
			array[minIdx] = array[i];
			array[i] = min;
			
		}
		
		return array;
		
	}
	
	public static int[] insertionSort(int[] array) {
		int size =  array.length;
		
		for(int i=1;i<size;i++) {
			int base = array[i]; //비교 기준 
			int cidx= i-1; //비교할 대상
			
			while(cidx >= 0 && base < array[cidx]) {
				array[cidx+1] = array[cidx];
				cidx--;
			}
			
			array[cidx+1] = base;
		}
		
		return array;
		
	}
	
	
	public static int[] bubbleSort(int[] array) {
		int size = array.length;
		
		for (int i=0; i<size-1;i++) {
			for(int j=1;j<size-1;j++) {
				if (array[j-1] > array[j]) {
					int t = array[j-1];
					array[j-1] = array[j];
					array[j] = t;
					
				}
		
			}
		}
		
		return array;
		
	}
	
	
	public static int[] quickSort(int[] array) {
		return quickSort(array,0,array.length-1);
		
	}

	public static int[] quickSort(int[] array, int start, int end) {
		int partition2 = partiton(array, start, end);
		
		if (start < partition2-1) {
			quickSort(array, start, partition2-1);
		}
		if(partition2<end) {
			quickSort(array, partition2, end);
		}
		
		return array;
				
	}
	
	
	public static int partiton(int[] array, int start, int end) {
		int pivot = array[(start+end)/2];
		
		while(start<=end)
		{
			while(array[start] < pivot) start++;
			while(array[end]>pivot ) end--;
			if(start<=end) {
				swap(array,start,end);
				start++;
				end--;
			}
		}
		return start;
	}
	
	public static int[] mergeSort(int[] array) {
		int[] temp = new int[array.length];
		
		return mergeSort(array, temp, 0, array.length-1);
		
	}
	
	public static int[] mergeSort(int[] array, int[] temp, int start, int end) {
		if(start< end) {
			int mid = (start+end)/2;
			mergeSort(array, temp, start, mid);
			mergeSort(array, temp, mid+1, end);
			merge(array,temp,start,mid,end);		
		}
		return array;
		
	}
	
	public static int[] merge(int[] array, int[] temp, int start, int mid, int end) {
		for(int i=start;i<=end;i++) {
			temp[i] = array[i];
		}
		
		int part1 = start;
		int part2 = mid+1;
		int idx = start;
		
		while(part1<=mid && part2<=end) {
			if(temp[part1]<= temp[part2]) {
				array[idx++] = temp[part1++];
			}else {
				array[idx++] = temp[part2++];
				
			}
		}
		
		
		//앞에 남은 배열 복사
		for(int i=0;i<=mid-part1;i++) {
			array[idx+i] = temp[part1+i];
		}
		
		return array;
		
	
	}
	public static void swap(int[] array, int start, int end) {
		int tmp = array[start];
		array[start] = array[end];
		array[end]=tmp;
	}
	
	public static void  main(String[] args) {
		
		int[] unsortedArray= {9,6,1,8,4,3,7,2,0,5};
		int[] result;
		
		result = selectionSort(unsortedArray);
		System.out.println("### SelectionSort ###");
		printArray(result);
		
		
		result = insertionSort(unsortedArray);
		System.out.println("### InsertionSort ###");
		printArray(result);
		
		result = bubbleSort(unsortedArray);
		System.out.println("### bubbleSort ###");
		printArray(result);
		
		result = quickSort(unsortedArray);
		System.out.println("### quickSort ###");
		printArray(result);
		
		result = mergeSort(unsortedArray);
		System.out.println("### mergeSort ###");
		printArray(result);
	}
	
	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i +",");
		}
		System.out.println();
	}
}
