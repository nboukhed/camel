package org.apache.camel.loanbroker.webservice.version;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.message.MessageContentsList;
import org.apache.camel.loanbroker.webservice.version.bank.BankQuote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ResponseMapper implements Processor {
	private static final Logger LOG = LoggerFactory
			.getLogger(ResponseMapper.class);
	
	@SuppressWarnings("unchecked")
    public void process(Exchange exchange) throws Exception {
		
		LOG.info("in the ResponseMapper ..............");
		BankQuote quote = (BankQuote)exchange.getIn().getBody(MessageContentsList.class).get(0);
		LOG.debug("getBankName .............." + quote.getBankName());
		LOG.debug("getRate .............."+ quote.getRate());
		LOG.debug("getSsn .............." + quote.getSsn());

		exchange.getOut().setBody(quote, BankQuote.class);

		
        		  
		
	}
}