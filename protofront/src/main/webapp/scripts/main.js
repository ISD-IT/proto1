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
requirejs.config({
	'baseUrl' : 'scripts',
	'paths' : {
		'jquery' : '../lib/jquery-2.1.1',
		'easyui' : '../easyui/jquery.easyui.min',
		'edatagrid' : '../easyui/jquery.edatagrid',
		'datagrid.excel' : '../easyui/jquery.datagrid.excel',
		'easyui.form.ext' : 'plugins/jquery.form.ext',
		'easyui.grid.ext' : 'plugins/jquery.grid.ext',
		'serializeObject' : 'plugins/jquery.serializeObject',
		'searchcom' : 'plugins/jquery.searchcom',
		'app' : 'app',
		'language' : 'modules/language',
		'uomUtil' : 'modules/uom.util',
		'currencyUtil' : 'modules/currency.util',
		'commonlib' : 'modules/commonlib',
		'enterprise' : 'modules/enterprise',
		'orgUnitUtil' : 'modules/orgUnit.util',
		'person' : 'modules/person',
		'productType' : 'modules/productType',
		'product' : 'modules/product',
		'productUtil' : 'modules/product.util',
		'parameter' : 'modules/parameter',
		'parameterUtil' : 'modules/parameter.util',
		'orgunit' : 'modules/orgunit',
		'uom' : 'modules/uom',
		'contract' : 'modules/contract',
		'contract_' : 'modules/contract_',
		'railway' : 'modules/railway',
		'railwayWithSearch' : 'modules/railwayWithSearch',
		'ordermodel' : 'modules/order/ordermodel',
		'ordermod' : 'modules/order/ordermod',
		'request' : 'modules/order/request',
		'salesorder' : 'modules/order/salesorder',
		'demand' : 'modules/order/demand',
		'prodorder' : 'modules/order/prodorder',
		'purchaseorder' : 'modules/order/purchaseorder',
		'bom' : 'modules/order/bom'

	},
	shim : {
		'easyui' : {
			deps : [ 'jquery' ],
			exports : 'jquery'
		},
		'easyui.edatagrid' : {
			exports : 'jquery',
			deps : [ 'jquery', 'easyui' ]
		},
		'datagrid.excel' : {
			exports : 'jquery',
			deps : [ 'jquery', 'easyui' ]
		},
		'easyui.form.ext' : {
			exports : 'jquery',
			deps : [ 'jquery', 'easyui' ]
		},
		'serializeObject' : {
			exports : 'jquery',
			deps : ['jquery']
		},
		'searchcom' : {
			exports : 'jquery',
			deps : [ 'jquery', 'easyui' ]
		}
	}
});

var app = require([ 'app' ], function(app) {
	'use strict';

	app.init();
});
