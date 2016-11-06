package com.spbstu.shabalina.archive.rle;

import java.io.IOException;
import java.io.OutputStream;

public class RleEncoder extends OutputStream {
  private static final int MAX_REPEAT_COUNT = 255;

  private final OutputStream outputStream;

  private int cachedValue = Integer.MIN_VALUE;
  private int repeatCount = 0;

  private boolean isClosed = false;

  public RleEncoder(OutputStream out) {
    outputStream = out;
  }

  @Override
  public void write(int b) throws IOException {
    if (isClosed) {
      throw new IOException("Stream was closed");
    }

    if (b == cachedValue) {
      repeatCount++;
      if (repeatCount == MAX_REPEAT_COUNT) {
        flush();
      }
    } else {
      flush();

      cachedValue = b;
      repeatCount = 1;
    }
  }

  @Override
  public void close() throws IOException {
    flush();
    isClosed = true;
    outputStream.close();
  }

  @Override
  public void flush() throws IOException {
    if (repeatCount != 0) {
      outputStream.write(repeatCount);
      outputStream.write(cachedValue);
      repeatCount = 0;
    }
  }
}
