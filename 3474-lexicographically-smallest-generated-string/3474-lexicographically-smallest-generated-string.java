class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int len = n + m - 1;

        char[] word = new char[len];
        boolean[] locked = new boolean[len];

        // Step 1: initialize with '?'
        for (int i = 0; i < len; i++) {
            word[i] = '?';
        }

        // Step 2: Apply 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (word[i + j] == '?' || word[i + j] == str2.charAt(j)) {
                        word[i + j] = str2.charAt(j);
                        locked[i + j] = true; // mark as fixed
                    } else {
                        return ""; // conflict
                    }
                }
            }
        }

        // Step 3: Fill remaining '?' with 'a'
        for (int i = 0; i < len; i++) {
            if (word[i] == '?') {
                word[i] = 'a';
            }
        }

        // Step 4: Handle 'F' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;

                // check if substring equals str2
                for (int j = 0; j < m; j++) {
                    if (word[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                // if equal → need to break it
                if (match) {
                    boolean changed = false;

                    // try modifying from rightmost (for lexicographically smallest)
                    for (int j = m - 1; j >= 0; j--) {
                        if (!locked[i + j]) { // only modify if not locked
                            for (char c = 'a'; c <= 'z'; c++) {
                                if (c != str2.charAt(j)) {
                                    word[i + j] = c;
                                    changed = true;
                                    break;
                                }
                            }
                        }
                        if (changed) break;
                    }

                    // if no modification possible → impossible
                    if (!changed) return "";
                }
            }
        }

        return new String(word);
    }
}