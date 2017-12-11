
public class Team9SortCompetition extends SortCompetition {

	@Override
	public int challengeOne(int[] arr)
	{
		int[] count = new int[10000];
		for (int i = 0; i < 10000; i++)
		{
			count[arr[i]]++;
		}
		for (int i = 1; i < 10000; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[10000];
		for (int i = 0; i < 10000; i++)
		{
			sorted[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < 10000; i++)
		{
			arr[i] = sorted[i];
		}
		return ((arr[5000])+(arr[4999]))/2;
	}

	@Override
	public int challengeTwo(String[] arr, String query) { //Change to burst
		quickSort(arr, 0, 10000);
		return binarySearch(arr, query);
	}

	@Override
	public int challengeThree(int[] arr)
	{
		int[] count = new int[10000];
		for (int i = 0; i < 10000; i++)
		{
			count[arr[i]]++;
		}
		for (int i = 1; i < 10000; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[10000];
		for (int i = 0; i < 10000; i++)
		{
			sorted[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < 10000; i++)
		{
			arr[i] = sorted[i];
		}
		return ((arr[5000])+(arr[4999]))/2;
	}

	@Override
	public int challengeFour(int[][] arr) {
		int[] medians = new int[arr.length];
		for (int i = 0; i < arr.length; i++)
		{
			medians[i] = countingSort(arr[i]);
		}
		for (int i = 0; i < medians.length - 1; i++)  
		{  
			int index = i;  
			for (int j = i + 1; j < medians.length; j++){  
				if (medians[j] < medians[index]){  
					index = j;
				}  
			}  
			int temp = medians[index];
			medians[index] = medians[i];
	        medians[i] = temp;
	        
	        int[] temp2 = arr[index];
	        arr[index] = arr[i];
	        arr[i] = temp2;
	    }
		countingSort(medians);
		return ((medians[medians.length/2])+(medians[(medians.length/2)-1]))/2;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public int challengeFive(Comparable[] arr, Comparable query) {
		quickSort(arr, 0, arr.length);
		return binarySearch(arr, query);
	}

	@Override
	public String greeting() {
		return "Team Numba 9 Here";
	}
	
	public static int countingSort(int[] arr)
	{
		int[] count = new int[10000];
		for (int i = 0; i < 100; i++)
		{
			count[arr[i]]++;
		}
		for (int i = 1; i < 10000; i++)
		{
			count[i] = count[i] + count[i-1];
		}
		int[] sorted = new int[10000];
		for (int i = 0; i < 100; i++)
		{
			sorted[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		for (int i = 0; i < 100; i++)
		{
			arr[i] = sorted[i];
		}
		return ((arr[50])+(arr[49]))/2;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static int binarySearch(Comparable[] a, Comparable key) {
		int min = 0;
	    int max = a.length -1;
	    int mid = 0;

	    while (min <= max) 
	    {
	    	mid = min + (max - min) / 2;
	    	if (a[mid].compareTo(key) < 0)
	    	{
	    		min = mid + 1;
	    	}
	    	else if (a[mid].compareTo(key) > 0)
	    	{
	    		max = mid - 1;
	    	}
	    	else if (min != mid)
	    	{
	    		max = mid; // Keeps searching
	    	}
	    	else
	    	{
	    		return mid;
	    	}
	    }
	    return -1;
	}
	
	@SuppressWarnings("rawtypes")
	private static <T extends Comparable<T>> void quickSort(Comparable[] list1, int front, int back) { 
		if (front >= back)
		{
			return;
		}
		else
		{
			int PIVOTindex = partition(list1, front, back);
			quickSort(list1, front, PIVOTindex);
			quickSort(list1, PIVOTindex + 1, back);
		}
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static <T extends Comparable<T>> int partition(Comparable[] list, int front, int back) {
		Comparable pivot = list[front];
		int i = front;
		for (int j = front + 1; j < back; j++)
		{
			if (list[j].compareTo(pivot) <= 0)
			{
				i++;
				Comparable temp = list[j];
				list[j] = list[i];
				list[i] = temp;
			}
		}
		Comparable temp = list[front];
		list[front] = list[i];
		list[i] = temp;
		return i;
    }
}
