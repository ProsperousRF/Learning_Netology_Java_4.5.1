import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author Stanislav Rakitov in 2021
 */
public class MissedCalls {
  Map<LocalDateTime, String> missedCalls;

  public MissedCalls() {
    this.missedCalls = new TreeMap<>();
  }

  public boolean addMissedCall(String line) {
    String result = missedCalls.put(LocalDateTime.now(), line);
    return result == null;
  }

  public Set<Map.Entry<LocalDateTime, String>> getEntries() {
    return this.missedCalls.entrySet();
  }

  public void clearAllCalls() {
    missedCalls.clear();
  }
}
