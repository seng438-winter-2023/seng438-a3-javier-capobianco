package org.jfree.data;

import static org.junit.Assert.*; 
import java.security.InvalidParameterException;
import org.jfree.data.Values2D;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.junit.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import java.util.*;


public class DataUtilitiesTest {
	Mockery mockingContext = new Mockery();
	Mockery mockingContext2 = new Mockery();
	Mockery mockingContext3 = new Mockery();
	Mockery mockingContext5 = new Mockery(); // NUL ARRAY

	final KeyedValues keyValAscendingWO0 = mockingContext.mock(KeyedValues.class);
	final KeyedValues keyValDiscontinuousWO0 = mockingContext2.mock(KeyedValues.class);
	final KeyedValues keyValAscendingW0 = mockingContext3.mock(KeyedValues.class);
	
	final KeyedValues keyValNull = mockingContext5.mock(KeyedValues.class);
	
	Mockery mockingContext4 = new Mockery();
	final Values2D validValues = mockingContext4.mock(Values2D.class);
	final Number[] expected = {1.4,4.5};
	final double[] input = {1.4,4.5};
	double delta;
	
	@Before
	public void setUpCreateNumberArray2DTest() {
		List<Integer> keys = Arrays.asList(0, 1, 2, 3);
		List<Integer> keys2 = Arrays.asList(0, 1, 3, 4);
		
		

		mockingContext.checking(new Expectations() {
			// 0  1  2  3
			// 2  4  6  8
			{
				allowing(keyValAscendingWO0).getItemCount();
				will(returnValue(4));
				
				
				allowing(keyValAscendingWO0).getKeys();
				will(returnValue(keys));
				allowing(keyValAscendingWO0).getKey(0);
				will(returnValue(0));
				allowing(keyValAscendingWO0).getKey(1);
				will(returnValue(1));
				allowing(keyValAscendingWO0).getKey(2);
				will(returnValue(2));
				allowing(keyValAscendingWO0).getKey(3);
				will(returnValue(3));
				
				allowing(keyValAscendingWO0).getValue(0);
				will(returnValue(2));
				allowing(keyValAscendingWO0).getValue(1);
				will(returnValue(4));
				allowing(keyValAscendingWO0).getValue(2);
				will(returnValue(6));
				allowing(keyValAscendingWO0).getValue(3);
				will(returnValue(8));

				
				one(keyValAscendingWO0).getIndex(0);
				will(returnValue(0));
				one(keyValAscendingWO0).getIndex(1);
				will(returnValue(1));
				one(keyValAscendingWO0).getIndex(2);
				will(returnValue(2));
				one(keyValAscendingWO0).getIndex(3);
				will(returnValue(3));
				
				
			}
		});
		
		mockingContext5.checking(new Expectations() {
			// 0  1  2  3
			// null  2  4  6
			{
				allowing(keyValNull).getItemCount();
				will(returnValue(4));
				
				
				allowing(keyValNull).getKeys();
				will(returnValue(keys));
				allowing(keyValNull).getKey(0);
				will(returnValue(0));
				allowing(keyValNull).getKey(1);
				will(returnValue(1));
				allowing(keyValNull).getKey(2);
				will(returnValue(2));
				allowing(keyValNull).getKey(3);
				will(returnValue(3));
				
				allowing(keyValNull).getValue(0);
				will(returnValue(null));
				allowing(keyValNull).getValue(1);
				will(returnValue(2));
				allowing(keyValNull).getValue(2);
				will(returnValue(4));
				allowing(keyValNull).getValue(3);
				will(returnValue(6));

				
				one(keyValNull).getIndex(0);
				will(returnValue(0));
				one(keyValNull).getIndex(1);
				will(returnValue(1));
				one(keyValNull).getIndex(2);
				will(returnValue(2));
				one(keyValNull).getIndex(3);
				will(returnValue(3));
				
				
			}
		});
		
		mockingContext3.checking(new Expectations() {
			// 0  1  2  3
			// 0  2  4  6
			{
				allowing(keyValAscendingW0).getItemCount();
				will(returnValue(4));
				
				
				allowing(keyValAscendingW0).getKeys();
				will(returnValue(keys));
				allowing(keyValAscendingW0).getKey(0);
				will(returnValue(0));
				allowing(keyValAscendingW0).getKey(1);
				will(returnValue(1));
				allowing(keyValAscendingW0).getKey(2);
				will(returnValue(2));
				allowing(keyValAscendingW0).getKey(3);
				will(returnValue(3));
				
				allowing(keyValAscendingW0).getValue(0);
				will(returnValue(0));
				allowing(keyValAscendingW0).getValue(1);
				will(returnValue(2));
				allowing(keyValAscendingW0).getValue(2);
				will(returnValue(4));
				allowing(keyValAscendingW0).getValue(3);
				will(returnValue(6));

				
				one(keyValAscendingW0).getIndex(0);
				will(returnValue(0));
				one(keyValAscendingW0).getIndex(1);
				will(returnValue(1));
				one(keyValAscendingW0).getIndex(2);
				will(returnValue(2));
				one(keyValAscendingW0).getIndex(3);
				will(returnValue(3));
				
				
			}
		});
		
		mockingContext2.checking(new Expectations() {
			// 0  1  3  4
			// 2  6  8  10
			{
				allowing(keyValDiscontinuousWO0).getItemCount();
				will(returnValue(4));
				
				
				allowing(keyValDiscontinuousWO0).getKeys();
				will(returnValue(keys2));
				allowing(keyValDiscontinuousWO0).getKey(0);
				will(returnValue(0));
				allowing(keyValDiscontinuousWO0).getKey(1);
				will(returnValue(1));
				allowing(keyValDiscontinuousWO0).getKey(2);
				will(returnValue(3));
				allowing(keyValDiscontinuousWO0).getKey(3);
				will(returnValue(4));
				
				allowing(keyValDiscontinuousWO0).getValue(0);
				will(returnValue(2));
				allowing(keyValDiscontinuousWO0).getValue(1);
				will(returnValue(4));
				allowing(keyValDiscontinuousWO0).getValue(3);
				will(returnValue(6));
				allowing(keyValDiscontinuousWO0).getValue(4);
				will(returnValue(8));

				
				one(keyValDiscontinuousWO0).getIndex(0);
				will(returnValue(0));
				one(keyValDiscontinuousWO0).getIndex(1);
				will(returnValue(1));
				one(keyValDiscontinuousWO0).getIndex(3);
				will(returnValue(2));
				one(keyValDiscontinuousWO0).getIndex(4);
				will(returnValue(3));
				
				
			}
		});

		delta = .000000001d;
	    mockingContext4.checking(new Expectations() {
	        {
	        	// 7.5   3.5
	        	// 2.5   null
	        	
	            // Valid Values expectations
	            one(validValues).getRowCount();
	            will(returnValue(2));
	            one(validValues).getColumnCount();
	            will(returnValue(2));
	            one(validValues).getValue(0, 0);
	            will(returnValue(7.5));
	            one(validValues).getValue(1, 0);
	            will(returnValue(2.5));
	            one(validValues).getValue(0, 1);
	            will(returnValue(3.5));
	            one(validValues).getValue(1, 1);
	            will(returnValue(null));
	            one(validValues).getValue(0, -1);
	            will(throwException(new IndexOutOfBoundsException()));
	            one(validValues).getValue(1, -1);
	            will(throwException(new IndexOutOfBoundsException()));
	            one(validValues).getValue(0, 10);
	            will(throwException(new IndexOutOfBoundsException()));
	            one(validValues).getValue(1, 10);
	            will(throwException(new IndexOutOfBoundsException()));
	            one(validValues).getValue(-1, 0);
	            will(throwException(new IndexOutOfBoundsException()));
	            one(validValues).getValue(10, 0);
	            will(throwException(new IndexOutOfBoundsException()));
	        }
	    });
	}
	
