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
package org.proto1.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.proto1.domain.accounting.AnaliticRole;

@Entity
public class Analitic {
	@Id
	private Long id;
	
	private Class<Identified> clazz;
	
	@ManyToOne
	private AnaliticRole analiticRole;
	
	public Analitic() {
		
	}
	
	@SuppressWarnings("unchecked")
	public Analitic(Identified obj) {
		clazz = (Class<Identified>) obj.getClass();
	}
	
	public Class<Identified> getAnaliticClass() {
		return clazz;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AnaliticRole getAnaliticRole() {
		return analiticRole;
	}

	public void setAnaliticRole(AnaliticRole analiticRole) {
		this.analiticRole = analiticRole;
	}
	
}
