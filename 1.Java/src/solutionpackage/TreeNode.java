package solutionpackage;
import java.util.List;
import java.util.ArrayList;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        
        if(root == null) { return null; }
        List<Integer> result = new ArrayList<Integer>();
        

        
        if(curNode.left != null){
            result.add(curNode.left.val);
        } else if(curNode.right != null) {
            result.add(curNode.right.val);
        }
        


        return result;
    }
}
