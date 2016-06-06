package demo;

public class Solution {
	public int InversePairs(int [] array) {
		if(array.length == 0){
			return 0;
		}
        return InversePairs(array,0,array.length-1);
    }
	private int InversePairs(int [] array,int start,int end){
		int result = 0;
		if(start < end){
			int mid = (start + end) / 2;
			result += InversePairs(array,start,mid);
			result += InversePairs(array,mid+1,end);
			result += merge(array,start,mid,end);
		}
		return result;
	}
	private int merge(int [] array,int start,int mid,int end){
		int i = start;
		int j = mid+1;
		int k = 0;
		int[] temp = new int[end - start + 1];
		int result = 0;
		while(i <= mid && j <= end){
			if(array[i] > array[j]){
				result += (end - j + 1);
				temp[k++] = array[i++];
			}
			else{
				temp[k++] = array[j++];
			}
		}
		while(i <= mid){
			temp[k++] = array[i++];
		}
		while(j <= end){
			temp[k++] = array[j++];
		}
		for(int m = start;m <= end;m++){
			array[m] = temp[m - start];
		}
		return result;
	}
}
