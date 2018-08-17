package com.github.kiriloman.data_structures;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.EmptyStackException;

public class StackTest {

    private Stack<Integer> emptyStack;
    private Stack<Integer> nonEmptyStack;

    @Before
    public void setUp() {
        emptyStack = new Stack<>();
        nonEmptyStack = new Stack<>();
        nonEmptyStack.push(1);
        nonEmptyStack.push(2);
        nonEmptyStack.push(3);
    }

    @Test
    public void whenStackIsEmptyReturnEmpty() {
        Assert.assertEquals(true, emptyStack.empty());
    }

    @Test
    public void whenStackIsNonEmptyReturnNonEmpty() {
        Assert.assertEquals(false, nonEmptyStack.empty());
    }

    @Test(expected = EmptyStackException.class)
    public void whenPeekingAtEmptyStackThrowEmptyStackException() {
        emptyStack.peek();
    }

    @Test
    public void whenPeekingAtNonEmptyStackReturnElementOnTop() {
        Assert.assertEquals(Integer.valueOf(3), nonEmptyStack.peek());
    }

    @Test
    public void whenPeekingAtNonEmptyStackDoNotRemoveTheElementOnTop() {
        nonEmptyStack.peek();
        Assert.assertEquals("{1, 2, 3}", nonEmptyStack.toString());
    }

    @Test(expected = EmptyStackException.class)
    public void whenPoppingAnEmptyStackThrowEmptyStackException() {
        emptyStack.pop();
    }

    @Test
    public void whenPoppingANonEmptyStackReturnTheTopElement() {
        Assert.assertEquals(Integer.valueOf(3), nonEmptyStack.pop());
    }

    @Test
    public void whenPoppingANonEmptyStackRemoveTheTopElement() {
        nonEmptyStack.pop();
        Assert.assertEquals("{1, 2}", nonEmptyStack.toString());
    }

    @Test
    public void whenPushingAnElementToAnEmptyStackItShouldBeOnTop() {
        emptyStack.push(1);
        Assert.assertEquals("{1}", emptyStack.toString());
    }

    @Test
    public void whenPushingAnElementToANonEmptyStackItShouldBeOnTop() {
        nonEmptyStack.push(1);
        Assert.assertEquals("{1, 2, 3, 1}", nonEmptyStack.toString());
    }

    @Test
    public void whenPushingAnElementToAStackReturnThatElement() {
        Assert.assertEquals(Integer.valueOf(1), emptyStack.push(1));
    }

    @Test
    public void whenSearchingAnEmptyStackReturnMinusOne() {
        Assert.assertEquals(-1, emptyStack.search("search"));
    }

    @Test
    public void whenSearchingANonEmptyStackForAnObjectThatIsNotPresentReturnMinusOne() {
        Assert.assertEquals(-1, nonEmptyStack.search(4));
        Assert.assertEquals(-1, nonEmptyStack.search("string"));
        Assert.assertEquals(-1, nonEmptyStack.search(new Object()));
    }

    @Test
    public void whenSearchingANonEmptyStackForAnObjectThatIsPresentReturnItsPositionRelativeToTop() {
        Assert.assertEquals(3, nonEmptyStack.search(1));
        Assert.assertEquals(2, nonEmptyStack.search(2));
        Assert.assertEquals(1, nonEmptyStack.search(3));
    }
}