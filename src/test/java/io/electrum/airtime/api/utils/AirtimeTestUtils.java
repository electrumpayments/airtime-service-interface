package io.electrum.airtime.api.utils;

import javax.annotation.Nullable;

import io.electrum.gateway.testutils.TestMessageFileReader;
import io.electrum.vas.JsonUtil;

public class AirtimeTestUtils {

   @Nullable
   public static <T> T deserialiseJsonObjectFromFile(String filename, Class<T> clazz) throws Exception {
      return JsonUtil.deserialize(TestMessageFileReader.readFileAsString(filename, true), clazz);
   }
}
