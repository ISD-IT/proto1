package org.proto1.repository;

import java.util.List;

import org.proto1.domain.party.EnterpriseName;
import org.springframework.data.repository.CrudRepository;

public interface EnterpriseNameRepository extends CrudRepository<EnterpriseName, Long> {
	
	List<EnterpriseName> getByEnterpriseId(Long enterpriseId);


}
