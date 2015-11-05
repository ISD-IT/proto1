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
/**
 * PurchaseOrderDTO.java
 * @author Valentin Pogrebinsky (pva@isd.com.ua)
 * Created Apr 20, 2015
 */
package org.proto1.dto.order;


/**
 * @author Valentin Pogrebinsky (pva@isd.com.ua)
 *
 */
public class PurchaseOrderDTO extends OrderDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1075550355225583741L;
	
	private Long contractSupplementId;

	public Long getContractSupplementId() {
		return contractSupplementId;
	}

	public void setContractSupplementId(Long contractSupplementId) {
		this.contractSupplementId = contractSupplementId;
	}

}
