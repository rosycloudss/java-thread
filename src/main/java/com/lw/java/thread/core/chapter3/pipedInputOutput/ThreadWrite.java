package com.lw.java.thread.core.chapter3.pipedInputOutput;

import java.io.IOException;
import java.io.PipedOutputStream;

public class ThreadWrite extends Thread {
    private WriteData write;
    private PipedOutputStream out;

    public ThreadWrite(WriteData write, PipedOutputStream out) {
        this.write = write;
        this.out = out;
    }

    @Override
    public void run() {
        super.run();
        try {
            write.writeMethod(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
