package com.disjoint.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DisjointSolution {

	public static ArrayList<Interval> add(List<Interval> intervals, Interval newInterval) {

		if (!newInterval.isValidValues()) {
			throw new IllegalArgumentException("fist value must be less then second value.");
		}

		ArrayList<Interval> result = new ArrayList<Interval>();

		for (Interval interval : intervals) {
			if (interval.getEnd() < newInterval.getStart()) {
				result.add(interval);
			} else if (interval.getStart() > newInterval.getEnd()) {
				result.add(newInterval);
				newInterval = interval;
			} else if (interval.getEnd() >= newInterval.getStart() || interval.getStart() <= newInterval.getEnd()) {
				newInterval = new Interval(Math.min(interval.getStart(), newInterval.getStart()),
						Math.max(newInterval.getEnd(), interval.getEnd()));
			}
		}

		result.add(newInterval);

		return result;
	}

	public static ArrayList<Interval> remove(List<Interval> intervals, Interval newInterval) {

		if (!newInterval.isValidValues()) {
			throw new IllegalArgumentException("Arguments of interval are invalid.");
		}

		ArrayList<Interval> result = new ArrayList<Interval>();

		for (int i = 0; i < intervals.size(); i++) {
			Interval interval = intervals.get(i);
			if (interval.getEnd() < newInterval.getStart()) {
				result.add(interval);
			} else if (interval.getStart() < newInterval.getStart() && interval.getEnd() > newInterval.getEnd()) {
				result.add(new Interval(interval.getStart(), newInterval.getStart()));
				result.add(new Interval(newInterval.getEnd(), interval.getEnd()));
			} else if (interval.getStart() <= newInterval.getStart() && interval.getEnd() > newInterval.getStart()) {
				if (interval.getStart() != newInterval.getStart()) {
					result.add(new Interval(interval.getStart(), newInterval.getStart()));
				}
				do {
					i++;
					if (i == intervals.size()) {
						break;
					}
					interval = intervals.get(i);
				} while (newInterval.getEnd() < interval.getStart() && newInterval.getEnd() < interval.getEnd());
				if (newInterval.getEnd() < interval.getStart() || newInterval.getEnd() < interval.getEnd()) {
					result.add(new Interval(newInterval.getEnd(), interval.getEnd()));
				}
			} else if (interval.getEnd() == newInterval.getStart()) {
				result.add(new Interval(interval.getStart(), newInterval.getStart()));
				i++;
				if (i == intervals.size()) {
					break;
				}
				interval = intervals.get(i);
				if (newInterval.getEnd() >= interval.getStart()) {
					result.add(new Interval(newInterval.getEnd(), interval.getEnd()));
				} else {
					i--;
				}
			} else if (interval.getStart() > newInterval.getEnd()) {
				result.add(interval);
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println("This is Disjoint Integer Set test Program.");
		Scanner scanner = new Scanner(System.in);
		List<Interval> intervals = new ArrayList<>();
		while (true) {
			System.out.println("\n1. Add Set");
			System.out.println("2. Remove Set");
			System.out.println("3. Exit");
			System.out.print("\nPlease make your choice : ");
			Integer choice = readInteger(scanner);
			if (choice == null) {
				System.out.println("Please provide valid Choice!");
			} else {
				if (choice == 1 || choice == 2) {
					Interval interval = readInterval(scanner);
					if (interval == null) {
						break;
					}
					if (choice == 1) {
						intervals = add(intervals, interval);
						System.out.println("Added : " + interval);
					} else if (choice == 2) {
						intervals = remove(intervals, interval);
						System.out.println("Removed : " + interval);
					}
					System.out.println("Updated List : " + intervals);
				} else if (choice == 3) {
					break;
				}
			}
		}
	}

	private static Integer readInteger(Scanner scanner) {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			scanner.nextLine();
			return null;
		}
	}

	private static Interval readInterval(Scanner scanner) {
		System.out.print("Start : ");
		Integer start = readInteger(scanner);
		if (start == null) {
			System.out.println("Invalid Start Value!");
			return null;
		}
		System.out.print("End : ");
		Integer end = readInteger(scanner);
		if (end == null) {
			System.out.println("Invalid End Value!");
			return null;
		}
		return new Interval(start, end);
	}

}
