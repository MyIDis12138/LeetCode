import java.util.ArrayList;
import java.util.List;

public class solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int index = accounts[0].length;
        for (int i = 0; i < accounts.length; i++) {
            int wealth = 0;
            for (int j = 0; j < index; j++) {
                wealth += accounts[i][j];
            }
            max = max > wealth ? max : wealth;
        }
        return max;
    }

    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<String>();
        String[] out = {"Fizz", "Buzz"};
        for (int i = 0; i < n; i++) {
            String toadd = String.valueOf(i);
            if (i % 3 == 0) {
                toadd = out[0];
                if (i % 5 == 0) {
                    toadd = out[0] + out[1];
                }
            }
            toadd = i % 5 == 0 ? out[1] : toadd;
            res.add(toadd);
        }
        return res;
    }

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        return nums;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.right = left;
        root.left = right;
        return root;
    }

    public static int numberOfSteps(int num) {
        if (num == 0) return 0;
        return num % 2 == 0 ? numberOfSteps(num / 2) + 1 : numberOfSteps(num - 1) + 1;
    }

    public ListNode my_shit_code(ListNode head) {
        int length = 1;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            length++;
        }
        int middle = length / 2;
        node = head;
        for (int i = 0; i < middle; i++) {
            node = node.next;
        }
        return node;
    }

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        boolean slowMoves = false;
        while (fast.next != null) {
            fast = fast.next;
            if (slowMoves) {
                slow = slow.next;
            }
            slowMoves = !slowMoves;
        }

        return slowMoves ? slow.next : slow;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;
        int[][] ran_dic = new int[26][1];
        int[][] mag_dic = new int[26][1];
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = ransomNote.charAt(i);
            ran_dic[index - 97][0]++;
            index = magazine.charAt(i);
            mag_dic[index - 97][0]++;
        }
        for (int i = ransomNote.length(); i < magazine.length(); i++) {
            int index = magazine.charAt(i);
            mag_dic[index - 97][0]++;
        }
        for (int i = 0; i < 26; i++) {
            if (mag_dic[i][0] < ran_dic[i][0]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "a";
        int ch = str.charAt(0);
        System.out.println(ch);
    }
}
