import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TableView {
    private List<TableData> data;
    private static final String[] operations = new String[]{
            "GET",
            "ADD",
            "ADD_FIRST",
            "DELETE_FIRST",
            "DELETE_LAST",
    };


    public TableView() {
        this.data = new ArrayList<>();
    }

    public void add(TableData result) {
        data.add(result);
    }

    @Override
    public String toString() {
        data.sort(Comparator.comparingInt(TableData::iterations));

        StringBuilder output = new StringBuilder();
        String listSample = "%-16s";
        String linkedListTitle = String.format(listSample, "LinkedList, (ns)");
        String arrayListTitle = String.format(listSample, "ArrayList, (ns)");
        String space = String.format("%-10s", " ");
        String iterationTitle = String.format("%-10s", "Iterations");
        String operationTitle = String.format("%-14s", "Operation");

        String sep = " | ";

        output.append(iterationTitle).append(sep)
                .append(operationTitle).append(sep)
                .append(linkedListTitle).append(sep)
                .append(arrayListTitle).append(sep)
                .append("\n");
        for (TableData datum : data) {
            String iterations = String.format("%-10d", datum.iterations());

            for (int i = 0; i < operations.length; i++) {
                String operationName = operations[i];
                String expandedOperationName = String.format("%-14s", operations[i]);


                String timeLinked = String.format(listSample, datum.linkedList().get(operationName));
                String timeArray = String.format(listSample, datum.arrayList().get(operationName));

                output.append(i == 0 ? iterations : space).append(sep)
                        .append(expandedOperationName).append(sep)
                        .append(timeLinked).append(sep)
                        .append(timeArray).append(sep)
                        .append('\n');

            }
        }

        return output.toString();
    }
}
