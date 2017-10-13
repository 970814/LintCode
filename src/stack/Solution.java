package stack;

import java.util.ArrayList;
import java.util.List;



public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().levelOrder(new Solution().getTree(3, 9, 20, Integer.MAX_VALUE, Integer.MAX_VALUE, 15, 7)));
    }
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private TreeNode getTree(int... values) {
        return grow(0, values);
    }

    private TreeNode grow(int x, int[] values) {
        TreeNode node = null;
        if (x < values.length && values[x] != Integer.MAX_VALUE) {
            node = new TreeNode(values[x]);
            node.left = grow(2 * x + 1, values);
            node.right = grow(2 * x + 2, values);
        }
        return node;
    }

    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> listList = new ArrayList<>();
        add(root, listList, 0);
        return listList;
    }

    private void add(TreeNode root, List<List<Integer>> listList, int index) {
        if (root != null) {
            if (listList.size() <= index) listList.add(new ArrayList<>());
            listList.get(index).add(root.val);
            add(root.left, listList, index + 1);
            add(root.right, listList, index + 1);
        }
    }
}