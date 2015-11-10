/*******************************************************************************
 * Copyright (C) 2015   Valentin Pogrebinsky 
 *
 * mail:pva@isd.com.ua
 * https://github.com/bbones
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * GNU v2 license text in root directory of project
 *******************************************************************************/
package org.proto1.repository.order;

import java.util.List;
import java.util.Map;

import org.proto1.domain.order.SalesOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SalesOrderRepository extends BaseOrderRepository<SalesOrder> {
	@Query("select new Map(so.id as id, so.documentNo as documentNo, so.issueDate as issueDate, coalesce(pn.lastName, en.name) as customerName) " +
			"from SalesOrder so	join so.contractSupplement cs join cs.contract c join c.contractSides csides " + 
			"join csides.party p left join p.personNames pn	left join p.enterpriseNames en " +
			"where ((pn.language.id = :language_id) or (en.language.id = :language_id)) and csides.sideRole.id = :siderole_id")
	public List<Map<String, Object>> getListByLanguageId(@Param("language_id") Long languageId, @Param("siderole_id") Long sideRoleId);

}
