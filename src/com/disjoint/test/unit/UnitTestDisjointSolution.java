package com.disjoint.test.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.disjoint.test.DisjointSolution;
import com.disjoint.test.Interval;

public class UnitTestDisjointSolution {

	/**
	 * Test the program by adding one integer interval.
	 */
	@Test
	public void test1() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(2, 5));
		assertTrue(listResult.size() == 1);
	}

	/**
	 * Test the program by adding three integer interval.
	 */
	@Test
	public void test2() {
		List<Interval> listResult = new ArrayList<Interval>();

		listResult = DisjointSolution.add(listResult, new Interval(1, 3));
		listResult = DisjointSolution.add(listResult, new Interval(6, 9));
		listResult = DisjointSolution.add(listResult, new Interval(2, 5));
		System.out.println(listResult);

		assertTrue(listResult.size() == 2);
	}

	/**
	 * Test the program with add and remove oprations.
	 */
	@Test
	public void test3() {
		List<Interval> listResult = new ArrayList<Interval>();

		listResult = DisjointSolution.add(listResult, new Interval(1, 5));
		listResult = DisjointSolution.remove(listResult, new Interval(2, 3));
		System.out.println(listResult);
		listResult = DisjointSolution.add(listResult, new Interval(6, 8));
		System.out.println(listResult);
		listResult = DisjointSolution.remove(listResult, new Interval(4, 7));
		System.out.println(listResult);
		listResult = DisjointSolution.add(listResult, new Interval(2, 7));
		System.out.println(listResult);
		assertTrue(listResult.size() == 1);
	}

	/**
	 * Test the disjoint program with add and remove operations.
	 */
	@Test
	public void test4() {
		List<Interval> listResult = new ArrayList<Interval>();

		listResult = DisjointSolution.add(listResult, new Interval(1, 5));
		listResult = DisjointSolution.add(listResult, new Interval(8, 99));
		System.out.println(listResult);
		listResult = DisjointSolution.remove(listResult, new Interval(5, 8));
		System.out.println(listResult);
		assertTrue(listResult.size() == 2);
	}

	/**
	 * Test the program with adding similar type of integer interval.
	 */
	@Test
	public void test5() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(1, 3));
		listResult = DisjointSolution.add(listResult, new Interval(1, 3));
		listResult = DisjointSolution.add(listResult, new Interval(1, 3));
		System.out.println(listResult);
		assertTrue(listResult.size() == 1);
	}

	/**
	 * This test case expect an IllegalArgumentException because it try to
	 * insert an interval which second value is negative(1, -3).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test6() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(1, -3));
		listResult = DisjointSolution.add(listResult, new Interval(5, 7));
		listResult = DisjointSolution.add(listResult, new Interval(8, 10));
		System.out.println(listResult);
		assertTrue(listResult.size() == 1);
	}

	/**
	 * This test case expect an IllegalArgumentException because it try to
	 * insert an interval which first value is negative(-3, 5).
	 */
	@Test
	public void test7() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(1, 3));
		listResult = DisjointSolution.add(listResult, new Interval(-3, 5));
		listResult = DisjointSolution.add(listResult, new Interval(1, 3));
		System.out.println(listResult);
		assertTrue(listResult.size() == 1);
	}

	/**
	 * This test case expect an IllegalArgumentException because it try to
	 * insert an interval which first value is greater than second value(5,3).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test8() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(1, 2));
		listResult = DisjointSolution.add(listResult, new Interval(3, 4));
		listResult = DisjointSolution.add(listResult, new Interval(5, 3));
		System.out.println(listResult);
		assertTrue(listResult.size() == 1);
	}

	/**
	 * Test when the integer interval are adjacent.
	 */
	@Test
	public void test9() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(10, 20));
		listResult = DisjointSolution.add(listResult, new Interval(20, 30));
		listResult = DisjointSolution.add(listResult, new Interval(25, 30));
		System.out.println(listResult);
		assertTrue(listResult.size() == 1);
	}
	
	/**
	 * Test when first and second value of interval is same(10, 10).
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test10() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(10, 10));
		listResult = DisjointSolution.add(listResult, new Interval(20, 30));
		listResult = DisjointSolution.add(listResult, new Interval(25, 30));
		System.out.println(listResult);
		assertTrue(listResult.size() == 1);
	}
	
	@Test
	public void test11() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(0, 4));
		listResult = DisjointSolution.add(listResult, new Interval(5, 9));
		listResult = DisjointSolution.add(listResult, new Interval(11, 14));
		System.out.println(listResult);
		listResult = DisjointSolution.remove(listResult, new Interval(2, 6));
		System.out.println(listResult);
		assertTrue(listResult.size() == 3);
	}
	
	@Test
	public void test12() {
		List<Interval> listResult = new ArrayList<Interval>();
		listResult = DisjointSolution.add(listResult, new Interval(0, 2));
		listResult = DisjointSolution.add(listResult, new Interval(6, 9));
		listResult = DisjointSolution.add(listResult, new Interval(11, 14));
		System.out.println(listResult);
		listResult = DisjointSolution.remove(listResult, new Interval(2, 4));
		System.out.println(listResult);
		assertTrue(listResult.size() == 3);
	}

}
