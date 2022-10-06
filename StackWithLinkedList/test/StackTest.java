import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.stack.Stack;

/**
 * JUnit test fixture for {@code Stack<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class StackTest {

    /**
     * Invokes the appropriate {@code Stack} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new stack
     * @ensures constructorTest = <>
     */
    protected abstract Stack<String> constructorTest();

    /**
     * Invokes the appropriate {@code Stack} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new stack
     * @ensures constructorRef = <>
     */
    protected abstract Stack<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Stack<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsTest = [entries in args]
     */
    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     *
     * Creates and returns a {@code Stack<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsRef = [entries in args]
     */
    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    @Test
    public void constructorTestBlank() {
        Stack<String> x = this.createFromArgsTest("");
        Stack<String> xExpected = this.createFromArgsTest("");

        assertEquals(xExpected, x);
    }

    @Test
    public void constructorTestWithElements() {
        Stack<String> x = this.createFromArgsTest("red", "orange", "yellow");
        Stack<String> xExpected = this.createFromArgsTest("red", "orange",
                "yellow");

        assertEquals(xExpected, x);
    }

    @Test
    public void pushTestIntoEmpty() {
        Stack<String> x = this.createFromArgsTest("");
        Stack<String> xExpected = this.createFromArgsTest("");

        x.push("red");
        xExpected.push("red");

        assertEquals(xExpected, x);
    }

    @Test
    public void pushTestIntoNonEmpty() {
        Stack<String> x = this.createFromArgsTest("red");
        Stack<String> xExpected = this.createFromArgsTest("red");

        x.push("orange");
        xExpected.push("orange");

        assertEquals(xExpected, x);
    }

    @Test
    public void popTestToEmpty() {
        Stack<String> x = this.createFromArgsTest("red");
        Stack<String> xExpected = this.createFromArgsTest("red");

        String xElement = x.pop();
        String xExpectedElement = xExpected.pop();

        assertEquals(xExpected, x);
        assertEquals(xExpectedElement, xElement);
    }

    @Test
    public void popTestToNonEmpty() {
        Stack<String> x = this.createFromArgsTest("red", "orange");
        Stack<String> xExpected = this.createFromArgsTest("red", "orange");

        String xElement = x.pop();
        String xExpectedElement = xExpected.pop();

        assertEquals(xExpected, x);
        assertEquals(xExpectedElement, xElement);
    }

    @Test
    public void lengthTestEmpty() {
        Stack<String> x = this.createFromArgsTest("");
        Stack<String> xExpected = this.createFromArgsTest("");

        int xLen = x.length();
        int xExpectedLen = xExpected.length();

        assertEquals(xExpected, x);
        assertEquals(xExpectedLen, xLen);
    }

    @Test
    public void lengthTestNonEmpty() {
        Stack<String> x = this.createFromArgsTest("red");
        Stack<String> xExpected = this.createFromArgsTest("red");

        int xLen = x.length();
        int xExpectedLen = xExpected.length();

        assertEquals(xExpected, x);
        assertEquals(xExpectedLen, xLen);
    }

}
