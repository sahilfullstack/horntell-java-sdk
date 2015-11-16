package com.owlgrin.horntell.logging;

/**
 * @author aldenquimby@gmail.com
 */
public class NoOpLogger implements Logger {

    public boolean isDebugEnabled() {
        return false;
    }

    public void debug(String msg) {
        // no-op
    }

    public boolean isErrorEnabled() {
        return false;
    }

    public void error(String msg) {
        // no-op
    }

    public void error(String msg, Throwable t) {
        // no op
    }
}
