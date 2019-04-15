package W100;
/**
 * 每k个旋转一次链表
 * @author myy
 *
 */
public class reverseListNode {
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		head.next=new ListNode(2);
		head.next.next=new ListNode(3);
		head.next.next.next=new ListNode(4);
		head.next.next.next.next=new ListNode(5);
		head.next.next.next.next.next=new ListNode(6);
		head=reverse(head,3);
		while(head!=null) {
			System.out.println(head.val);
			head=head.next; 
			
		}
		
	}
	public static ListNode reverse(ListNode head,int k) {
		ListNode curr=head;
		int count=0;
		while(curr!=null && count!=k) {
			curr=curr.next;
			count++;
		}
		if(count==k) {
			curr=reverse(curr,k);
			while(count>0) {
				ListNode next=head.next;
				head.next=curr;
				curr=head;
				head=next;
				count--;
			}
			head=curr;
		}
		return head;
	}
}
class ListNode
{
    int val;
    ListNode next;
    public ListNode(int x){
        val=x;
    }
  
}