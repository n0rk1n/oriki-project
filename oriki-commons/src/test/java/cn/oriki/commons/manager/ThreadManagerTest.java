package cn.oriki.commons.manager;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadManagerTest {

    private ThreadManager threadManager = ThreadManager.getInstance();

    @Test
    public void submit() throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(() -> 1 + 1);
        threadManager.submit(futureTask);

        Integer integer = futureTask.get();
        Assert.assertEquals(Integer.valueOf(2), integer);
    }

}