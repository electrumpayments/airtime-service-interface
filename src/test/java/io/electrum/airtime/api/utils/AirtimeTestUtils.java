package io.electrum.airtime.api.utils;

import java.io.BufferedReader;
import java.io.FileReader;

import io.electrum.vas.JsonUtil;

public class AirtimeTestUtils {

   public static String TEST_MSG_FILE_PATH = "./src/test/resources/messages/";

   public static <T> T deserialiseJsonObjectFromFile(String filename, Class<T> clazz) throws Exception {
      return JsonUtil.deserialize(readFileAsString(filename, true), clazz);
   }

   public static String readFileAsString(String filename, boolean preserveWhitespace) throws Exception {
      StringBuilder sb = new StringBuilder();
      try (BufferedReader br = new BufferedReader(new FileReader(TEST_MSG_FILE_PATH + filename))) {
         String line = br.readLine();
         while (line != null) {
            if (preserveWhitespace) {
               sb.append(line);
               sb.append(System.lineSeparator());
            } else {
               sb.append(line.trim());
            }
            line = br.readLine();
         }
      }
      String fileContents = sb.toString();
      if (preserveWhitespace) {
         fileContents = fileContents.substring(0, fileContents.length() - 1);
      }
      return fileContents;
   }
}
