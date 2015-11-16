package com.owlgrin.horntell.logging;

import com.owlgrin.horntell.util.FeatureDetector;

/**
 * @author aldenquimby@gmail.com
 */
public class LoggerFactory {

    /**
     * Get a named logger instance.
     *
     * @param clazz class from which a log name will be derived
     * @return the logger
     */
    public static Logger getLogger(Class clazz) {
        if (FeatureDetector.isCommonsLoggingAvailable()) {
            return new CommonsLogger(clazz);
        }
        else {
            return new NoOpLogger();
        }
    }
}
