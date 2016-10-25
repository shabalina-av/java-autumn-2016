package com.spbstu.shabalina.archive;

import org.apache.commons.cli.*;

import java.util.Random;

public class Generator {
  private static Random RANDOM = new Random();
  private static byte[] BUFFER = new byte[1];

  public static void main(String[] args) {
    Options options = new Options();

    options.addOption(Option.builder("p")
        .hasArg()
        .argName("p")
        .longOpt("prop")
        .desc("float number [0, 1] - the chance to generate next number same as previous")
        .type(Double.class)
        .build());
    options.addOption(Option.builder("l")
        .longOpt("length")
        .hasArg()
        .desc("count of generated numbers")
        .type(Integer.class)
        .build());
    try {
      CommandLineParser parser = new DefaultParser();
      CommandLine parse = parser.parse(options, args);
      double p = Double.valueOf(parse.getOptionValue("prop"));
      int len = Integer.valueOf(parse.getOptionValue("length"));
      byte[] result = generate(p, len);
      System.out.write(result);
    } catch (Exception e) {
      new HelpFormatter().printHelp("generator", options);
    }
  }

  private static byte[] generate(double p, int len) {
    Random random = new Random();
    byte[] byteBuffer = new byte[1];
    random.nextBytes(byteBuffer);
    byte A[] = new byte[len];
    A[0] = nextByte();
    for (int i = 1; i < len; i++) {
      double v = random.nextDouble();
      if (v <= p) {
        A[i] = A[i - 1];
      } else {
        A[i] = nextByte();
      }
    }
    return A;
  }

  private static byte nextByte() {
    RANDOM.nextBytes(BUFFER);
    return BUFFER[0];
  }
}
