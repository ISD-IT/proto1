/*******************************************************************************
 * Copyright (c) 2015 Valentin Pogrebinsky
 * All rights reserved. 
 *******************************************************************************/
/**
 * 
 */

var ProductLib = (function(){
	
	
	function initProductTypeTree() {
		$("#productType").combotree({
			onSelect : function(record) {
				console.log(record);
				$("#edgProducts").edatagrid({
					url : '/protofront/service/products/types?productTypeId='
									+ record.id + '&languageId=' + IndexLib.lang(),
					saveUrl : '/protofront/service/products/?typeId=' + record.id + '&languageId=' + IndexLib.lang()
				}); // edatagrid
			}// OnSelect
		}); // Combotree
	}
	
	function initProductGrid() {
		$("#edgProducts").edatagrid({
			method : "GET",
			toolbar : IndexLib.edgmenu({
				add : function(){
					$("#edgProducts").edatagrid('addRow', {row : {productTypeId : $("#productType").combotree('getValue')}});
				},
				save : function(){
					$("#edgProducts").edatagrid('saveRow');
				},
				destroy : function(){
					$("#edgProducts").edatagrid('destroyRow');
				}

			}),

			onSelect : function(index, row) {
				console.log(row);
				if (row.productId != null) {
					$("#edgNames").edatagrid({
						url : '/protofront/service/products/'
									+ row.productId + '/names'
					});
	
					$("#edgParameters").edatagrid({
						url : '/protofront/service/products/'+ row.productId + 
							'/parameters?languageId=' + IndexLib.lang(),
					});
				}
			}, // OnSelect
			onDestroy : function(index,row){
				$.ajax({
					url : '/protofront/service/products/' + row.productId,
					method : "DELETE"
				});
			}

		});
	}
	
	function  initNameGrid() {
		$("#edgNames").edatagrid({
			method : 'GET',
			saveUrl : '/protofront/service/products/names',
			updateUrl : '/protofront/service/products/names',
			toolbar : IndexLib.edgmenu({
				add : function(){
					$("#edgNames").edatagrid('addRow', {row : {productId : $("#edgProducts").edatagrid('getSelected').productId}});
				},
				save : function(){
					$("#edgNames").edatagrid('saveRow');
				},
				destroy : function(){
					$("#edgNames").edatagrid('destroyRow');
				}

			}),
			onDestroy : function(index,row){
				$.ajax({
					url : '/protofront/service/products/names' + row.nameId,
					method : "DELETE"
				});
			}

		});
	}
	
	function initParameterGrid() {
		$("#edgParameters").edatagrid({
			method : 'GET',
			saveUrl : '/protofront/service/products/parameters' + '?languageId=' + IndexLib.lang(),
			updateUrl : '/protofront/service/products/parameters' + '?languageId=' + IndexLib.lang(),
			toolbar : IndexLib.edgmenu({
				add : function(){
					$("#edgParameters").edatagrid('addRow', {row : {productId : $("#edgProducts").edatagrid('getSelected').productId}});
				},
				save : function(){
					$("#edgParameters").edatagrid('saveRow');
				},
				destroy : function(){
					$("#edgParameters").edatagrid('destroyRow');
				}

			}),
			onDestroy : function(index,row){
				$.ajax({
					url : '/protofront/service/products/parameters/' + row.productParameterId,
					method : "DELETE"
				});
			}

		});
	}
	
	
	return {
		init : function() {
			initProductTypeTree();
			initProductGrid();
			initNameGrid();
			initParameterGrid();
		},
		append : function() {
			$("#edgProducts").edatagrid('addRow', {
				row :{
					productTypeId : $("#productType").combotree('getValue')
				}
			});
		},
		save : function() {
			$("#edgProducts").edatagrid('saveRow');
		},
		
		appendName : function() {
			$("#edgNames").edatagrid('addRow', {
				row : {
					productId : $("#edgProducts").edatagrid('getSelected').productId
				}
			});
		},
		
		saveName : function() {
			$("#edgNames").edatagrid('saveRow');
		},
	
		removeName : function () {
			$("#edgNames").edatagrid('destroyRow');
		},
	
		removeParameter: function () {
			$("#edgParameters").edatagrid('destroyRow');
		},

		appendParameter : function () {
			var pid = $("#edgProducts").edatagrid('getSelected').id;
			$("#edgParameters").edatagrid('addRow', {
				row: {
					productId : $("#edgProducts").edatagrid('getSelected').productId,
					required :false
				}
			});
		},
	
		acceptParameter : function () {
			console.log($("#edgParameters").edatagrid('getSelected'));
			$("#edgParameters").edatagrid('saveRow');
		}
	}  //return
})();

