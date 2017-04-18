/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.loanbroker.webservice.version;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.loanbroker.webservice.version.credit.CreditAgencyWS;
import org.apache.cxf.BusFactory;
import org.apache.cxf.frontend.ClientFactoryBean;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Credit score processor.
 */
//START SNIPPET: credit
public class CreditScoreProcessor implements Processor {
    //private String creditAgencyAddress;
    //private CreditAgencyWS proxy;
    static Logger log = Logger.getLogger(CreditScoreProcessor.class.getName());

    public CreditScoreProcessor() {
        //creditAgencyAddress = address;
//        proxy = getProxy();
    }

//    private CreditAgencyWS getProxy() {
//        // Here we use JaxWs front end to create the proxy
//        JaxWsProxyFactoryBean proxyFactory = new JaxWsProxyFactoryBean();
//        ClientFactoryBean clientBean = proxyFactory.getClientFactoryBean();
//        clientBean.setAddress(creditAgencyAddress);
//        clientBean.setServiceClass(CreditAgencyWS.class);
//        clientBean.setBus(BusFactory.getDefaultBus());
//        return (CreditAgencyWS)proxyFactory.create();
//    }

    @SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {        

        String ssn = (String)  exchange.getIn().getHeader("ssn"); //(String) request.get(0);
        Double amount =  Double.valueOf((String)(exchange.getIn().getHeader("amount")));//(Double) request.get(1);
        Integer loanDuration = Integer.valueOf((String) exchange.getIn().getHeader("loanDuration")); //(Integer) request.get(2);
        
    	log.info("Calling Credit Score with Request[ ssn: " + ssn + ",amount: " + amount + ", loanDuration: " + loanDuration + "]");

        int historyLength = 10;//proxy.getCreditHistoryLength(ssn);
        int score = 10; // proxy.getCreditScore(ssn);
        
    	log.info("The credit check lookup returns the following informations :");
    	log.info(" - historyLength    : " + historyLength );
    	log.info(" - score            : " + score );

        // create the invocation message for Bank client
        List<Object> bankRequest = new ArrayList<Object>();
        bankRequest.add(ssn);
        bankRequest.add(amount);
        bankRequest.add(loanDuration);
        bankRequest.add(historyLength);
        bankRequest.add(score);
        exchange.getOut().setBody(bankRequest);
        exchange.getOut().setHeader("operationName", "getQuote");
    }

}
