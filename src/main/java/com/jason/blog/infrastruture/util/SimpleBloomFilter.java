package com.jason.blog.infrastruture.util;

import java.util.BitSet;


public class SimpleBloomFilter {

	private static final int DEFAULT_BIT_SIZE = 2 << 24;
	private static final int DEFAULT_HASH_SIZE = 8;
	private static final int[] seeds = new int[] { 7, 11, 13, 31, 37, 61, 79, 88 };
	private BitSet bits;

	private SimpleHashFunction[] funcs = new SimpleHashFunction[seeds.length];

	public SimpleBloomFilter() {
		this(DEFAULT_BIT_SIZE, DEFAULT_HASH_SIZE);
	}

	public SimpleBloomFilter(int nbits, int nhash) {
		this.bits = new BitSet(nbits);

		for (int i = 0; i < seeds.length; i++) {
			funcs[i] = new SimpleHashFunction(nbits, seeds[i]);
		}
	}

	public void add(String value) {

		for (SimpleHashFunction f : funcs) {
			bits.set(f.hash(value), true);
		}
	}

	public boolean contains(String value) {
		if (value == null) {
			return false;
		}

		boolean result = true;
		for (SimpleHashFunction f : funcs) {
			result = result && bits.get(f.hash(value));
		}

		return result;
	}

	public static class SimpleHashFunction {
		private int cap;
		private int seed;

		public SimpleHashFunction(int cap, int seed) {
			this.cap = cap;
			this.seed = seed;
		}

		public int hash(String value) {
			int result = 0;
			int len = value.length();
			for (int i = 0; i < len; i++) {
				result = seed * result + value.charAt(i);
			}
			return (cap - 1) & result;
		}
	}
}