/*******************************************************************************
 * Copyright (c) 2015 Valentin Pogrebinsky
 * All rights reserved. 
 *******************************************************************************/
package org.proto1.repository.party;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.proto1.domain.party.Enterprise;

public interface EnterpriseRepository extends CrudRepository<Enterprise, Long>, JpaSpecificationExecutor<Enterprise> {

	@Query("select new Map(e.id as id, en.name as name) " + 
			"from Enterprise e left outer join e.enterpriseNames en  " + 
			"where en.language.id = :language_id")
	public List<Map<String, Object>> getListByLanguageId(@Param("language_id") Long languageId);

	@Query("select count(e)"
			+ "from Enterprise e join e.enterpriseNames en  "
			+ "where (en.language.id=:language_id) and (en.name like :srch)")
	public Long getEnterpriseCounter(@Param("language_id") Long languageId, @Param("srch") String searchStr);
	
	@Query("select new Map(e.id as id, en.name as name) " + 
			"from Enterprise e join e.enterpriseNames en  " +
			"where (en.language.id=:language_id) and (en.name like :srch)")
	public List<Map<String, Object>> partyList(@Param("language_id") Long languageId, @Param("srch") String searchStr, Pageable p);
	
}
