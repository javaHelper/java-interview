#1 - Find the longest common prefix

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

#2 

```java

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


#2 

```java

```

