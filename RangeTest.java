package org.jfree.data;

import static org.junit.Assert.*; import org.jfree.data.Range; import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    private Range exampleRange2;
    private Range exampleRange3;
    private Range exampleRange4;
    
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    /** 
     * 
     * Start of expandToInclude() Tests
     */
    @Before
    public void setUpExpandRangeTestRightBound() throws Exception { 
    	exampleRange = new Range(-1, 1);
    	exampleRange2 = new Range(-5,-3);
    	exampleRange3 = new Range(2, 7);
        exampleRange4 = new Range(-1, 1);
    }

    @Test
    public void expandRangeTestRightBound() {
    	Range expectedRange = new Range(-1,5);
    	Range actualRange = Range.expandToInclude(exampleRange, 5);
    	
        assertTrue("The range should be from -1 to 5",
        expectedRange.equals(actualRange));
    }
    
    @Test
    public void expandRangeTestLeftBound() {
    	Range expectedRange = new Range(-1,1);
    	Range actualRange = Range.expandToInclude(exampleRange, -5);
    	
        assertTrue("The range should be from -5 to 1",
        expectedRange.equals(actualRange));
    }

    @Test
    public void expandRangeTestInsideBound() {
    	Range expectedRange = new Range(-1,1);
    	Range actualRange = Range.expandToInclude(exampleRange, 0);
    	
        assertTrue("The range should be from -1 to 1",
        expectedRange.equals(actualRange));
    }

    @Test
    public void expandRangeTestLeftEdgeBound() {
    	Range expectedRange = new Range(-2,1);
    	Range actualRange = Range.expandToInclude(exampleRange, -2);
    	
        assertTrue("The range should be from -2 to 1",
        expectedRange.equals(actualRange));
    }

    @Test
    public void expandRangeTestRightEdgeBound() {
    	Range expectedRange = new Range(-1,1);
    	Range actualRange = Range.expandToInclude(exampleRange, 1);
    	
        assertTrue("The range should be from -1 to 1",
        expectedRange.equals(actualRange));
    }
    
    @Test
    public void expandRangeTestNullValuePos() {
    	Range expectedRange = new Range(10,10);
    	Range actualRange = Range.expandToInclude(null, 10);
    	
        assertTrue("The range should be from 10 to 10",
        expectedRange.equals(actualRange));
    }
    
    @Test
    public void expandRangeTestNullValueNeg() {
    	Range expectedRange = new Range(-4,-4);
    	Range actualRange = Range.expandToInclude(null, -4);
    	
        assertTrue("The range should be from -4 to -4",
        expectedRange.equals(actualRange));
    }
    
    @Test
    public void expandRangeTestNullValueZero() {
    	Range expectedRange = new Range(0,0);
    	Range actualRange = Range.expandToInclude(null, 0);
    	
        assertTrue("The range should be from 0 to 0",
        expectedRange.equals(actualRange));
    }
    /**
     * 
     * End of expandRange() Tests
     */

    
    /**
     * 
     * Start of contains() Tests
     */

    @Test
    public void containsTestValueInside() {
    	assertTrue("The function stated that 0 is not in the range (-1, 1) when it actually is.", exampleRange.contains(0));

    }

    @Test
    public void containsTestValueAbove() {
    	assertFalse("The function stated that 2 is in the range (-1, 1) when it actually is not.", exampleRange.contains(2));

    }

    @Test
    public void containsTestValueBelow() {
    	assertFalse("The function stated that -3 is in the range (-1, 1) when it actually is not.", exampleRange.contains(-3));

    }

    @Test
    public void containsTestValueLeftEdge() {
    	assertTrue("The function stated that -1 is not in the range (-1, 1) when it actually is.", exampleRange.contains(-1));

    }

    @Test
    public void containsTestValueRightEdge() {
    	assertTrue("The function stated that 1 is not in the range (-1, 1) when it actually is.", exampleRange.contains(1));

    }

    @Test
    public void containsTestNegativeRange() {
    	assertTrue("The function stated that -4 is not in the range (-5, -3) when it actually is.", exampleRange2.contains(-4));

    }
    
    @Test
    public void containsTestPositiveRange() {
    	assertTrue("The function stated that 5 is not in the range (2, 7) when it actually is.", exampleRange3.contains(5));

    }
    
    /**
     * 
     * End of contains() Tests
     */

        // TESTING COMBINE METHOD -----------------------------------------------------
    @Test // Javier
    public void combineTwoNullRanges() {
    	assertEquals("The range should be null", null, Range.combine(null, null));
    }
    
    @Test // Dimitar
    public void combineOneNullRange() {
    	Range testRange = new Range(-10,20);
    	assertEquals("The range should be the same as the test range", testRange, Range.combine(testRange, null));
    }
    
    @Test 
    public void combineValidIntersectingRange() {
    	Range expectedRange = new Range(0, 20);
    	Range actualRange = Range.combine(new Range(0, 10), new Range(0,20));
    	assertTrue("Expected Range should be between 0 and 20", expectedRange.equals(actualRange));
    	
    }
    
    
    @Test (expected = IllegalArgumentException.class)
    public void combineValidNonIntersectingRange() {
    	Range range1 = new Range(0, 5);
    	Range range2 = new Range(10,20);
    	Range combinedRange = Range.combine(range1, range2 );
    	// This line below should never be reached
    	fail("Illegal Argument Exception should be thrown in this test");
    	
    }

    // TESTING CONSTRAIN METHOD ----------------------------------------------------------- 
    @Test
    public void constrainInRangeValue() {
    	assertTrue("Constrain value that exists in range",0.1 == exampleRange4.constrain(0.1));
    }
    
    @Test // Brian
    public void constrainValueBelowLowerBound() {
    	assertEquals("Constrain value that is below the lower bound of range",-1.0,exampleRange4.constrain(-43.2),.000000001d);
    }
    
    @Test
    public void constrainValueAboveUpperBound() {
    	assertEquals("Constrain value that is above the upper bound of range",1.0, exampleRange4.constrain(43.2),.000000001d);
    }
    @Test
    public void constrainValueAtLowerBound() {
    	assertEquals("Constrain value that is below the lower bound of range",-1.0,exampleRange4.constrain(-1.0),.000000001d);
    }
    
    @Test
    public void constrainValueAtUpperBound() {
    	assertEquals("Constrain value that is below the lower bound of range",1.0,exampleRange4.constrain(1.0),.000000001d);
    }
    // TESTING INTERSECTS METHOD ----------------------------------------------------------- 
    @Test
    public void intersectsFullyCoveredRange() {
    	assertTrue("Testing range that is fully covered by example range",exampleRange4.intersects(-0.5, 0.5));
    }
    
    @Test
    public void intersectsPartiallyCoveredRangeWithUpperBoundIncluded() {
    	assertTrue("Testing range that is partially covered by example range with the upper bound included",exampleRange4.intersects(-4.5, 0.5));
    }
    
    @Test
    public void intersectsPartiallyCoveredRangeWithLowerBoundIncluded() {
    	assertTrue("Testing range that is partially covered by example range with the lower bound included",exampleRange4.intersects(-0.5, 8.5));
    }
    
    @Test
    public void intersectsNonCoveredRangeBelowLowerBound() {
    	assertFalse("Testing range that is not covered by example range and is below the lower bound",exampleRange4.intersects(-5.5, -3.5));
    }
    
    @Test
    public void intersectsNonCoveredRangeAboveUpperBound() {
    	assertFalse("Testing range that is not covered by example range and is above the upper bound",exampleRange4.intersects(3.5, 5.5));
    }
    
    @Test
    public void intersectsAtUpperBound() {
    	assertTrue("Testing range that insertects only at upper bound",exampleRange4.intersects(1.0, 2.5));
    }
    
    @Test
    public void intersectsAtLowerBound() {
    	assertTrue("Testing range that insertects only at lower bound",exampleRange4.intersects(-3.5, -1.0));
    }
    
//    @Test 
//    public void intersectsWithSecondValueLessThanFirstValue() {
//    	assertFalse("Testing range that intersects at lowerbound and the second value is ")
//    }
    
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}