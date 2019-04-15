package W100;
/**
 * 合并k个有序数组
 * @author myy
 *
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class nArrayMaxK {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list1=new ArrayList<Integer>();
		ArrayList<Integer> list2=new ArrayList<Integer>();
		for(int i=1;i<=7;i++) {
			list1.add(i);
		}
		for(int i=9;i<=20;i++) {
			list2.add(i);
		}
		list.add(list1);
		list.add(list2);
		ArrayList<Integer> res=helper(list,2);
		for(int i=0;i<res.size();i++) {
			System.out.print(res.get(i)+",");
		}
	}
	public static ArrayList<Integer> helper(ArrayList<ArrayList<Integer>> list, int k) {
		ArrayList<Integer> res=new ArrayList<Integer>();
		PriorityQueue<A> maxHeap=new PriorityQueue<A>(new Comparator<A>() {
			public int compare(A a1,A a2) {
				return a2.value-a1.value;
			}
		});
		for(int i=0;i<list.size();i++) {
			A a=new A();
			a.value=list.get(i).get(list.get(i).size()-1);
			a.index=list.get(i).size()-1;
			a.num=i;
			maxHeap.offer(a);
		}
		for(int knum=0;knum<k;knum++) {
			A a=maxHeap.poll();
			res.add(a.value);
			if(a.index!=0) {
				A next=new A();
				next.value=list.get(a.num).get(a.index-1);
				next.num=a.num;
				next.index=a.index-1;
				maxHeap.offer(next);
			}	
		}
		return res;
	}
}

class A {
	Integer index=null;
	Integer num=null;
	Integer value=null;
}