package com.spbstu.shabalina.archive.rle;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class RleEncoderTest {
  @Test
  public void encodeTest() throws IOException {
    ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();

    try(RleEncoder encoder = new RleEncoder(arrayOutputStream)) {
      encoder.write(new byte[]{1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4});
    }

    byte[] bytes = arrayOutputStream.toByteArray();

    assertEquals(8, bytes.length);

    assertEquals(5, bytes[0]);
    assertEquals(1, bytes[1]);

    assertEquals(3, bytes[2]);
    assertEquals(2, bytes[3]);

    assertEquals(3, bytes[4]);
    assertEquals(3, bytes[5]);

    assertEquals(1, bytes[6]);
    assertEquals(4, bytes[7]);
  }

  @Test(expected = IOException.class)
  public void readFromClosedStreamTest() throws IOException {
    RleEncoder decoder = new RleEncoder(new ByteArrayOutputStream());

    boolean isThrown = false;
    try {
      decoder.close();
    } catch (IOException e) {
      isThrown = true;
    }

    assertFalse(isThrown);

    //noinspection ResultOfMethodCallIgnored
    decoder.write(10);
  }
}
