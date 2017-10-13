package stack;

import java.util.List;

import static stack.Solution.$;

/**
 * Question no.71
 * Question no.69 + reserve
 */
public class Solution3 {
    public static void main(String[] args) {
        System.out.println(new Solution3()
                .zigzagLevelOrder(Solution.getTree(3,
                        9, 20,
                        $, $, 15, 7,
                        $, $, $, $, $, $, 6, 7)));
        System.out.println(new Solution3()
                .zigzagLevelOrder(Solution.getTree(
                        1,
                        2, 3,
                        4, $, $, 5,
                        $, $, $, $, $, $, 6, 7,
                        $, $, $, $, $, $, $, $, $, $, $, $, $, $, 8, 9)));
        System.out.println(new Solution3()
                .zigzagLevelOrder(Solution.getTree(
                        0,
                        2, 1,
                        5, 6, 3, 4)));
    }
    /*
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(Solution.TreeNode root) {
        List<List<Integer>> listList = new Solution().levelOrder(root);
        reserve(listList, 1);
        return listList;
    }

    private void reserve(List<List<Integer>> listList, int index) {
        if (index < listList.size()) {
            List<Integer> list = listList.get(index);
            int size = list.size();
            for (int i = 0; i < size >>> 1; i++) {
                Integer tmp = list.get(i);
                list.set(i, list.get(size - 1 - i));
                list.set(size - 1 - i, tmp);
            }
            reserve(listList, index + 2);
        }
    }
}