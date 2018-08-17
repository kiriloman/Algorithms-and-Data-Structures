package com.github.kiriloman.data_structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    private Queue<Integer> unlimitedQueue;
    private Queue<Integer> limitedQueue;

    @Before
    public void setUp() throws Exception {
        unlimitedQueue = new Queue<>();
        limitedQueue = new Queue<>(2);
    }
}