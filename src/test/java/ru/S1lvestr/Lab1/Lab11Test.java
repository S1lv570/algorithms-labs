package ru.S1lvestr.Lab1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.S1lvestr.Lab1.Lab11.Solution;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lab11TestTest {

    private final Solution lab = new Solution();

    @ParameterizedTest(name = "\"{0}\" -> balanced")
    @CsvSource({
            "[]",
            "[](){}",
            "[({})]",
            "[({}()){}]"
    })
    void balancedExamplesFromTask(String input) {
        assertTrue(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" -> NOT balanced")
    @CsvSource({
            "{]",
            "({)}"
    })
    void unbalancedExamplesFromTask(String input) {
        assertFalse(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" -> NOT balanced")
    @CsvSource({"("})
    void singleOpeningBracketIsNotBalanced(String input) {
        assertFalse(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" -> NOT balanced")
    @CsvSource({")"})
    void singleClosingBracketIsNotBalanced(String input) {
        assertFalse(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" - NOT balanced")
    @CsvSource({"((((("})
    void onlyOpeningBracketsIsNotBalanced(String input) {
        assertFalse(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" - NOT balanced")
    @CsvSource({")))))"})
    void onlyClosingBracketsIsNotBalanced(String input) {
        assertFalse(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" - NOT balanced")
    @CsvSource({"[(])"})
    void wrongClosingTypeAtEndIsNotBalanced(String input) {
        assertFalse(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" -> balanced")
    @CsvSource({"((((((()))))))"})
    void deeplyNestedSameTypeIsBalanced(String input) {
        assertTrue(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" -> balanced")
    @CsvSource({"()()()()()()()()"})
    void manySequentialPairsIsBalanced(String input) {
        assertTrue(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" -> balanced")
    @CsvSource({"{[()()]}[{}]()"})
    void mixedSequentialAndNestedIsBalanced(String input) {
        assertTrue(lab.isBalanced(input));
    }

    @ParameterizedTest(name = "\"{0}\" - NOT balanced")
    @CsvSource({")("})
    void reversedOrderIsNotBalanced(String input) {
        assertFalse(lab.isBalanced(input));
    }

}