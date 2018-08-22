package com.github.kiriloman.data_structures;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    private LinkedList<Integer> list;

    @Before
    public void setUp() {
        this.list = new LinkedList<>();
    }

    @After
    public void tearDown() {

    }

    @Test(expected = NullPointerException.class)
    public void whenAddingNullShouldReturnException() {
        list.add((Integer) null);
    }

    @Test
    public void whenValueIsAddedToLinkedListItsLengthIncrements() {
        list.add(1);
        Assert.assertEquals(1, list.length);
    }

    @Test
    public void whenGettingValueLinkedListShouldReturnValueAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals(Integer.valueOf(2), list.get(1));
    }

    @Test(expected = NullPointerException.class)
    public void whenGettingNullIndexShouldReturnException() {
        list.get(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGettingValueWithNegativeIndexLinkedListShouldReturnException() {
        list.add(1);
        list.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGettingValueWithIndexLargerOrEqualToLengthLinkedListShouldReturnException() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.get(3);
    }

    @Test
    public void whenUsingToStringOnEmptyLinkedListItReturnsEmpty() {
        Assert.assertEquals("{}", list.toString());
    }

    @Test
    public void whenUsingToStringOnNonEmptyLinkedListItReturnsItsContent() {
        list.add(1);
        list.add(2);
        list.add(3);
        Assert.assertEquals("{1, 2, 3}", list.toString());
    }

    @Test
    public void whenDestroyingLinkedListItsLengthShouldBeZeroAndShouldHaveNoContent() {
        list.add(1);
        list.destroy();
        Assert.assertEquals(0, list.length);
        Assert.assertEquals("{}", list.toString());
    }

    @Test
    public void whenLinkedListIsDestroyedItShouldBeEmpty() {
        list.destroy();
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void whenLinkedListIsInitializedItShouldBeEmpty() {
        Assert.assertTrue(list.isEmpty());
    }

    @Test
    public void whenLinkedListHasElementsItShouldNotBeEmpty() {
        list.add(1);
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void whenLinkedListIsEmptyLengthIsZero() {
        Assert.assertTrue(list.length == 0);
    }

    @Test
    public void whenLinkedListIsNotEmptyLengthIsNotZero() {
        list.add(1);
        Assert.assertFalse(list.length == 0);
    }

    @Test(expected = NullPointerException.class)
    public void whenRemovingNullIndexShouldReturnException() {
        list.remove(null);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenRemovingNegativeIndexShouldReturnException() {
        list.remove(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenRemovingIndexLargerOrEqualToLengthReturnException() {
        list.add(3);
        list.remove(1);
    }

    @Test
    public void whenRemovingLegalIndexTheValueIsSuccessfullyRemoved() {
        list.add(1);
        list.remove(0);
        Assert.assertEquals("{}", list.toString());

        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(2);
        Assert.assertEquals("{1, 2}", list.toString());
    }

    @Test
    public void whenRemovingLegalIndexLengthShouldDecrement() {
        list.add(1);
        list.add(1);
        list.add(1);
        int l = list.length;
        list.remove(2);
        Assert.assertEquals(l - 1, list.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenRemovingFirstFromAnEmptyLinkedListReturnException() {
        list.removeFirst();
    }

    @Test
    public void whenRemovingFirstFromNonEmptyLinkedListReturnLinkedListWithoutFirst() {
        list.add(1);
        list.removeFirst();
        Assert.assertEquals("{}", list.toString());

        list.add(1);
        list.add(2);
        list.removeFirst();
        Assert.assertEquals("{2}", list.toString());
    }

    @Test
    public void whenRemovingFirstFromNonEmptyLinkedListLengthDecrements() {
        list.add(1);
        list.add(2);
        int l = list.length;
        list.removeFirst();
        Assert.assertEquals(l - 1, list.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenRemovingLastFromAnEmptyLinkedListReturnException() {
        list.removeLast();
    }

    @Test
    public void whenRemovingLastFromNonEmptyLinkedListReturnLinkedListWithoutLast() {
        list.add(1);
        list.removeLast();
        Assert.assertEquals("{}", list.toString());

        list.add(1);
        list.add(2);
        list.removeLast();
        Assert.assertEquals("{1}", list.toString());
    }

    @Test
    public void whenRemovingLastFromNonEmptyLinkedListLengthDecrements() {
        list.add(1);
        list.add(2);
        list.add(3);
        int l = list.length;
        list.removeLast();
        Assert.assertEquals(l - 1, list.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenAddingNullLinkedListThrowException() {
        list.add((LinkedList) null);
    }

    @Test
    public void whenAddingEmptyLinkedListReturnOriginalLinkedList() {
        LinkedList<Integer> emptyLinkedList = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(emptyLinkedList);
        Assert.assertEquals("{1, 2, 3}", list.toString());
    }

    @Test
    public void whenAddingLinkedListLengthOfOriginalIncrementsExactlyTheLengthOfAddedLinkedList() {
        LinkedList<Integer> other = new LinkedList<>();
        other.add(2);
        other.add(6);

        list.add(1);
        list.add(3);
        list.add(2);
        list.add(other);
        Assert.assertEquals(5, list.length);
    }

    @Test
    public void whenAddingNonEmptyLinkedListToAnEmptyLinkedListReturnTheAddedLinkedList() {
        LinkedList<Integer> other = new LinkedList<>();
        other.add(1);
        other.add(2);
        list.add(other);
        Assert.assertEquals("{1, 2}", list.toString());
    }

    @Test
    public void whenAddingTwoNonEmptyLinkedListsReturnTheirUnion() {
        LinkedList<Integer> other = new LinkedList<>();
        other.add(1);
        other.add(2);
        list.add(5);
        list.add(6);
        list.add(other);
        Assert.assertEquals("{5, 6, 1, 2}", list.toString());
    }

    @Test
    public void whenReversingEmpyLinkedListShouldBeReversed() {
        list.reverse();
        Assert.assertEquals("{}", list.toString());
    }

    @Test
    public void whenReversingNonEmpyLinkedListShouldBeReversed() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.reverse();
        Assert.assertEquals("{4, 3, 2, 1}", list.toString());
    }
}