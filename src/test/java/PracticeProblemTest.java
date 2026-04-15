import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

public class PracticeProblemTest {

    // ─────────────────────────────────────────────
    //  1. randomNumber(int min, int max)
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("randomNumber: result is within range [1, 10]")
    void randomNumberTest1() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomNumber", cArg);
            int result = (int) method.invoke(null, 1, 10);
            assertTrue(result >= 1 && result <= 10,
                    "Expected result between 1 and 10 (inclusive), got: " + result);
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomNumber: result is within range [5, 5] (single value)")
    void randomNumberTest2() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomNumber", cArg);
            int result = (int) method.invoke(null, 5, 5);
            assertEquals(5, result,
                    "When min == max == 5, result must always be 5");
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomNumber: result is within range [-10, -1] (negative range)")
    void randomNumberTest3() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomNumber", cArg);
            int result = (int) method.invoke(null, -10, -1);
            assertTrue(result >= -10 && result <= -1,
                    "Expected result between -10 and -1 (inclusive), got: " + result);
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomNumber: inclusive check - result stays within [0, 100] over many calls")
    void randomNumberTest4() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomNumber", cArg);
            for (int i = 0; i < 1000; i++) {
                int result = (int) method.invoke(null, 0, 100);
                assertTrue(result >= 0 && result <= 100,
                        "Expected result between 0 and 100 (inclusive), got: " + result);
            }
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    // ─────────────────────────────────────────────
    //  2. randomChar(String s)
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("randomChar: returned character exists in the source string")
    void randomCharTest1() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { String.class };
            Method method = testClass.getDeclaredMethod("randomChar", cArg);
            String source = "Hello";
            char result = (char) method.invoke(null, source);
            assertTrue(source.indexOf(result) >= 0,
                    "Expected character from 'Hello', got: " + result);
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomChar: single-character string always returns that character")
    void randomCharTest2() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { String.class };
            Method method = testClass.getDeclaredMethod("randomChar", cArg);
            char result = (char) method.invoke(null, "Z");
            assertEquals('Z', result,
                    "Single-character string 'Z' must always return 'Z'");
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomChar: returned character exists in a digit string")
    void randomCharTest3() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { String.class };
            Method method = testClass.getDeclaredMethod("randomChar", cArg);
            String source = "1234567890";
            char result = (char) method.invoke(null, source);
            assertTrue(source.indexOf(result) >= 0,
                    "Expected digit character from '1234567890', got: " + result);
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomChar: stays within string over many calls")
    void randomCharTest4() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { String.class };
            Method method = testClass.getDeclaredMethod("randomChar", cArg);
            String source = "abcde";
            for (int i = 0; i < 1000; i++) {
                char result = (char) method.invoke(null, source);
                assertTrue(source.indexOf(result) >= 0,
                        "Character '" + result + "' is not in source string '" + source + "'");
            }
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    // ─────────────────────────────────────────────
    //  3. randomEvenNumber(int min, int max)
    // ─────────────────────────────────────────────

    @Test
    @DisplayName("randomEvenNumber: result is even and within range [1, 10]")
    void randomEvenNumberTest1() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomEvenNumber", cArg);
            int result = (int) method.invoke(null, 1, 10);
            assertTrue(result >= 1 && result <= 10,
                    "Expected result between 1 and 10 (inclusive), got: " + result);
            assertEquals(0, result % 2,
                    "Expected an even number, got: " + result);
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomEvenNumber: result is even and within range [0, 20]")
    void randomEvenNumberTest2() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomEvenNumber", cArg);
            int result = (int) method.invoke(null, 0, 20);
            assertTrue(result >= 0 && result <= 20,
                    "Expected result between 0 and 20 (inclusive), got: " + result);
            assertEquals(0, result % 2,
                    "Expected an even number, got: " + result);
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomEvenNumber: result is even and within range [2, 2] (single even value)")
    void randomEvenNumberTest3() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomEvenNumber", cArg);
            int result = (int) method.invoke(null, 2, 2);
            assertEquals(2, result,
                    "When min == max == 2, result must always be 2");
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }

    @Test
    @DisplayName("randomEvenNumber: always even over many calls in range [1, 100]")
    void randomEvenNumberTest4() {
        Class<?> testClass = PracticeProblem.class;
        try {
            Class<?>[] cArg = { int.class, int.class };
            Method method = testClass.getDeclaredMethod("randomEvenNumber", cArg);
            for (int i = 0; i < 1000; i++) {
                int result = (int) method.invoke(null, 1, 100);
                assertTrue(result >= 1 && result <= 100,
                        "Expected result between 1 and 100 (inclusive), got: " + result);
                assertEquals(0, result % 2,
                        "Expected an even number, got: " + result);
            }
        } catch (NoSuchMethodException e) {
            fail("Method does not exist");
        } catch (Exception e) {
            fail("Something weird happened: " + e);
        }
    }
}