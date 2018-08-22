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
        map.put(2, "Hello!");
    }

    @Test
    public void whenPuttingElementsTheyShouldBeSuccessfullyPut() {
        map.put(1, "Why are you looking at these tests?");
        Assert.assertEquals(2, map.size());
    }

    @Test
    public void whenPuttingANewValueToAnExistentKeyUpdateIt() {
        map.put(2, "New String for you!");
        Assert.assertEquals("New String for you!", map.get(2));
    }

    @Test
    public void whenPuttingANewValueToAnExistentKeyDoNotIncrementSize() {
        map.put(2, "Another one");
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void whenPuttingNewElementsSizeShouldIncrement() {
        map.put(1, "Do something else.");
        Assert.assertEquals(2, map.size());
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

    @Test
    public void whenQueryingAnExistentKeyReturnTrue() {
        map.put(1, "You are putting yourself into it!");
        Assert.assertEquals(true, map.containsKey(1));
    }

    @Test
    public void whenQueryingNonExistentKeyReturnFalse() {
        Assert.assertEquals(false, map.containsKey(1));
    }

    @Test
    public void whenQueryingAnExistentValueReturnTrue() {
        map.put(1, "I like it.");
        Assert.assertEquals(true, map.containsValue("I like it."));
    }

    @Test
    public void whenQueryingNonExistentValueReturnFalse() {
        Assert.assertEquals(false, map.containsValue("A few more to go."));
    }

    @Test
    public void whenRemovingAnExistentKeyRemoveItSuccessfully() {
        map.remove(2);
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void whenRemovingNonExistentKeyDoNothing() {
        map.remove(0);
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void whenRemovingAnExistentKeyAndValueRemoveSuccessfully() {
        map.remove(2, "Hello!");
        Assert.assertEquals(0, map.size());
    }

    @Test
    public void whenRemovingAnExistentKeyAndNonExistentValueDoNothing() {
        map.remove(2, "I don't exist!");
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void whenRemovingNonExistentKeyAndExistentValueDoNothing() {
        map.remove(1, "Hello!");
        Assert.assertEquals(1, map.size());
    }

    @Test
    public void whenRemovingNonExistentKeyAndNonExistentValueDoNothing() {
        map.remove(1, "I also don't exist btw.");
        Assert.assertEquals(1, map.size());
    }
}