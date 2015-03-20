/*******************************************************************************
 * Copyright (c) 2015 Valentin Pogrebinsky
 * All rights reserved. 
 *******************************************************************************/
/**
 * 
 */

var ProductionOrderLib = (function() {
	
	function initPOGrid() {
		$("#edgProdOrder").edatagrid({
			url : "/protofront/service/prodorder/listbylang/" +
				IndexLib.lang(),
			onSelect : function(index, row) {
				console.log(row);
				$("#edgLines").edatagrid({
					url : '/protofront/service/prodorder/lines/' + row.poId  + '&' +  IndexLib.lang(), 
					onSelect : function(index, row) {
						console.log(row);
						$("#edgLineParameters").edatagrid({
							url : '/protofront/service/prodorder/lineparameters/' +  row.olId + '&' + IndexLib.lang()
								
						});
					} // OnSelect edgLines
	
				});
			} // OnSelect edgProdOrder
		});
	};
	
	function initPOLinesGrid() {
		$("#edgLines").edatagrid({});
	}
	
	function initPOLineParam() {
		$("#edgLineParameters").edatagrid();
	}

	return {
		init : function() {
			initPOGrid();
			initPOLinesGrid();
			initPOLineParam();
		},
		addBOMs : function() {
			$.ajax('/protofront/service/prodorder/createOrderBOMs').onSuccess(function() {
				alert("Success!")
			});
		}
	};
})();

