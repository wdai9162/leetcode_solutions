package solutionpackage;
import java.util.List;
import java.util.ArrayList;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<Integer>();
        
        if(root == null) { return null; }                    //this is the base case where recursion stops 
        results.add(root.val);
        
        if(root.left!=null){
            results.addAll(preorderTraversal(root.left));
        }
        if(root.right!=null){
            results.addAll(preorderTraversal(root.right));
        }
        
        return results;
    }
}
