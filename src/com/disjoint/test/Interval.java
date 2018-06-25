package com.disjoint.test;

public class Interval {

	private int start;

	private int end;

	public Interval() {
	}

	public Interval(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "[" + start + ", " + end + "]";
	}

	public boolean isValidValues() {
		if (start >= end)
			return false;
		else
			return true;
	}

}
