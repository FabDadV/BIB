package com.udacity.gradle.builditbigger;

import org.junit.Test;
import com.udacity.gradle.builditbigger.javalib.Joker;

public class JokerTest {
    @Test
    public void testJoker() {
        String s = new Joker().getJoke();
        assert s.length()>3;
    }
}
