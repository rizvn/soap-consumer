package com.app;

import com.app.stockapi.GetStocksXMLSchema;
import com.app.stockapi.GetStocksXMLSchemaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.SoapMessage;

public class SoapClient extends WebServiceGatewaySupport {

  private static final Logger log = LoggerFactory.getLogger(SoapClient.class);

  String uri ="http://www.gama-system.com/webservices";

  public GetStocksXMLSchemaResponse getSchema() {
    GetStocksXMLSchema request = new GetStocksXMLSchema();
    GetStocksXMLSchemaResponse response = (GetStocksXMLSchemaResponse) getWebServiceTemplate().marshalSendAndReceive(request, addAction("/GetStocksXMLSchema"));
    return response;
  }

  private WebServiceMessageCallback addAction(String soapAction){
    return  webServiceMessage -> ((SoapMessage)webServiceMessage).setSoapAction(uri + soapAction);
  }
}
