package com.solvians.showcase;

public class App {
	public App(String threads, String quotes) {
	}

	public static void main(String[] args) {

		System.out.println("Feed Generator starting...");

		if (args.length >= 2) {
			System.out.println("Received threads: " + args[0] + ", quotes: " + args[1]);
		} else {
			System.err.println("Expect at least number of threads and number of quotes. But got: " + args.length);
		}
	}
}

