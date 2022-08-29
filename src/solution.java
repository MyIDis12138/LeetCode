import java.util.*;

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

    //    26/08/2022
    public ListNode detectCycle(ListNode head) {
/*        List<Integer> nodes = new ArrayList<Integer>();
        if (head == null || head.next == null || head.next.val == -1) return null;
        while (head.next != null && head.next.val != -1 ) {
            nodes.add(head.val);
            for (int i = 0; i < nodes.size(); i++) {
                if (head.next.val == nodes.get(i)) return head.next;
            }
            head = head.next;
        }
        return null;*/
        // Take a HashSet to store unique values and we are storing address of ListNodes which should be unique if there is no cycle.
        HashSet<ListNode> set = new HashSet<>();
        // Traverse elements of the list through the loop...
        // Insert current node inside the set and move forward.
        while (head != null && set.add(head)) {
            head = head.next;
        }
        // If node already present inside the set, It means we reach that node again then return that node.
        return head;
    }

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) return true;
        }
        return false;
    }

    //  27/08/2022
    public int maxProfit(int[] prices) {
/*        int max = 0;
        int[] maxnext = new int[prices.length];
        maxnext[prices.length - 1] = prices[prices.length - 1];
        for (int i = prices.length - 2; i >= 0; i--) {
            int temp = prices[i];
            if (temp > maxnext[i + 1]) {
                maxnext[i] = temp;
            } else {
                maxnext[i] = maxnext[i + 1];
            }
        }
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = maxnext[i] - prices[i];
            if (diff > max) max = diff;
        }
        return max;*/

        int max = 0;
        int current = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < current) current = prices[i];
            int temp = prices[i] - current;
            if (temp > max) max = temp;
        }
        return max;
    }

    public int longestPalindrome(String s) {
        if (s == "") return 0;
        int[][] index = new int[58][1];
        for (int i = 0; i < s.length(); i++) {
            index[s.charAt(i) - 65][0]++;
        }
        int len = 0;
        boolean is_singal = false;
        for (int i = 0; i < 58; i++) {
            int j = index[i][0];
            if (!is_singal && j % 2 == 1) is_singal = true;
            len += (j / 2) * 2;
        }
        if (is_singal) len += 1;
        return len;
    }

    public boolean isValid(String s) {
        // 40 41 (); 91 93 []; 123, 125{};
        Stack left = new Stack();

        for (int i = 0; i < s.length(); i++) {
            int j = s.charAt(i);
            if (isleft(j)) left.add(j);
            if (isright(j)) {
                if (left.isEmpty()) return false;
                if (!pair((int) left.pop(), j)) return false;
            }
        }
        if (!left.isEmpty()) return false;
        return true;
    }

    private boolean isleft(int c) {
        if (c == 40 || c == 91 || c == 123) return true;
        return false;
    }

    private boolean isright(int c) {
        if (c == 93 || c == 125 || c == 41) return true;
        return false;
    }

    private boolean pair(int left, int right) {
        if (left == 40 && right == 41) return true;
        if (left == right - 2) return true;
        return false;
    }

    //  28/08/2022

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) return list;
        list.add(root.val);
        if (root.children == null) return list;
        for (int i = 0; i < root.children.size(); i++) {
            list.addAll(preorder(root.children.get(i)));
        }
        return list;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        // Create an array list to store the output result...
        List<List<Integer>> output = new ArrayList<>();
        // Base case: If the tree is empty...
        if (root == null) return output;
        // Initialize a queue to store the nodes on the same level & add root in it...
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        // Traverse a loop untill the queue becomes empty...
        while (!q.isEmpty()) {
            // Denotes the number of elements on that level...
            int size = q.size();
            // A temporary list to store all the left and right child for all the node in the level...
            ArrayList<Integer> temp = new ArrayList<>(size);
            for (int idx = 0; idx < size; idx++) {
                // Initialize a treenode as the popped element of the queue & store the value of the new treenode to temp...
                TreeNode node = q.remove();
                temp.add(node.val);
                // Store all the nodes of next level...
                // Add left and right child if they are not None...
                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }
            // Add the temp to output result...
            output.add(temp);
        }
        return output;       // Return the output result...
    }

    //    29/08/2022
    public int search(int[] nums, int target) {
        int f = 0;
        int l = nums.length - 1;
        int i = 0;
        while (l >= f) {
            int medium = (l + f) / 2;
            //System.out.println(f +" "+ medium +  " " + l);
            if (target == nums[medium]) return medium;
            if (target > nums[medium]) {
                f = medium + 1;
            } else {
                l = medium - 1;
            }
        }
        return -1;
    }


    public int firstBadVersion(int n) {
        if (n == 1) return n;
        int start = 1;
        int end = n;
        int mid = start + (end - start) / 2;
        while (start <= end) {
            if (isBadVersion(start)) {
                return start;
            } else if (isBadVersion(mid)) {
                end = mid;
                mid = start + (end - start) / 2;
            } else {
                start = mid + 1;
                mid = start + (end - start) / 2;
            }
        }
        return -1;
    }


    private boolean isBadVersion(int version) {
        return true;
    }


    public int[][] diagonalSort(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        int diff = Math.abs(row - column);
        if (row >= column) {
            int start_r = 0;
            int start_c = 0;
            for (int i = 0; i < diff + 1; i++) {
                int[] sort = new int[column];
                for (int j = 0; j < column; j++) {
                    sort[j] = mat[start_r + j][start_c + j];
                }
                Arrays.sort(sort);
                for (int j = 0; j < column; j++) {
                    mat[start_r + j][start_c + j] = sort[j];
                }
                start_r++;
            }

            //sort the rest
            start_r = diff + 1;
            start_c = 1;
            int size = column - 1;
            for (int i = 0; i < (column - 2); i++) {
                int[] sort = new int[size];
                int row_in = start_r + i;
                int col_in = start_c + i;

                //System.out.println("row: " + start_r + ", Column: " + start_c);
                //System.out.println("Size: " + size);

                for (int j = 0; j < size; j++) {
                    sort[j] = mat[j][col_in + j];
                }
                Arrays.sort(sort);
                for (int j = 0; j < size; j++) {
                    mat[j][col_in + j] = sort[j];
                }


                for (int j = 0; j < size; j++) {
                    sort[j] = mat[j + row_in][j];
                }
                Arrays.sort(sort);
                for (int j = 0; j < size; j++) {
                    mat[row_in + j][j] = sort[j];
                }
                size--;
            }

        } else {
            // column > row
            int start_r = 0;
            int start_c = 0;

            // sort full diagonal
            for (int i = 0; i < diff + 1; i++) {
                int[] sort = new int[row];
                for (int j = 0; j < row; j++) {
                    sort[j] = mat[j][start_c + j];
                }
                Arrays.sort(sort);
                for (int j = 0; j < row; j++) {
                    mat[j][start_c + j] = sort[j];
                }
                start_c++;
            }

            //sort the rest
            start_r = 1;
            start_c = diff + 1;
            int size = row - 1;
            for (int i = 0; i < (row - 2); i++) {
                int[] sort = new int[size];
                int row_in = start_r + i;
                int col_in = start_c + i;

                //System.out.println("row: " + row_in + ", Column: " + col_in);
                //System.out.println("Size: " + size);

                for (int j = 0; j < size; j++) {
                    sort[j] = mat[j][col_in + j];
                }
                Arrays.sort(sort);
                for (int j = 0; j < size; j++) {
                    mat[j][col_in + j] = sort[j];
                }

                for (int j = 0; j < size; j++) {
                    sort[j] = mat[j + row_in][j];
                }
                Arrays.sort(sort);
                for (int j = 0; j < size; j++) {
                    mat[row_in + j][j] = sort[j];
                }
                size--;
            }
        }
        return mat;
    }


    public static void main(String[] args) {
        solution a = new solution();
        String str = "()[]{}";
        System.out.println(a.isValid(str));
    }
}
