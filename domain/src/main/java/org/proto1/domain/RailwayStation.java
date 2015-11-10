/*******************************************************************************
 * Copyright (C) 2015   Serhiy Romaniuk 
 *
 * mail:rsk@isd.com.ua
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
package org.proto1.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RAILWAY_STATION")
public class RailwayStation extends AbstractEntity {
	@Column(name = "RAILWAY_STATION_CODE", nullable = false, length = 10)
	private String railwayStationCode;

	@ManyToOne(optional = false)
	private Railway railway;
	
	public Railway getRailway() {
		return railway;
	}

	public void setRailway(Railway railway) {
		this.railway = railway;
	}

	public String getRailwayStationCode() {
		return railwayStationCode;
	}

	public void setRailwayStationCode(String railwayStationCode) {
		this.railwayStationCode = railwayStationCode;
	}

}
