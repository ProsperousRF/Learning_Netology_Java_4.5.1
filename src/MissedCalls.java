import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Stanislav Rakitov in 2021
 */
public class MissedCalls {
  Map<LocalDateTime, String> missedCalls;

  public MissedCalls() {
    this.missedCalls  = new TreeMap<>();
  }
}
