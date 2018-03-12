package com.github.kiriloman.data_structures;

import org.junit.*;

public class ArrayTest {
    private Array<Integer> array;

    @Before
    public void setUp() {
        array = new Array<>();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void whenValueIsAddedToArrayItsLengthIncrements() {
        array.add(1);
        Assert.assertEquals(1, array.length);
    }

    @Test
    public void whenGettingValueArrayShouldReturnValueAtIndex() {
        array.add(1);
        array.add(2);
        array.add(3);
        Assert.assertEquals(Integer.valueOf(2), array.get(1));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGettingValueWithNegativeIndexArrayShouldReturnException() {
        array.add(1);
        array.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGettingValueWithIndexLargerThanLengthArrayShouldReturnException() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.get(5);
    }

    @Test
    public void whenUsingToStringOnEmptyArrayItReturnsEmpty() {
        Assert.assertEquals("{}", array.toString());
    }

    @Test
    public void whenUsingToStringOnNonEmptyArrayItReturnsItsContent() {
        array.add(1);
        array.add(2);
        array.add(3);
        Assert.assertEquals("{1, 2, 3}", array.toString());
    }

    @Test
    public void whenDestroyingArrayItsLengthIsZeroAndHasNoContent() {
        array.destroy();
        Assert.assertEquals(0, array.length);
        Assert.assertEquals("{}", array.toString());
    }

    @Test
    public void whenArrayIsDestroyedItShouldBeEmpty() {
        array.destroy();
        Assert.assertTrue(array.isEmpty());
    }

    @Test
    public void whenArrayHasElementsItShouldNotBeEmpty() {
        array.add(1);
        Assert.assertFalse(array.isEmpty());
    }

    @Test
    public void whenArrayIsEmptyLengthIsZero() {
        Assert.assertTrue(array.length == 0);
    }

    @Test
    public void whenArrayIsNotEmptyLengthIsNotZero() {
        array.add(1);
        Assert.assertFalse(array.length == 0);
    }
}