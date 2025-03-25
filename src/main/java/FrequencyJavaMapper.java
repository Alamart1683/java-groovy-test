import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class FrequencyJavaMapper {
    public Map<Integer, Long> getFrequencyMap(List<Integer> numbers) {
        log.trace("Starting frequency calculation for list: {}", numbers);

        Map<Integer, Long> frequencyMap = numbers.stream()
                .collect(Collectors.groupingBy(
                        number -> number,
                        Collectors.counting()
                ));

        if (log.isDebugEnabled()) {
            log.debug("Calculated frequency map:\n{}", formatMapAsString(frequencyMap));
        }

        log.info("Frequency map calculated successfully. Total unique elements: {}", frequencyMap.size());
        return frequencyMap;
    }

    private String formatMapAsString(Map<Integer, Long> map) {
        return map.entrySet().stream()
                .map(entry -> String.format("  %5d --> %3d occurrence(s)", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}