package W100;
/**
 * 等差数列最大长度
 * @author myy
 *
 */
import java.util.ArrayList;
import java.util.Arrays;

public class m69_maxLengthDiffer {
	public static void main(String[] args) {
		int[] array = {1,3,0,5,-1,6}; 
		ArrayList<Integer> maxList=findMaxLength(array);
		for(Integer i:maxList) {
			System.out.print(i+",");
		}
	}
	public static ArrayList<Integer> findMaxLength(int[] array) {
		Arrays.sort(array);
		ArrayList<Integer> maxList=new ArrayList<Integer>();
		ArrayList<Integer> list=new ArrayList<Integer>();
		int n=array.length;
		for(int i=0;i<n-1;i++) {
			for (int j=i+1;j<n;j++) {
				list.clear();
				list.add(array[i]);
				list.add(array[j]);
				int differ=array[j]-array[i];
				int curr=j;
				int next=j+1;
				while(next<n) {
					if(array[next]-array[curr]==differ) {
						list.add(array[next]);
						curr=next;
					}
					next++;
				}
				if(list.size()>maxList.size()) {
					maxList=(ArrayList<Integer>) list.clone();
				}
			}
		}
		return maxList;
	}
}
