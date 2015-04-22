package org.proto1.services.order;

import org.proto1.domain.order.PurchaseOrder;

public interface PurchaseOrderService extends BaseOrderService {

	/**
	 * @param po
	 * @return
	 */
	PurchaseOrder save(PurchaseOrder purchaseOrder);

}