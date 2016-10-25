package com.spbstu.shabalina.archive.rle;

import java.io.IOException;
import java.io.InputStream;

public class RleDecoder extends InputStream {
  private final InputStream inputStream;
  private int cachedValue = Integer.MIN_VALUE;
  private int remainRepeatCount = 0;

  public RleDecoder(InputStream in) {
    inputStream = in;
  }

  @Override
  public int read() throws IOException {
    if (remainRepeatCount > 0) {
      remainRepeatCount--;
      return cachedValue;
    } else {
      int count = inputStream.read();
      int value = inputStream.read();
      if (value != -1) {
        cachedValue = value;
        remainRepeatCount = count;
        return read();
      }
    }

    return -1;
  }
}
