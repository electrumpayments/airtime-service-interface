package io.electrum.airtime.api;

import javax.net.ssl.SSLContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import io.electrum.gateway.cog.CogConfig;
import io.electrum.gateway.cog.Stream;
import io.electrum.gateway.cog.rest.RestOutlet;
import io.electrum.gateway.cog.rest.RestOutletConfig;

public class AirtimeOutlet extends RestOutlet {
   private RestOutletConfig config;

   public AirtimeOutlet(CogConfig config, Stream stream) throws Exception {
      super(config, stream);
      this.config = new RestOutletConfig(config.getName());
   }

   @Override
   protected Client constructClient() throws Exception {
      SSLContext sslContext = constructSslContext();
      ClientBuilder clientBuilder = ClientBuilder.newBuilder().sslContext(sslContext);
      if (config.isEnableHttpAuth()) {
         HttpAuthenticationFeature httpAuthFeature = HttpAuthenticationFeature.basicBuilder().build();
         clientBuilder.register(httpAuthFeature);
      }

      return clientBuilder.build();
   }
}
