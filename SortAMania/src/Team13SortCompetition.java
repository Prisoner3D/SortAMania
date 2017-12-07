import java.util.Arrays;

/*
*	Authors: Amir Hasan & Justin Fagan
*	Last Updated: 12-7-2017
*	Description: Sort competition class for team 13.
*/
public class Team13SortCompetition extends SortCompetition
{
	public static void main(String[] args)
	{
		Team13SortCompetition test= new Team13SortCompetition();
		long startTime;
		long endTime;
		long totalTime;
		long avgTime;
		long sumTime=0;
		int count=0;
		while(count<10)
		{
			int[] sortish= generateRandomIntArray(10000);
			startTime=System.nanoTime();
			test.challengeOne(sortish);
			endTime=System.nanoTime();
			totalTime=endTime-startTime;
			System.out.println(totalTime);
			sumTime+=totalTime;
			count++;
		}
		avgTime=sumTime/10;
		System.out.println(avgTime);
	}
	public int challengeOne(int[] arr)
	{
		radixSort(arr,1);
		return getMedian(arr);
	}
	//insertion sort
	public int challengeTwo(String[] list1,String find)
	{
		int tracker;
		int pos=-1;
		for(int x=1;x<list1.length;x++)
		{
			tracker=x;
			while(tracker>0&&list1[tracker].compareTo(list1[tracker-1])<0)
			{
				swap(list1,tracker,tracker-1);
				tracker--;
			}
		}
		for(int y=0;y<list1.length;y++)
		{
			if(list1[y].equals(find))
			{
				pos=y;
				return pos;
			}
		}
		return pos;
	}
	//insertion sort
	public int challengeThree(int[] list)
	{
		int tracker;
		for(int x=1;x<list.length;x++)
		{
			tracker=x;
			while(tracker>0&&list[tracker]<list[tracker-1])
			{
				swap(list,tracker,tracker-1);
				tracker--;
			}
		}
		return getMedian(list);
	}
	//insertion sort on each nested array and records the median, then takes the median of those medians after sorting them
	public int challengeFour(int[][] list)
	{
		int[] meds=new int[list.length];
		for(int x=0;x<list.length;x++)
		{
			meds[x]=challengeThree(list[x]);
		}
		return challengeThree(meds);
	}
	public int challengeFive(Comparable[] list,Comparable obj)
	{
		mergeSort(list);
		for(int x=0;x<list.length;x++)
		{
			if(list[x].compareTo(obj)==0)
			{
				return x;
			}
		}
		return -1;
	}
	public static String[] merge(String[] list1,String[] list2)
	{
		int size= list1.length+list2.length;
		String[] result=new String[size];
		int i=0; //current position in result
		int j=0; //current position in list1
		int k=0; //current position in list2
		while(i<size)
		{
			if(j<list1.length&&k<list2.length)
			{
				if(list1[j].compareTo(list2[k])<0)
				{
					result[i]=list1[j];
					j++;
				}
				else
				{
					result[i]=list2[k];
					k++;
				}
			}
			else if(j==list1.length)
			{
				result[i]=list2[k];
				k++;
			}
			else
			{
				result[i]=list1[j];
				j++;
			}
			i++;
		}
		return result;
	}
	//challengeFive
	public static Comparable[] merge(Comparable[] list1,Comparable[] list2)
	{
		int size= list1.length+list2.length;
		Comparable[] result=new Comparable[size];
		int i=0; //current position in result
		int j=0; //current position in list1
		int k=0; //current position in list2
		while(i<size)
		{
			if(j<list1.length&&k<list2.length)
			{
				if(list1[j].compareTo(list2[k])<0)
				{
					result[i]=list1[j];
					j++;
				}
				else
				{
					result[i]=list2[k];
					k++;
				}
			}
			else if(j==list1.length)
			{
				result[i]=list2[k];
				k++;
			}
			else
			{
				result[i]=list1[j];
				j++;
			}
			i++;
		}
		return result;
	}
	//mergeSort
	public static Comparable[] mergeSort(Comparable[] list)
	{
		if(list.length>1)
		{
			Comparable[] list1=new Comparable[list.length/2];
			Comparable[] list2=new Comparable[list.length-list1.length];
			int z=0;
			for(int x=0;x<list1.length;x++)
			{
				list1[x]=list[x];
				z=x+1;
			}
			for(int y=0;y<list2.length;y++)
			{
				list2[y]=list[z];
				z++;
			}
			Comparable[] sort1=mergeSort(list1);
			Comparable[] sort2=mergeSort(list2);
			Comparable[] newList=merge(sort1,sort2);
			return newList;
		}
		return list;
	}
	//swaps 2 strings in an array
	public static void swap(String arr[],int i, int j)
	{
		String x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}
	//given a sorted array, retrieves the median
	public static int getMedian(int[] list)
	{
		if(list.length%2==1)
		{
			return list[list.length/2];
		}
		else
		{
			return (list[list.length/2]+list[(list.length/2)-1])/2;
		}
	}
	//swaps two objects in an array
	public static void swap(Object arr[],int i, int j)
	{
		Object x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}
	//swaps two ints in an array
	public static void swap(int arr[],int i, int j)
	{
		int x=arr[i];
		arr[i]=arr[j];
		arr[j]=x;
	}
	public String greeting()
	{
		return "Hello, this is team 13's sort class.";
	}
	static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
 
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    private static int getRandomInteger(int low, int high)
	{
		if(low>high)
		{
			int swap=low;
			low=high;
			high=swap;
		}
		return (int)(Math.random()*(high-(low-1))+low);
	}
    private static int[] generateRandomIntArray(int size)
	{
		int[] randomArray= new int[size];
		for(int i=0;i<randomArray.length;i++)
		{
			randomArray[i]=getRandomInteger(0,size);
		}
		return randomArray;
	}
}