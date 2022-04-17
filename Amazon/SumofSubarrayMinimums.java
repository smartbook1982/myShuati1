class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nextS = new int[arr.length];
        int[] prevS = new int[arr.length];
        
        Arrays.fill(prevS, -1);
        Arrays.fill(nextS, arr.length);
        
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                nextS[stack.peek()] = i;
                stack.pop();
            }
            stack.push (i);
        }
        
        while (!stack.isEmpty()) stack.pop();
        
        
        for (int i=arr.length-1; i>=0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                prevS[stack.peek()] = i;
                stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) stack.pop();
        
        double count = 0;
        double m = 1e9 + 7;
        for (int i=0; i<arr.length; i++) {
            
            int numLeft = i-prevS[i];
            int numRight = nextS[i]-i;
            count += numLeft * numRight * arr[i];
        }
        
        return count;
        
        
        
    }
}