	// Tests for createNumberArray2D
	@Test
	public void createNumberArray2DTestCorrectDimensions3x3() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		Integer[] expectedDimensions = {3, 3};
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);
		
		
		assertTrue("Providing a 3x3 double array did not return a 3x3 Number object", actualResult.length == expectedDimensions[0] && actualResult[1].length == expectedDimensions[1]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectDimensions3x1() {
		double[] testStringPart1 = {1};
		double[] testStringPart2 = {7.8};
		double[] testStringPart3 = {3.6};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		Integer[] expectedDimensions = {3, 1};
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);
		
		
		assertTrue("Providing a 3x1 double array did not return a 3x1 Number object", actualResult.length == expectedDimensions[0] && actualResult[1].length == expectedDimensions[1]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos00() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 1.0;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);
		
		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [0][0]", expectedResult, actualResult[0][0]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos01() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 2.0;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);

		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [0][1]", expectedResult, actualResult[0][1]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos02() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 3.5;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);

		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [0][2]", expectedResult, actualResult[0][2]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos10() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 7.8;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);

		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [1][0]", expectedResult, actualResult[1][0]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos11() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 2.4;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);

		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [1][1]", expectedResult, actualResult[1][1]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos12() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 3.4;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);

		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [1][2]", expectedResult, actualResult[1][2]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos20() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 3.6;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);
		
		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [2][0]", expectedResult, actualResult[2][0]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues3x3Pos21() {
		double[] testStringPart1 = {1, 2, 3.5};
		double[] testStringPart2 = {7.8, 2.4, 3.4};
		double[] testStringPart3 = {3.6, 7.32, 4.8};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3};
		double expectedResult = 7.32;
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);
		
		assertEquals("Values inside the 3x3 matrix do not equal the expected output at position [2][1]", expectedResult, actualResult[2][1]);
	}
	
	@Test
	public void createNumberArray2DTestCorrectValues4x4() {
		double[] testStringPart1 = {1, 2, 3.5, 6};
		double[] testStringPart2 = {7.8, 2.4, 3.4, 3};
		double[] testStringPart3 = {3.6, 7.32, 4.8, 7};
		double[] testStringPart4 = {4.6, 4, 6.4, 3};
		double[][] testString2D = {testStringPart1, testStringPart2, testStringPart3, testStringPart4};
		Number[][] expectedResult = {{1, 2, 3.5, 6}, {7.8, 2.4, 3.4, 3}, {3.6, 7.32, 4.8, 7}, {4.6, 4, 6.4, 3}};
		
		Number[][] actualResult = DataUtilities.createNumberArray2D(testString2D);

		assertTrue("Values inside the 4x4 matrix do not equal the expected Number matrix", actualResult.equals(expectedResult));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createNumberArray2DTestNullInputValue() {
		DataUtilities.createNumberArray2D(null);

		fail("IllegalArgumentException was not thrown when it should have been");
	}
	
	
	// Tests for getCumulativePercentages
	
	
	@Test(expected = IllegalArgumentException.class)
	public void getCumulativePercentagesTestNullInputValue() {
		DataUtilities.getCumulativePercentages(null);
		fail("IllegalArgumentException was not thrown when it should have been");
	}
	
	@Test //(expected = IllegalArgumentException.class) // Ideen 
	public void getCumulativePercentagesTestNullArray() {
		KeyedValues a = DataUtilities.getCumulativePercentages(keyValNull);
		assertEquals("", new DefaultKeyedValues(), a);
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingWO0Pos1() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingWO0);
		double [] expected = {0.1, 0.2, 0.3, 0.4};
		assertEquals("Did not calculate percentage correctly for first position when 0 is not a value", expected[0], actual.getValue(0));
		
		
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingWO0Pos2() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingWO0);
		double [] expected = {0.1, 0.2, 0.3, 0.4};
		assertEquals("Did not calculate percentage correctly for second position when 0 is not a value", expected[1], actual.getValue(1));
		
		
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingWO0Pos3() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingWO0);
		double [] expected = {0.1, 0.2, 0.3, 0.4};
		assertEquals("Did not calculate percentage correctly for third position when 0 is not a value", expected[2], actual.getValue(2));
		
		
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingWO0Pos4() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingWO0);
		double [] expected = {0.1, 0.2, 0.3, 0.4};
		assertEquals("Did not calculate percentage correctly for last position when 0 is not a value", expected[3], actual.getValue(3));
		
		
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingW0Pos1() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingW0);
		double [] expected = {0, 0.16667, 0.3333, 0.5};
		assertEquals("Did not calculate percentage correctly for first position when 0 is a value", expected[0], actual.getValue(0));
		
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingW0Pos2() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingW0);
		double [] expected = {0, 0.16667, 0.3333, 0.5};
		assertEquals("Did not calculate percentage correctly for second position when 0 is a value", expected[1], actual.getValue(1));
		
		
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingW0Pos3() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingW0);
		double [] expected = {0, 0.16667, 0.3333, 0.5};
		assertEquals("Did not calculate percentage correctly for third position when 0 is a value", expected[2], actual.getValue(2));
		
		
	}
	
	@Test()
	public void getCumulativePercentagesTestAscendingW0Pos4() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValAscendingW0);
		double [] expected = {0, 0.16667, 0.3333, 0.5};
		assertEquals("Did not calculate percentage correctly for last position when 0 is a value", expected[3], actual.getValue(3));
		
		
	}
	
	@Test()
	public void getCumulativePercentagesTestDiscontinuousWO0() {
		KeyedValues actual = DataUtilities.getCumulativePercentages(keyValDiscontinuousWO0);
		double [] expected = {0.1, 0.2, 0.3, 0.4};
		assertEquals("Did not calculate percentage correctly for last position when 0 is a value", expected[3], actual.getValue(3));
	}

	// COLUMN TOTAL TEST ----------------------------------------------------------------
	@Test (expected = InvalidParameterException.class)
	public void calculateColumnTotalWithNullData() {
		// Column 1 is in invalid data column
		DataUtilities.calculateColumnTotal(validValues, 1);
	}
	
	@Test 
	public void calculateColumnTotalWithValidDataAndValidColumn() {
		// using 0 as a column since mock data only has one Column
		double actual = DataUtilities.calculateColumnTotal(validValues, 0);
		assertEquals("Adding all values of Column 0",10.0, actual, delta );
		
	}
	
	
	@Test 
	public void calculateColumnTotalWithValidDataAndPositiveOutOfBoundsColumn() {
		// using 0 as a column since mock data only has one Column
		double actual = DataUtilities.calculateColumnTotal(validValues, 10);
		assertEquals("Adding all values of Column 10",0.0, actual, delta );
		
	}
	
	@Test 
	public void calculateColumnTotalWithValidDataAndNegativeOutOfBoundsColumn() {
		// using 0 as a column since mock data only has one Column
		double actual = DataUtilities.calculateColumnTotal(validValues, -1);
		assertEquals("Adding all values of Column -1",0.0, actual, delta );
		
	}
	
	
	// ROW TOTAL TEST ------------------------------------------------------------------
	
	@Test (expected = InvalidParameterException.class)
	public void calculateRowTotalWithNullData() {
		// Row 1 is the row with invalid data
		DataUtilities.calculateRowTotal(validValues, 1);
	}
	
	@Test 
	public void calculateRowTotalWithValidDataAndValidRow() {
		double actual = DataUtilities.calculateRowTotal(validValues, 0);
		assertEquals("Adding all values of Row 0",7.5, actual, delta );
		
	}
	
	@Test 
	public void calculateRowTotalWithValidDataAndPositiveOutOfBoundsRow() {
		double actual = DataUtilities.calculateRowTotal(validValues, 10);
		assertEquals("Adding all values of Row 10",0.0, actual, delta );
		
	}
	
	// Q: Getting an error because it throws exception instead of 
	// returning 0. Is that ok?
	@Test 
	public void calculateRowTotalWithValidDataAndNegativeOutOfBoundsRow() {
		double actual = DataUtilities.calculateRowTotal(validValues, -1);
		assertEquals("Adding all values of Row -1",0.0, actual, delta );
	}	
	
	// createNumberArray() TESTS ------------------------------------------------
	@SuppressWarnings("deprecation")
	@Test
	public void createNumberArrayFromValidArray() {
		Number[] actual = DataUtilities.createNumberArray(input);
		assertEquals("Converting valid double[] to Number[]",expected,actual);
	}
	
	// Q: what would be an invalid data object?
	@SuppressWarnings("deprecation")
	@Test (expected=InvalidParameterException.class)
	public void createNumberArrayFromInvalidArray() {
		double[] input = {};
		Number [] expectedArr = {};
		Number [] actual = DataUtilities.createNumberArray(input);
		assertEquals("Converting empty double[] to Number[]", expectedArr, actual);
	}



}