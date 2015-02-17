package org.proto1.repository.order;

import java.util.List;
import java.util.Map;

import org.proto1.domain.order.SalesOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SalesOrderRepository extends CrudRepository<SalesOrder, Long> {
	@Query("select so.id as soId, csides.party.id as partyId, csides.sideRole.id as roleId, coalesce(pn.lastName, en.name) as name " +
			"from SalesOrder so	join so.contractSupplement cs join cs.contract c join c.contractSides csides " + 
			"join csides.party p left join p.personNames pn	left join p.enterpriseNames en " +
			"where ((pn.language.id = :languageId) or (en.language.id = :language_id)) and csides.sideRole.id = :siderole_id")
	public List<Map<String, Object>> getListByLanguageId(@Param("language_id") Long languageId, @Param("siderole_id") Long sideRoleId);

}
