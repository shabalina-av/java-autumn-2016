package com.spbstu.shabalina.archive;

import com.spbstu.shabalina.archive.rle.RleDecoder;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

// decoder
// decoder -f filename
// decoder --file filename
public class Decoder {
  private static final int BUFFER_SIZE = 4096;

  public static void main(String[] args) throws IOException {
    Options options = new Options();

    options.addOption(Option.builder("f")
        .hasArg()
        .required(false)
        .argName("filename")
        .longOpt("file")
        .desc("file for decoding")
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
      new HelpFormatter().printHelp("decoder", options);
    }

    try (RleDecoder decoder = new RleDecoder(filename == null ?
        System.in :
        Files.newInputStream(Paths.get(filename)))) {
      byte[] buffer = new byte[BUFFER_SIZE];
      int readCount = decoder.read(buffer);
      while (readCount != -1) {
        System.out.write(buffer, 0, readCount);
        readCount = decoder.read(buffer);
      }
    } catch (NoSuchFileException e) {
      System.err.println("File " + filename + " not found");
      new HelpFormatter().printHelp("decoder", options);
    }
  }
}
