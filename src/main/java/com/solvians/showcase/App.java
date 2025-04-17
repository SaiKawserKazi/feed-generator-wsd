package com.solvians.showcase;

import java.util.List;

public class App {

    public static void main(String[] args) {
        System.out.println("Feed Generator starting...");

        if (args.length < 2) {
            System.err.println("Expect at least number of threads and number of quotes. But got: " + args.length);
            System.err.println("Usage: java -jar feed-generator.jar <numThreads> <numQuotes>");
            return;
        }

        try {
            int numThreads = Integer.parseInt(args[0]);
            int numQuotes = Integer.parseInt(args[1]);

            System.out.println("Generating " + numQuotes + " certificate updates using " + numThreads + " threads...");

            FeedGenerator generator = new FeedGenerator(numThreads, numQuotes);
            List<String> updates = generator.generate();

            System.out.println("Generated Certificate Updates:");
            updates.forEach(System.out::println);

            System.out.println("Generation complete.");

        } catch (NumberFormatException e) {
            System.err.println("Invalid number format for threads or quotes. Both should be integers.");
        } catch (Exception e) {
            System.err.println("An error occurred during feed generation: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
