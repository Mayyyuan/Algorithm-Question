package W100;
/**
 * 二叉树任意两个节点间的最大距离
 * @author myy
 *
 */
public class m23_maxDisTree {
	static int res;
	public static void main(String[] args) {
		int max=0;
		TreeNode root = new TreeNode(2);
		root.right=new TreeNode(4);
		root.left=new TreeNode(3);
		root.left.right=new TreeNode(3);
		root.left.left=new TreeNode(3);
		root.left.left.left=new TreeNode(3);
		root.left.left.left.right=new TreeNode(3);
		root.left.right=new TreeNode(1);
		root.left.right.right=new TreeNode(1);
		System.out.println(maxDis(root));
		System.out.println(maxDis1(root));
	}
	public static int maxDis(TreeNode root) {
		Depth(root);
		return root.res;
		
	}
	public static int Depth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		if(root.left!=null) {
			root.l_depth=Depth(root.left);
			root.res=Math.max(root.res,root.left.res);
		}
		if(root.right!=null) {
			root.r_depth=Depth(root.right);
			root.res=Math.max(root.res,root.right.res);
		}
		int sum=root.l_depth+root.r_depth;
		root.res=Math.max(root.res, sum);
		return Math.max(root.l_depth,root.r_depth)+1;
	}
	public static int maxDis1(TreeNode root) {
		res=Integer.MIN_VALUE;
		helper(root);
		return res;
	}
	public static int helper(TreeNode node) {
		if(node==null) {
			return 0;
		}
		int left=helper(node.left);
		int right=helper(node.right);
		res=Math.max(res,left+right);
		return Math.max(left,right)+1;
	}
}
class TreeNode {
	int l_depth;
	int r_depth;
	int res;
	int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
