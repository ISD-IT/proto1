/*******************************************************************************
 * Copyright (c) 2015 Valentin Pogrebinsky
 * All rights reserved. 
 *******************************************************************************/
package org.proto1.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.proto1.domain.order.OrderLine;
import org.proto1.repository.order.OrderLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations={"classpath:/META-INF/domain.xml", "classpath:/META-INF/product.xml","classpath:/META-INF/applicationContext.xml"})
public class RepositoryBehaviorTest extends AbstractJUnit4SpringContextTests{
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	OrderLineRepository orderLineRepository;
	
	@Test
	public void test() {
		
		Long[] pl = {4L,2L,1L};
		for(OrderLine ol : orderLineRepository.getListByProductId(5L)) {
			logger.debug(orderLineRepository.getParametersValues(pl, ol.getId(), 1L));
		}

	}
	
}
