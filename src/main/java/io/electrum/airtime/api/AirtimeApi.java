package io.electrum.airtime.api;

public class AirtimeApi {

   public static final String VERSION = "5";
   public static final String API_BASE_PATH = "/airtime/v" + VERSION;

   public static class Headers {
      public static final String X_JWS_SIGNATURE = "x-jws-signature";
   }
}
