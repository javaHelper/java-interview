# 1 - Find the longest common prefix

```java
public class FindLogestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        // take the first word
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "float"};
        System.out.println(longestCommonPrefix(strs));
    }
}
```

# 2. String Palindrome

```java
public class PalindromeString {

    // for Palindrome always compare left & right
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("madam"));
    }
}

```


# 3. Palindrome Number

```java
public class PalindromeNumber {
    public static boolean isPalindrome(int num) {
        int reverseNum = 0;
        while (num != 0) {
            int lastDigit = reverseNum % 10;
            reverseNum = (reverseNum * 10) + lastDigit;
            num = num / 10;
        }
        return num == reverseNum;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
```


#  4. String Reduce

```java
public class StringReduce {
    public static int stringReduce(String str) {
        StringBuilder res = new StringBuilder();
        for (char ch : str.toCharArray()) {
            // check if any char added
            int len = res.length();
            if (len > 1) {
                char top = res.charAt(len - 1);
                if ((top == '1' && ch == '0') || (top == '0' && ch == '1')) {
                    res.deleteCharAt(res.length() - 1);
                    continue;
                }
            }
            res.append(ch);
        }
        return res.length();
    }

    public static void main(String[] args) { 
        System.out.println(stringReduce("100111"));  // 2
        System.out.println(stringReduce("000*111"));  //7 
    }
}
```


# 5.  Find Vowel Pairs

```java
public class FindVowelPairs {
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static List<String> getVowelPairs(String str) {
        List<String> pairs = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            if (isVowel(str.charAt(i)) && isVowel(str.charAt(i + 1))) {
                pairs.add("" + str.charAt(i) + str.charAt(i + 1));
            }
        }
        return pairs;
    }

    public static void main(String[] args) {
        System.out.println(getVowelPairs("abaebio"));
    }
}
```


# 6 Remove Duplicate Elements 

```java
public class RemoveAllDupElements {
    private static int removeDupElement(int[] numbers) {
        int res = 0;
        for (int num: numbers){
            res = res ^ num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(removeDupElement(new int[]{1, 2, 3, 1, 2}));
    }
}
```

