package stack;

import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int $ = Integer.MAX_VALUE;
        System.out.println(new Solution2()
                .levelOrderBottom(Solution.getTree(1, 2, 3,
                        4, $, $, 5,
                        $, $, $, $, $, $, 6, 7,
                        $, $, $, $, $, $, $, $, $, $, $, $, $, $, $, 8)));
    }
    /*
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(Solution.TreeNode root) {
        List<List<Integer>> listList = new Solution().levelOrder(root);
        reserve(listList);
        return listList;
    }

    private void reserve(List<List<Integer>> listList) {
        final int size = listList.size();
        for (int i = 0; i < size >>> 1; i++) {
            List<Integer> list = listList.get(i);
            listList.set(i, listList.get(size - 1 - i));
            listList.set(size - 1 - i, list);
        }
    }
}