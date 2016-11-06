package com.spbstu.shabalina.archive.rle;

import java.io.IOException;
import java.io.InputStream;

public class RleDecoder extends InputStream {
  private final InputStream inputStream;
  private int cachedValue = Integer.MIN_VALUE;
  private int remainRepeatCount = 0;
  private boolean isClosed = false;

  public RleDecoder(InputStream in) {
    inputStream = in;
  }

  @Override
  public void close() throws IOException {
    inputStream.close();
    isClosed = true;
  }

  @Override
  public int read() throws IOException {
    if(isClosed) {
      throw new IOException("Stream was closed");
    }
    if (remainRepeatCount > 0) {
      remainRepeatCount--;
      return cachedValue;
    } else {
      int count = inputStream.read();
      int value = inputStream.read();
      if(count != -1 && value == -1) {
        throw new IOException("Wrong stream format. Number of bytes must be an even number");
      }

      if (value != -1) {
        cachedValue = value;
        remainRepeatCount = count;
        return read();
      }
    }

    return -1;
  }
}
