package com.lw.java.thread.core.chapter3.pipedInputOutput;

import java.io.IOException;
import java.io.PipedInputStream;

public class ThreadRead extends Thread {
    private ReadData read;
    private PipedInputStream input;

    public ThreadRead(ReadData read, PipedInputStream input) {
        this.read = read;
        this.input = input;
    }

    @Override
    public void run() {
        try {
            read.readMethod(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
