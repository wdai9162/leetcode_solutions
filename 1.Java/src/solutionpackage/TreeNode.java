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
        
        if(root == null) { return results; }                    //this is the base case where recursion stops 
        
        results.add(root.val);
        results.addAll(preorderTraversal(root.left));
        results.addAll(preorderTraversal(root.right));
        
        return results;
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> results = new ArrayList<Integer>();

        if (root == null) { return results; }
        
        results.addAll(inorderTraversal(root.left));
        results.add(root.val);
        results.addAll(inorderTraversal(root.right));
        
        return results; 
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> results = new ArrayList<Integer>();

        if (root == null) { return results; }
        
        results.addAll(postorderTraversal(root.left));
        results.addAll(postorderTraversal(root.right));
        results.add(root.val);
        
        return results; 
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        List<TreeNode> tempQueue = new ArrayList<TreeNode>();

        if (root == null) {
            return results;
        }

        tempQueue.add(root);

        while (!tempQueue.isEmpty()) {

            
            List<Integer> tempResults = new ArrayList<Integer>();
            int thisLevelSize = tempQueue.size();

            //get all the results for nodes in the queue
            for (TreeNode i: tempQueue){
                tempResults.add(i.val);
            }

            //add the children and remove the node 
            // for (TreeNode i: tempQueue) {        //----> java java.util.concurrentmodificationexception  ❗  ❗ 
            for (int i=0; i < thisLevelSize; i++) {
                if (tempQueue.get(i).left != null) { tempQueue.add(tempQueue.get(i).left);}
                if (tempQueue.get(i).right != null) { tempQueue.add(tempQueue.get(i).right);}
            }

            //remove element will reduce the size...given "tempQueue" is fixed, index becomes tricky. Consider to use Stack. 
            for (int i=0; i < thisLevelSize; i++) {
                tempQueue.remove(0);
            }
            
            results.add(tempResults);
            
        }
        return results; 
    }
}
