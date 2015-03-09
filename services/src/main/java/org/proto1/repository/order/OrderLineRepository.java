/*******************************************************************************
 * Copyright (c) 2015 Valentin Pogrebinsky
 * All rights reserved. 
 *******************************************************************************/
package org.proto1.repository.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.proto1.domain.order.OrderLine;
import org.proto1.domain.product.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderLineRepository extends CrudRepository<OrderLine, Long> {
	
	@Query("select new Map(ol.id as olId, ol.qnty as olQnty, ol.price as olPrice, ol.amount as olAmount, pn.name as productName, uomn.shortName as uomName) "
			+ "from OrderLine ol join ol.product p join p.productNames pn join ol.unitOfMeasurement uom join uom.unitOfMeasurementNames uomn "
			+ "where pn.language.id = :language_id and uomn.language.id = :language_id and ol.order.id =:order_id")
	
	public List<Map<String, Object>> getOrderLineList(@Param("language_id") Long languageId, @Param("order_id") Long orderId);
	
	public List<OrderLine> getListByProductId(Long productId);
	
	@Query("select new Map(olp.parameter.id as pid, olp.value as pvalue,  olp.unitOfMeasurement.id as uomId, uomn.shortName as uomName) "
			+ "from OrderLine ol join ol.orderLineParameterList olp left outer join olp.unitOfMeasurement.unitOfMeasurementNames uomn "
			+ "where olp.parameter.id in :param_list and ol.id = :order_line_id and (uomn.language.id = :language_id or uomn.language.id is null)")
	public List<Map<String, Object>> getParametersValues(@Param("param_list") Long[] parameterList, @Param("order_line_id") Long orderLineId,
			@Param("language_id") Long languageId);
	
	@Query("select new Map(ol.id as id, ol.qnty as qntyu) "
			+ "from OrderLine ol where ol.product.id=:product_id")
	public List<Map<String, Object>> getLBPID(@Param("product_id") Long productId);

}

