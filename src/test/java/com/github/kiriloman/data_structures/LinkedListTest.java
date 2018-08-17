package com.github.kiriloman.data_structures;

import org.junit.*;

public class LinkedListTest {
    private LinkedList<Integer> array;

    @Before
    public void setUp() {
        this.array = new LinkedList<>();
    }

    @After
    public void tearDown() {

    }

    @Test(expected = NullPointerException.class)
    public void whenAddingNullShouldReturnException() {
        array.add((Integer) null);
    }

    @Test
    public void whenValueIsAddedToLinkedListItsLengthIncrements() {
        array.add(1);
        Assert.assertEquals(1, array.length);
    }

    @Test
    public void whenGettingValueLinkedListShouldReturnValueAtIndex() {
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
    public void whenGettingValueWithNegativeIndexLinkedListShouldReturnException() {
        array.add(1);
        array.get(-1);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenGettingValueWithIndexLargerOrEqualToLengthLinkedListShouldReturnException() {
        array.add(1);
        array.add(2);
        array.add(3);
        array.get(3);
    }

    @Test
    public void whenUsingToStringOnEmptyLinkedListItReturnsEmpty() {
        Assert.assertEquals("{}", array.toString());
    }

    @Test
    public void whenUsingToStringOnNonEmptyLinkedListItReturnsItsContent() {
        array.add(1);
        array.add(2);
        array.add(3);
        Assert.assertEquals("{1, 2, 3}", array.toString());
    }

    @Test
    public void whenDestroyingLinkedListItsLengthShouldBeZeroAndShouldHaveNoContent() {
        array.add(1);
        array.destroy();
        Assert.assertEquals(0, array.length);
        Assert.assertEquals("{}", array.toString());
    }

    @Test
    public void whenLinkedListIsDestroyedItShouldBeEmpty() {
        array.destroy();
        Assert.assertTrue(array.isEmpty());
    }

    @Test
    public void whenLinkedListIsInitializedItShouldBeEmpty() {
        Assert.assertTrue(array.isEmpty());
    }

    @Test
    public void whenLinkedListHasElementsItShouldNotBeEmpty() {
        array.add(1);
        Assert.assertFalse(array.isEmpty());
    }

    @Test
    public void whenLinkedListIsEmptyLengthIsZero() {
        Assert.assertTrue(array.length == 0);
    }

    @Test
    public void whenLinkedListIsNotEmptyLengthIsNotZero() {
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
    public void whenRemovingFirstFromAnEmptyLinkedListReturnException() {
        array.removeFirst();
    }

    @Test
    public void whenRemovingFirstFromNonEmptyLinkedListReturnLinkedListWithoutFirst() {
        array.add(1);
        array.removeFirst();
        Assert.assertEquals("{}", array.toString());

        array.add(1);
        array.add(2);
        array.removeFirst();
        Assert.assertEquals("{2}", array.toString());
    }

    @Test
    public void whenRemovingFirstFromNonEmptyLinkedListLengthDecrements() {
        array.add(1);
        array.add(2);
        int l = array.length;
        array.removeFirst();
        Assert.assertEquals(l - 1, array.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenRemovingLastFromAnEmptyLinkedListReturnException() {
        array.removeLast();
    }

    @Test
    public void whenRemovingLastFromNonEmptyLinkedListReturnLinkedListWithoutLast() {
        array.add(1);
        array.removeLast();
        Assert.assertEquals("{}", array.toString());

        array.add(1);
        array.add(2);
        array.removeLast();
        Assert.assertEquals("{1}", array.toString());
    }

    @Test
    public void whenRemovingLastFromNonEmptyLinkedListLengthDecrements() {
        array.add(1);
        array.add(2);
        array.add(3);
        int l = array.length;
        array.removeLast();
        Assert.assertEquals(l - 1, array.length);
    }

    @Test(expected = NullPointerException.class)
    public void whenAddingNullLinkedListThrowException() {
        array.add((LinkedList) null);
    }

    @Test
    public void whenAddingEmptyLinkedListReturnOriginalLinkedList() {
        LinkedList<Integer> emptyLinkedList = new LinkedList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(emptyLinkedList);
        Assert.assertEquals("{1, 2, 3}", array.toString());
    }

    @Test
    public void whenAddingLinkedListLengthOfOriginalIncrementsExactlyTheLengthOfAddedLinkedList() {
        LinkedList<Integer> other = new LinkedList<>();
        other.add(2);
        other.add(6);

        array.add(1);
        array.add(3);
        array.add(2);
        array.add(other);
        Assert.assertEquals(5, array.length);
    }

    @Test
    public void whenAddingNonEmptyLinkedListToAnEmptyLinkedListReturnTheAddedLinkedList() {
        LinkedList<Integer> other = new LinkedList<>();
        other.add(1);
        other.add(2);
        array.add(other);
        Assert.assertEquals("{1, 2}", array.toString());
    }

    @Test
    public void whenAddingTwoNonEmptyLinkedListsReturnTheirUnion() {
        LinkedList<Integer> other = new LinkedList<>();
        other.add(1);
        other.add(2);
        array.add(5);
        array.add(6);
        array.add(other);
        Assert.assertEquals("{5, 6, 1, 2}", array.toString());
    }
}