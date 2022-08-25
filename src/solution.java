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

    //  24/08/2022
    public int pivotIndex(int[] nums) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            right += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            right -= nums[i];
            if (left == right) {
                return i;
            }
            left += nums[i];
        }
        return -1;
    }

    public boolean isIsomorphic(String s, String t) {
        int[][] pair1 = new int[129][1];
        int[][] pair2 = new int[129][1];
        for (int i = 0; i < s.length(); i++) {
            int chars = s.charAt(i);
            int chart = t.charAt(i);
            if (pair1[chars][0] != 0) {
                if (pair1[chars][0] != chart) return false;
            } else {
                pair1[chars][0] = chart;
            }
            if (pair2[chart][0] != 0) {
                if (pair2[chart][0] != chars) return false;
            } else {
                pair2[chart][0] = chars;
            }
        }
        return true;
    }

    public boolean isSubsequence(String s, String t) {
        int i = 0;
        if (s.isEmpty()) return true;
        int chars = s.charAt(0);
        for (int j = 0; j < t.length(); j++) {
            int chart = t.charAt(j);
            if (chars == chart) {
                i++;
                if (i == s.length()) return true;
                chars = s.charAt(i);
            }
        }
        return false;
    }


    //  25/08/2022
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode merge;
        if (list2.val > list1.val) {
            merge = new ListNode(list1.val, mergeTwoLists(list1.next, list2));
        } else {
            merge = new ListNode(list2.val, mergeTwoLists(list2.next, list1));
        }
        return merge;
    }

    public ListNode reverseList_my(ListNode head) {
        if (head == null) return null;
        List list = new ArrayList();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }
        list.add(head.val);
        ListNode res = new ListNode((int) list.get(0));
        for (int i = 1; i < list.size(); i++) {
            res = new ListNode((int) list.get(i), res);
        }
        return res;
    }

    public ListNode reverseList(ListNode head) {
        // Special case...
        if (head == null || head.next == null) return head;
        // Create a new node to call the function recursively and we get the reverse linked list...
        ListNode res = reverseList(head.next);
        // Set head node as head.next.next...
        head.next.next = head;
        //set head's next to be null...
        head.next = null;
        return res;     // Return the reverse linked list...
    }


    public static void main(String[] args) {
        String str = "a";
        int ch = str.charAt(0);
        System.out.println(ch);
    }
}
