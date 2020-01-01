package com.swe.janalyzer.util;

import java.io.IOException;
import java.nio.file.Path;

public class IOExceptionWithFile extends Exception{
    private IOException originalException;
    private Path file;


    public IOExceptionWithFile(IOException originalException, Path file) {
        this.originalException = originalException;
        this.file = file;
    }

    public IOExceptionWithFile(String message, IOException originalException, Path file) {
        super(message);
        this.originalException = originalException;
        this.file = file;
    }

    public IOExceptionWithFile(String message, Throwable cause, IOException originalException, Path file) {
        super(message, cause);
        this.originalException = originalException;
        this.file = file;
    }

    public IOExceptionWithFile(Throwable cause, IOException originalException, Path file) {
        super(cause);
        this.originalException = originalException;
        this.file = file;
    }

    public IOExceptionWithFile(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, IOException originalException, Path file) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.originalException = originalException;
        this.file = file;
    }

    public IOException getOriginalException() {
        return originalException;
    }

    public Path getFile() {
        return file;
    }

}
