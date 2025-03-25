import spock.lang.Specification
import spock.lang.Unroll

class FrequencyGroovyMapperTest extends Specification {
    def mapper = new FrequencyGroovyMapper()

    @Unroll
    def "testGetFrequencyMap for input: #input returns #expected"() {
        expect:
        mapper.getFrequencyMap(input) == expected

        where:
        input                             | expected
        [1, 3, 4, 5, 1, 5, 4]             | [(1): 2L, (3): 1L, (4): 2L, (5): 2L]
        [2, 2, 2]                         | [(2): 3L]
        [-1, 0, 1, 0]                     | [(-1): 1L, (0): 2L, (1): 1L]
        []                                | [:]
        [100]                             | [(100): 1L]
        [5, 5, 5, 5, 5]                   | [(5): 5L]
        [1, 2, 3, 4, 5]                   | [(1): 1L, (2): 1L, (3): 1L, (4): 1L, (5): 1L]
        [10, 20, 10, 30, 20, 10]          | [(10): 3L, (20): 2L, (30): 1L]
        [0, 0, 0, 0]                      | [(0): 4L]
        [7, 7, 8, 8, 9, 9]                | [(7): 2L, (8): 2L, (9): 2L]
    }
}