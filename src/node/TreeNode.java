package node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The common definition of treeNode for all classes may relate to binary-tree
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(){
    }

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val,TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;// TODO Auto-generated constructor stub
    }

    public TreeNode setTree(Integer[] data)//data为传入的形参数组，如Integer[] nums = {1,2,null,4,null,5}
    {
        TreeNode root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<TreeNode>();//先入先出，构造子树
        queue.offer(root);
        int i = 1;//从第二个元素开始入列
        while(i<data.length)
        {
            TreeNode node = queue.poll();//弹出队列中的树节点
            if(data[i] != null)//当实参的元素不为null时，添加左节点
            {
                node.left = new TreeNode(data[i]);
                queue.offer(node.left);
            }
            i++;//不管实参(传入Integer[] data的Integer数组)的元素是不是null，均需要后移一位
            if(i<data.length && data[i] != null)//当实参的元素不为null时，添加右节点
            {
                node.right = new TreeNode(data[i]);
                queue.offer(node.right);
            }
            i++;
        }
        return root;//返回根节点
    }
}