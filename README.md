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


#2 

```java

```


#2 

```java

```


#2 

```java

```

