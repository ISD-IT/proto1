/**
 * File request.js
 * Created 12/06/15
 * Author Valentin Pogrebinsky
 * TODO form plugin post injection
 */

var RequestMod = (function() {
	function RequestOrder() {
		
	};
	
	function initRequest () {
		console.log("initRequest");
		
		$.getScript("/protofront/scripts/order/ordermod.js")
			.done(function() {
				console.log("OrderMod loaded");
				OrderMod.init({
					url : '/protofront/service/requests/',
					onLoad : function() {
						$("#orderDetails").panel({
							href : '/protofront/forms/requestOrder.html',
							onLoad : function() {
								 
								$("#test").on("orderSelected", function(event, orderId){
									if (typeof orderId !== 'undefined') {
										$("#req").form('load', '/protofront/service/requests/' + orderId + '?languageId=' +  IndexLib.lang());
									}
								});
								
								$("#test").on("savePressed", function(event) {
									$("#req").form('submitAjax', {
										url : "/protofront/service/requests/?languageId=" + IndexLib.lang(),
										success:function(data){
									    	var row = $("#edgOrder").edatagrid('getSelected');
									    	var index = $("#edgOrder").edatagrid('getRowIndex', row);
									    	
									    	$("#req").form('load', data);
									    	$("#edgOrder").edatagrid('updateRow', {
									    		index : index,
									    		row : data});
									    } // Success
									});
								});
								$("#test").on("addPressed", function(event) {
									$("#req").form('clear');
								});
								$("#isdate").datebox({
									
									formatter:IndexLib.dateFormatter,
									
									parser:IndexLib.dateParser

								});
								$("#orgUnit").combobox({
									data : ClientRepo.getOrgUnitList(),
									valueField : 'id',
									textField : 'name'
								});
							},
							onLoadError : function(msg) {
								console.log('Error');
								console.log(msg);
							}
						});
					}
				});
			})
			.fail(function( jqxhr, settings, exception ) {
				console.log(exception);
			});
	};
	
	return {
		init : initRequest
	};
})();

RequestMod.init();

