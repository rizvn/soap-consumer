package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SoapConfig {

  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setContextPath("com.app.stockapi");
    return marshaller;
  }

  @Bean
  public SoapClient quoteClient(Jaxb2Marshaller marshaller) {
    SoapClient client = new SoapClient();
    client.setDefaultUri("http://webservices.gama-system.com/stockquotes.asmx");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

}
