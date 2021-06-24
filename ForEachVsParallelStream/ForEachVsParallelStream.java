import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ForEachVsParallelStream {
    public static void main(final String[] args) {

        final List<List<Integer>> queries = new ArrayList<>();
        final int n = 10000000;
        final Random rand = new Random();

        for (int i = 0; i < n; ++i) {

            final List<Integer> lst = new ArrayList<>();

            for (int j = 0; j < 3; ++j) {
                lst.add(rand.nextInt(99));
            }
            queries.add(lst);
        }

        parallelStream(queries);
        enhancedForeach(queries);
    }

    public static void parallelStream(final List<List<Integer>> queries) {

        final long startTime = System.currentTimeMillis();
        queries.parallelStream().forEach(ForEachVsParallelStream::loopThroughList);
        final long endTime = System.currentTimeMillis();
        System.out.println("Parallel stream time taken:" + (endTime - startTime));
    }

    public static void enhancedForeach(final List<List<Integer>> queries) {

        final long startTime = System.currentTimeMillis();

        for (final List<Integer> qry : queries) {
            loopThroughList(qry);
        }

        final long endTime = System.currentTimeMillis();
        System.out.println("Enhanced Foreach time taken:" + (endTime - startTime));
    }

    private static void loopThroughList(final List<Integer> qry) {
        final int a = qry.get(0) - 1;
        final int b = qry.get(1);

        for (int j = a; j < b; ++j) {
        }
    }
}
