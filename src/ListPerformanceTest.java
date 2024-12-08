import java.util.*;

public class ListPerformanceTest {

    public static void main(String[] args) {
        TableView tableView = new TableView();
        int[] iterationsArr = new int[]{1000, 2000, 5000, 10000};

        for (int iterations : iterationsArr) {
            TableData datum = new TableData(iterations,
                    testList(iterations, new LinkedList<>()),
                    testList(iterations, new ArrayList<>()));
            tableView.add(datum);
        }

        System.out.println("Compare Table");
        System.out.println(tableView);

    }

    public static IterationResult testList(int iterations, List<Integer> list) {
        long startTime, endTime;
        Map<String, Long> data = new HashMap<>();


        // ADD
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }
        endTime = System.nanoTime();
        long addTime = endTime - startTime;
        data.put("ADD", addTime);

        // ADD_FIRST
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.addFirst(i);
        }
        endTime = System.nanoTime();
        long addFirstTime = endTime - startTime;
        data.put("ADD_FIRST", addFirstTime);

        // GET
        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.get(i);
        }
        endTime = System.nanoTime();
        long getTime = endTime - startTime;
        data.put("GET", getTime);




        // DELETE_LAST
        // refill
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.removeLast();
        }
        endTime = System.nanoTime();
        long deleteLastTime = endTime - startTime;
        data.put("DELETE_LAST", deleteLastTime);


        // DELETE_FIRST
        // refill
        for (int i = 0; i < iterations; i++) {
            list.add(i);
        }

        startTime = System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            list.removeFirst();
        }
        endTime = System.nanoTime();
        long deleteFirstTime = endTime - startTime;
        data.put("DELETE_FIRST", deleteFirstTime);

        return new IterationResult(iterations, data);
    }
}
