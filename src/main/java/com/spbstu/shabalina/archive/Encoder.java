package com.spbstu.shabalina.archive;

import com.spbstu.shabalina.archive.rle.RleEncoder;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

// encoder
// encoder -f filename
// encoder --file filename
public class Encoder {
  private static final int BUFFER_SIZE = 4096;

  public static void main(String[] args) throws IOException {
    Options options = new Options();

    options.addOption(Option.builder("f")
        .hasArg()
        .required(false)
        .argName("filename")
        .longOpt("file")
        .desc("file for encoding")
        .type(String.class)
        .build());
    String filename = null;
    try {
      CommandLineParser parser = new DefaultParser();
      CommandLine parse = parser.parse(options, args);
      if (parse.hasOption("file")) {
        filename = parse.getOptionValue("file");
      }
    } catch (Exception e) {
      new HelpFormatter().printHelp("encoder", options);
    }

    try (RleEncoder encoder = new RleEncoder(System.out);
         InputStream inputStream = filename == null
             ? System.in
             : Files.newInputStream(Paths.get(filename))) {
      byte[] buffer = new byte[BUFFER_SIZE];
      int readCount = inputStream.read(buffer);
      while (readCount >= 0) {
        encoder.write(buffer, 0, readCount);
        readCount = inputStream.read(buffer);
      }
    }
  }
}
