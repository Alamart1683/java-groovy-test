import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrequencyJavaMapperTest {
    private final FrequencyJavaMapper frequencyJavaMapper = new FrequencyJavaMapper();

    static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(
                        List.of(1, 3, 4, 5, 1, 5, 4),
                        Map.of(1, 2L, 3, 1L, 4, 2L, 5, 2L)
                ),
                Arguments.of(
                        List.of(2, 2, 2),
                        Map.of(2, 3L)
                ),
                Arguments.of(
                        List.of(-1, 0, 1, 0),
                        Map.of(-1, 1L, 0, 2L, 1, 1L)
                ),
                Arguments.of(
                        List.of(),
                        Map.of()
                ),
                Arguments.of(
                        List.of(100),
                        Map.of(100, 1L)
                ),
                Arguments.of(
                        List.of(5, 5, 5, 5, 5),
                        Map.of(5, 5L)
                ),
                Arguments.of(
                        List.of(1, 2, 3, 4, 5),
                        Map.of(1, 1L, 2, 1L, 3, 1L, 4, 1L, 5, 1L)
                ),
                Arguments.of(
                        List.of(10, 20, 10, 30, 20, 10),
                        Map.of(10, 3L, 20, 2L, 30, 1L)
                ),
                Arguments.of(
                        List.of(0, 0, 0, 0),
                        Map.of(0, 4L)
                ),
                Arguments.of(
                        List.of(7, 7, 8, 8, 9, 9),
                        Map.of(7, 2L, 8, 2L, 9, 2L)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideTestData")
    void testGetFrequencyMap(List<Integer> input, Map<Integer, Long> expected) {
        Map<Integer, Long> result = frequencyJavaMapper.getFrequencyMap(input);
        assertEquals(expected, result, () ->
                String.format("Failed for input: %s\nExpected: %s\nActual: %s",
                        input, expected, result));
    }
}
