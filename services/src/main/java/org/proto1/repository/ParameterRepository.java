/*******************************************************************************
 * Copyright (C) 2015  Valentin Pogrebinsky
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
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *******************************************************************************/
package org.proto1.repository;

import java.util.List;
import java.util.Map;

import org.proto1.domain.product.Parameter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ParameterRepository extends CrudRepository<Parameter, Long> {
	@Query("select new Map(p.id as parameterId, p.type as parameterType , pn.name as parameterName) " + 
			"from Parameter p join p.parameterNames pn  " + 
			"where pn.language.id = :language_id")
	public List<Map<String, Object>> getList(@Param("language_id") Long languageId);

	@Query("SELECT p FROM Parameter p LEFT JOIN FETCH p.acceptedUOM WHERE p.id = (:id)")
	public Parameter getEagerly(@Param("id") Long id);
	
}
