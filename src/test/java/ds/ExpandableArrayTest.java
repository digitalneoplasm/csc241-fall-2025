package ds;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class ExpandableArrayTest {

    @Test
    public void testAdd() {
        // Start with some initial configuration.
        ExpandableArray<Integer> ea = new ExpandableArray<>();
        // Check that the initial condition is what we think.
        assertEquals(0, ea.size());
        // Perform the operation we are testing.
        ea.add(1);
        // Check to make sure it worked.
        assertEquals(1, ea.size());
        assertEquals(1, ea.getFirst().intValue());
    }

    @Test
    public void testAddOutOfBounds() {
        // Intiial configuration.
        ExpandableArray<Integer> ea = new ExpandableArray<>();
        // Check that the initial condition is what we think.
        assertEquals(0, ea.size());
        // Test add at index 1.
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> ea.add(1, 100));
        // Check post-conditions.
        assertEquals(0, ea.size());
    }

    @Test
    public void testGrow() {
        // Initial configuration. Add two items, which is max size before grow.
        ExpandableArray<String> ea = new ExpandableArray<>();
        ea.add("a");
        ea.add("b");
        // Check initial configuration.
        assertEquals(2, ea.size());
        assertEquals("a", ea.get(0));
        assertEquals("b", ea.get(1));
        // Perform the operation we are testing.
        ea.add("c"); // Should cause grow to happen.
        // Check final state
        assertEquals(3, ea.size());
        assertEquals("a", ea.get(0));
        assertEquals("b", ea.get(1));
        assertEquals("c", ea.get(2));
    }
}
