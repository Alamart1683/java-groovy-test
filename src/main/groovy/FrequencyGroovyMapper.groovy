@groovy.util.logging.Slf4j
class FrequencyGroovyMapper {
    Map<Integer, Long> getFrequencyMap(List<Integer> numbers) {
        log.trace("Starting frequency calculation for list: {}", numbers)

        Map<Integer, Long> frequencyMap = numbers.groupBy { it }.collectEntries { key, values ->
            [key, values.size().toLong()]
        }

        if (log.debugEnabled) {
            log.debug("Calculated frequency map:\n{}", formatMapAsString(frequencyMap))
        }

        log.info("Frequency map calculated successfully. Total unique elements: {}", frequencyMap.size())
        return frequencyMap
    }

    private String formatMapAsString(Map<Integer, Long> map) {
        map.collect { key, value ->
            String.format("  %5d --> %3d occurrence(s)", key, value)
        }.join("\n")
    }
}
