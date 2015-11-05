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
package org.proto1.mapper;

import org.dozer.DozerConverter;
import org.proto1.domain.product.ProductType;
import org.proto1.services.product.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LongProductTypeConverter extends DozerConverter<Long, ProductType> {

	@Autowired
	ProductTypeService productTypeService;
	
	public LongProductTypeConverter() {
		super(Long.class, ProductType.class);
	}

	@Override
	public ProductType convertTo(Long source, ProductType destination) {
		return productTypeService.get(source);
	}

	@Override
	public Long convertFrom(ProductType source, Long destination) {
		return source != null ? source.getId() : null;
	}

}
