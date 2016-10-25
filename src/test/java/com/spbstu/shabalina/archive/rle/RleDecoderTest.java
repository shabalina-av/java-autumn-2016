package com.spbstu.shabalina.archive.rle;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class RleDecoderTest {
  @Test
  public void decodeTest() throws IOException {
    RleDecoder decoder = new RleDecoder(new ByteArrayInputStream(new byte[] {2, 1, 3, 2, 2, 3})); // 11 222 33

    assertEquals(1, decoder.read());
    assertEquals(1, decoder.read());
    assertEquals(2, decoder.read());
    assertEquals(2, decoder.read());
    assertEquals(2, decoder.read());
    assertEquals(3, decoder.read());
    assertEquals(3, decoder.read());
    assertEquals(-1, decoder.read());
  }
}