class Solution {

    public boolean isPalindrome(String s) {
        return check(s, 0, s.length() - 1);
    }

    private boolean check(String s, int left, int right) {

        // Move left pointer past non-alphanumeric characters
        while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
            left++;
        }

        // Move right pointer past non-alphanumeric characters
        while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
            right--;
        }

        // Base condition
        if (left >= right) {
            return true;
        }

        // Compare characters ignoring case
        if (Character.toLowerCase(s.charAt(left)) != 
            Character.toLowerCase(s.charAt(right))) {
            return false;
        }

        // Recursive call
        return check(s, left + 1, right - 1);
    }
}