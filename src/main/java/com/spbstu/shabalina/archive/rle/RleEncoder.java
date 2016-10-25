package com.spbstu.shabalina.archive.rle;

import java.io.IOException;
import java.io.OutputStream;

public class RleEncoder extends OutputStream {
  private static final int MAX_REPEAT_COUNT = 255;

  private final OutputStream outputStream;

  private int cachedValue = Integer.MIN_VALUE;
  private int repeatCount = 0;

  public RleEncoder(OutputStream out) {
    outputStream = out;
  }

  @Override
  public void write(int b) throws IOException {
    if (b == cachedValue) {
      repeatCount++;
      if (repeatCount == MAX_REPEAT_COUNT) {
        flush(repeatCount);
      }
    } else {
      flush(repeatCount);

      cachedValue = b;
      repeatCount = 1;
    }
  }

  @Override
  public void close() throws IOException {
    flush(repeatCount);

    outputStream.close();
    super.close();
  }

  private void flush(int count) throws IOException {
    if (count != 0) {
      outputStream.write(count);
      outputStream.write(cachedValue);
      repeatCount = 0;
    }
  }
}
