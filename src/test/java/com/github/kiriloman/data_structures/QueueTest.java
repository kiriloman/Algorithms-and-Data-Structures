package com.github.kiriloman.data_structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<Integer> unlimitedQueue;
    private Queue<Integer> limitedQueue;

    @Before
    public void setUp() {
        unlimitedQueue = new Queue<>();
        limitedQueue = new Queue<>(2);
    }

    @Test
    public void whenAddingAnElementToAnUnlimitedQueueItShouldBeAdded() {
        unlimitedQueue.add(1);
        Assert.assertEquals("{1}", unlimitedQueue.toString());
    }

    @Test
    public void whenAddingAnElementToALimitedQueueWithSpaceItShouldBeAdded() {
        limitedQueue.add(1);
        Assert.assertEquals("{1}", limitedQueue.toString());
    }

    @Test(expected = IllegalStateException.class)
    public void whenAddingAnElementToAFullLimitedQueueExceptionIsThrown() {
        limitedQueue.add(1);
        limitedQueue.add(2);
        limitedQueue.add(3);
    }

    @Test
    public void whenOfferingAnElementToAnUnlimitedQueueItShouldBeAdded() {
        unlimitedQueue.offer(1);
        Assert.assertEquals("{1}", unlimitedQueue.toString());
    }

    @Test
    public void whenOfferingAnElementToALimitedQueueWithSpaceItShouldBeAdded() {
        limitedQueue.offer(1);
        Assert.assertEquals("{1}", limitedQueue.toString());
    }

    @Test
    public void whenOfferingAnElementToAFullLimitedQueueReturnFalse() {
        limitedQueue.offer(1);
        limitedQueue.offer(2);
        Assert.assertEquals(false, limitedQueue.offer(3));
    }

    @Test
    public void whenRemovingTheHeadFromUnlimitedQueueItShouldBeRemoved() {
        unlimitedQueue.add(1);
        unlimitedQueue.remove();
        Assert.assertEquals("{}", unlimitedQueue.toString());
    }

    @Test
    public void whenRemovingTheHeadFromLimitedQueueItShouldBeRemoved() {
        limitedQueue.add(1);
        limitedQueue.remove();
        Assert.assertEquals("{}", limitedQueue.toString());
    }

    @Test
    public void whenRemovingTheHeadFromUnlimitedQueueItShouldBeReturned() {
        unlimitedQueue.add(1);
        Assert.assertEquals(Integer.valueOf(1), unlimitedQueue.remove());
    }

    @Test
    public void whenRemovingTheHeadFromLimitedQueueItShouldBeReturned() {
        limitedQueue.add(1);
        Assert.assertEquals(Integer.valueOf(1), limitedQueue.remove());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenRemovingTheHeadFromAnEmptyQueueThrowException() {
        unlimitedQueue.remove();
    }

    @Test
    public void whenPollingTheHeadFromUnlimitedQueueItShouldBeRemoved() {
        unlimitedQueue.add(1);
        unlimitedQueue.poll();
        Assert.assertEquals("{}", unlimitedQueue.toString());
    }

    @Test
    public void whenPollingTheHeadFromLimitedQueueItShouldBeRemoved() {
        limitedQueue.add(1);
        limitedQueue.poll();
        Assert.assertEquals("{}", limitedQueue.toString());
    }

    @Test
    public void whenPollingTheHeadFromUnlimitedQueueItShouldBeReturned() {
        unlimitedQueue.add(1);
        Assert.assertEquals(Integer.valueOf(1), unlimitedQueue.poll());
    }

    @Test
    public void whenPollingTheHeadFromLimitedQueueItShouldBeReturned() {
        limitedQueue.add(1);
        Assert.assertEquals(Integer.valueOf(1), limitedQueue.poll());
    }

    @Test
    public void whenPollingTheHeadFromAnEmptyQueueThrowException() {
        unlimitedQueue.poll();
    }
}