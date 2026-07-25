package com.example.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidParenthesis_20Test {
    ValidParenthesis_20 sol = new ValidParenthesis_20();

    @Test
    void ValidParenthesis1() {
        boolean res = sol.isValid("()[]{}");
        assertThat(res).isTrue();
    }

    @Test
    void ValidParenthesis2() {
        boolean res = sol.isValid("{[]}");
        assertThat(res).isTrue();
    }

    @Test
    void ValidParenthesis3() {
        boolean res = sol.isValid("(]");
        assertThat(res).isFalse();
    }

    @Test
    void ValidParenthesis4() {
        boolean res = sol.isValid("([)]");
        assertThat(res).isFalse();
    }

    void ValidParenthesis5() {
        boolean res = sol.isValid("{[]}");
        assertThat(res).isTrue();
    }
}
