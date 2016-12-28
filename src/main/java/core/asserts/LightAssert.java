package core.asserts;

import java.util.Collection;

/**
 * Created by zaborovsky on 26.12.2016.
 */
public class LightAssert {

    private StringBuffer bufferErrors;

    public LightAssert() {
        this.bufferErrors = new StringBuffer();
    }

    public void assertTrue(boolean condition, String error, String whatCheck) {
        try {
            Assert.assertTrue(condition, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }

    public void assertEguals(Object actual, Object expected, String error, String whatCheck) {
        try {
            Assert.assertEquals(actual, expected, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }

    public void assertFalse(boolean condition, String error, String whatCheck) {
        try {
            Assert.assertFalse(condition, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
        }
    }

    public void assertContains(String actual, String expected, String error, String whatCheck) {
        try {
            Assert.assertTrue(actual.contains(expected), error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
            bufferErrors.append(String.format("Expected \n'%s'\n in \n'%s'", expected, actual));
        }
    }

    public <T> void assertInArray(T expected, Collection<? super T> actual, String error, String whatCheck) {
        try {
            Assert.assertInArray(expected, actual, error, whatCheck);
        } catch (AssertionError exc) {
            bufferErrors.append(error + "\n");
            bufferErrors.append(exc.getMessage() + "\n");
            bufferErrors.append(String.format("Expected \n'%s'\n in \n'%s'", expected, actual));
        }
    }



}
