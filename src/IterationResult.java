import java.util.Map;

public record IterationResult(int iterationCount, Map<String, Long> data) {
    public IterationResult(int iterationCount, Map<String, Long> data) {
        this.iterationCount = iterationCount;
        this.data = Map.copyOf(data);
    }

    public long get(String key){
        return this.data.get(key);
    }
}