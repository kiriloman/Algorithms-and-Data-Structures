package com.github.kiriloman.data_structures;

import org.junit.*;

public class ArrayTest {
    private Array<Integer> array;

    @Before
    public void setUp() {
        this.array = new Array<>();
    }

    @After
    public void tearDown() {

    }

    @Test(expected = NullPointerException.class)
    public void whenAddingNullShouldReturnException() {
        array.add((Integer) null);
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

    @Test(expected = NullPointerException.class)
    public void whenGettingNullIndexShouldReturnException() {
        array.get(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGettingValueWithNegativeIndexArrayShouldReturnException() {
        array.add(1);
        array.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGettingValueWithIndexLargerOrEqualToLengthArrayShouldReturnException() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.get(3);
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
    public void whenDestroyingArrayItsLengthShouldBeZeroAndShouldHaveNoContent() {
        array.add(1);
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
    public void whenArrayIsInitializedItShouldBeEmpty() {
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

    @Test(expected = NullPointerException.class)
    public void whenRemovingNullIndexShouldReturnException() {
        array.remove(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenRemovingNegativeIndexShouldReturnException() {
        array.remove(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenRemovingIndexLargerOrEqualToLengthReturnException() {
        array.add(3);
        array.remove(1);
    }

    @Test
    public void whenRemovingLegalIndexTheValueIsSuccessfullyRemoved() {
        array.add(1);
        array.remove(0);
        Assert.assertEquals("{}", array.toString());

        array.add(1);
        array.add(2);
        array.add(3);
        array.remove(2);
        Assert.assertEquals("{1, 2}", array.toString());
    }

    @Test
    public void whenRemovingLegalIndexLengthShouldDecrement() {
        array.add(1);
        array.add(1);
        array.add(1);
        int l = array.length;
        array.remove(2);
        Assert.assertEquals(l - 1, array.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenRemovingFirstFromAnEmptyArrayReturnException() {
        array.removeFirst();
    }

    @Test
    public void whenRemovingFirstFromNonEmptyArrayReturnArrayWithoutFirst() {
        array.add(1);
        array.removeFirst();
        Assert.assertEquals("{}", array.toString());

        array.add(1);
        array.add(2);
        array.removeFirst();
        Assert.assertEquals("{2}", array.toString());
    }

    @Test
    public void whenRemovingFirstFromNonEmptyArrayLengthDecrements() {
        array.add(1);
        array.add(2);
        int l = array.length;
        array.removeFirst();
        Assert.assertEquals(l - 1, array.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenRemovingLastFromAnEmptyArrayReturnException() {
        array.removeLast();
    }

    @Test
    public void whenRemovingLastFromNonEmptyArrayReturnArrayWithoutLast() {
        array.add(1);
        array.removeLast();
        Assert.assertEquals("{}", array.toString());

        array.add(1);
        array.add(2);
        array.removeLast();
        Assert.assertEquals("{1}", array.toString());
    }

    @Test
    public void whenRemovingLastFromNonEmptyArrayLengthDecrements() {
        array.add(1);
        array.add(2);
        array.add(3);
        int l = array.length;
        array.removeLast();
        Assert.assertEquals(l - 1, array.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenAddingNullArrayThrowException() {
        array.add((Array) null);
    }

    @Test
    public void whenAddingEmptyArrayReturnOriginalArray() {
        Array<Integer> emptyArray = new Array<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(emptyArray);
        Assert.assertEquals("{1, 2, 3}", array.toString());
    }

    @Test
    public void whenAddingArrayLengthOfOriginalIncrementsExactlyTheLengthOfAddedArray() {
        Array<Integer> other = new Array<>();
        other.add(2);
        other.add(6);

        array.add(1);
        array.add(3);
        array.add(2);
        array.add(other);
        Assert.assertEquals(5, array.length);
    }

    @Test
    public void whenAddingNonEmptyArrayToAnEmptyArrayReturnTheAddedArray() {
        Array<Integer> other = new Array<>();
        other.add(1);
        other.add(2);
        array.add(other);
        Assert.assertEquals("{1, 2}", array.toString());
    }

    @Test
    public void whenAddingTwoNonEmptyArraysReturnTheirUnion() {
        Array<Integer> other = new Array<>();
        other.add(1);
        other.add(2);
        array.add(5);
        array.add(6);
        array.add(other);
        Assert.assertEquals("{5, 6, 1, 2}", array.toString());
    }
}