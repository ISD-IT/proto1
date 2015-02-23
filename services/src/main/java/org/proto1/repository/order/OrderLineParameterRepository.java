package org.proto1.repository.order;

import java.util.List;
import java.util.Map;

import org.proto1.domain.order.OrderLineParameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderLineParameterRepository extends CrudRepository<OrderLineParameter, Long> {
	
	@Query("select new Map(olp.id as olpId, olp.value as olpValue, p.id as paramId, pn.name as paramName, du.id as duId, dun.shortName as duName) "
			+ "from OrderLineParameter olp join olp.parameter p join p.parameterNames pn "
			+ "left join olp.dimensionUnit du left join du.dimensionUnitNames dun "
			+ "where olp.orderLine.id = :ol_id and pn.language.id = :language_id and (dun.language.id = :language_id or dun.language.id is null)")
	public List<Map<String, Object>> getOrderLineParameters(@Param("language_id") Long languageId, @Param("ol_id") Long orderLineId);

}

/* getOrderLineParameters
select olp.id as olpId, olp.value as olpValue, p.id as paramId, pn.name as paramName, du.id as duId, dun.shortName as duName
from OrderLineParameter olp 
	join olp.parameter p join p.parameterNames pn 
	left join olp.dimensionUnit du left join du.dimensionUnitNames dun
where olp.orderLine.id = :ol_id and pn.language.id = :language_id and (dun.language.id = :language_id or dun.language.id is null)
*/