package com.app;


import com.app.stockapi.GetStocksXMLSchemaResponse;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SoapClientTest extends AbstractIntegrationTest{

  @Autowired
  SoapClient soapClient;

  @Test
  public void getSchemaTest(){
    GetStocksXMLSchemaResponse schema = soapClient.getSchema();
    Assert.assertNotNull(schema);

    System.out.println("Schema result:" +  schema.getGetStocksXMLSchemaResult());
  }
}