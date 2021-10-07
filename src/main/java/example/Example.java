package example;

import java.util.*;

public class Example {
    public int ladderLength(String initial, String destination, List<String> dictionary) {
        if(dictionary.stream().noneMatch(w -> w.equals(destination))) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(initial);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            while (size > 0) {
                String word = queue.remove();
                size--;
                for(int i = 0; i < word.length(); i++) {
                    char[] wordChars = word.toCharArray();
                    for(char c = 'a'; c<='z'; c++) {
                        wordChars[i] = c;
                        String tmpWord = String.valueOf(wordChars);
                        if(word.equals(tmpWord)) {
                            continue;
                        }
                        if(tmpWord.equals(destination)) {
                            return level + 1;
                        }
                        if(dictionary.stream().anyMatch(w -> w.equals(tmpWord))){
                            queue.add(tmpWord);
                            dictionary.remove(tmpWord);
                        }
                    }
                }
            }
        }
        return 0;
    }

    public int treatsDistribution(int[] treats) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.stream(treats)
                .forEach(t -> map.put(t, map.getOrDefault(t, 0) + 1));
        int multiple = 0;
        int single = 0;
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if(set.getValue() > 1){
                multiple++;
            }else{
                single++;
            }
        }
        return (int) (multiple + Math.floor(single/2));
    }

    public int kSmallestNumber(int[] stream, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        if(stream.length < k) {
            return -1;
        }
        for(int number: stream) {
            if(queue.size() < k){
                queue.add(number);
            } else if(number < queue.peek()){
                queue.poll();
                queue.add(number);
            }
        }
        return queue.peek();
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] arr = new int[amount + 1];
        Arrays.fill(arr, amount + 1);
        arr[0] = 0;
        for(int i = 0 ; i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    arr[i] = Math.min(arr[i], 1 + arr[i - coins[j]]);
                } else {
                    break;
                }
            }
        }
        return arr[amount] > amount ? -1 : arr[amount];
    }

    public String reverseString(String text) {
        int j = text.length() - 1;
        char[] aux = text.toCharArray();
        for(int i = 0 ; i < text.length() / 2 ; i ++) {
            char c = aux[i];
            aux[i] = aux[j];
            aux[j] = c;
            j--;
        }
        return String.valueOf(aux);
    }

    public int reverseInteger(int val) {
        boolean isNegative = val < 0;
        if(isNegative) {
            val = val * -1;
        }
        int reverse = 0;
        while(val >= 1) {
            int last = val % 10;
            reverse = reverse * 10 + last;
            val = val / 10;
        }
        return isNegative ? reverse * -1 : reverse;
    }

    public int findBottomLeftValue(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            node = queue.poll();
            if(node.right != null) {
                queue.offer(node.right);
            }
            if(node.left != null) {
                queue.offer(node.left);
            }
        }
        return node.val;
    }

    public String zigzagTraversal(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        current.push(root);
        boolean left2right = true;
        while (!current.isEmpty()) {
            TreeNode temp = current.pop();
            if(temp != null) {
                sb.append(temp.val);
                if(left2right) {
                    if(temp.left != null) {
                        next.push(temp.left);
                    }
                    if(temp.right != null) {
                        next.push(temp.right);
                    }
                } else {
                    if(temp.right != null) {
                        next.push(temp.right);
                    }
                    if(temp.left != null) {
                        next.push(temp.left);
                    }
                }
            }
            if(current.isEmpty()) {
                left2right = !left2right;
                Object c = next.clone();
                current = (Stack<TreeNode>) c;
                next.clear();
            }
        }
        return sb.toString();
    }

    public int[] sortedTwoSum(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                return new int[]{l, r};
            } else if (sum > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }


    private int[] memo = new int[1001];
    public int fibonacciMemoized(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (memo[n] == 0){
            memo[n] = fibonacciMemoized(n - 1) + fibonacciMemoized(n - 2);
        }
        return memo[n];
    }

    public int fibonacciNative(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacciNative(n - 1) + fibonacciNative(n - 2);
        }
    }
}
