/*
Determine whether an integer is a palindrome. An integer is 
a palindrome when it reads the same backward as forward.
*/
class Solution {
    public boolean isPalindrome(int x) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        if(x >= 0) {
            while(x > 0) {
                stack.push(x % 10);
                x = x / 10;
            }
        }
        else
           return false;
    
        int j = stack.size() - 1;
        int i = 0;
        while(i < j) {
            int start = stack.get(i);
            int end = stack.get(j);

            if(start == end) {
                j--;
                i++;
                continue;
            }
            else {
                return false;
            }  
        }
        return true;
    }
}