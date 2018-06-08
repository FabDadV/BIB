package com.udacity.gradle.builditbigger;

import org.junit.Test;
import static junit.framework.Assert.assertTrue;

public class AsyncTaskTest {
    @Test
    public void testAsyncTask() {
        try {
            MainActivity.EndpointsAsyncTask endpointsAsyncTask = new MainActivity.EndpointsAsyncTask();
            String joke = endpointsAsyncTask.execute(
                    new com.udacity.gradle.builditbigger.andlib.LibraryActivity()).get();
            assertTrue(joke.length()>3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

