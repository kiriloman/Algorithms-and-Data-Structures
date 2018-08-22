package com.github.kiriloman.data_structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {
    private HashMap<Integer, String> map;

    @Before
    public void setUp() {
        map = new HashMap<>();
    }

    @Test
    public void whenPuttingElementsTheyShouldBeSuccessfullyPut() {
        map.put(1, "Why are you looking at these tests?");
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void whenGettingAnExistentKeyFromMapItShouldReturnTheValue() {
        map.put(1, "Still looking at this?");
        Assert.assertEquals("Still looking at this?", map.get(1));
    }

    @Test
    public void whenGettingNonExistentKeyFromMapItShouldReturnNull() {
        Assert.assertEquals(null, map.get(0));
    }
}