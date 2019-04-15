package W100;
/**
 * 旋转数组二分法搜索数
 * @author myy
 *
 */
public class m28_rotateArray {
	public static void main(String[] args) {
		int[] array={4,3,2,1,6,5};
		for(int i=0;i<7;i++) {
			System.out.println(search(array,i));
		}
	}
	public static int search(int[] array,int key) {
		return helper(array,key,0,array.length-1);
	}
	public static int helper(int[] array,int key,int start,int end) {
		if(start>end) {
			return -1;
		}
	    if(array[start]==key) {
	    	return start;
	    }
	    if(array[end]==key) {
	    	return end;
	    }
	    int mid = (start+end)/2;
	    if(array[mid]==key) {
	    	return mid;
	    }
	    if(array[start]>array[mid]) {
	    	if(key<array[start] && key>array[mid]) {
	    		return helper(array,key,start+1,mid-1);
	    	}
	    	else {
	    		return helper(array,key,mid+1,end-1);
	    	}
	    }
	    else {
	    	if(key<array[mid] && key>array[start]) {
	    		return helper(array,key,mid+1,end-1);
	    	}
	    	else {
	    		return helper(array,key,start+1,mid-1);
	    	}
	    }
	}
}
