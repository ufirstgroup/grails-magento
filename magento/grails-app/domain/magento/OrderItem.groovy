package magento

class OrderItem implements Comparable {

	Date dateCreated
	Date lastUpdated

	Store store
	Order order

	Integer productId
	String  productType
	String  sku
	String  name

	OrderItem parentItem

	Integer quantityOrdered

	// Not relevant
	//Integer quantityInvoiced
	//Integer quantityCanceled
	Integer quantityRefunded
	Integer quantityShipped

	BigDecimal erpPrice
	BigDecimal originalPrice
	BigDecimal price

	BigDecimal erpTotal
	BigDecimal total
	//BigDecimal totalInvoiced
	// Strange value
	//BigDecimal discount

	static belongsTo = [order: Order, parentItem: OrderItem]
	static hasMany   = [childItems: OrderItem]

	String toString() {
		"OrderItem[$id]($sku, quantity:$quantityOrdered, total:$total, $name)"
	}

	int compareTo(obj) {
		id.compareTo(obj.id)
	}

	static constraints = {
		order()
		sku()
		productId()
		productType()
		name()
		erpPrice()
		originalPrice()
		price()
		quantityOrdered()
		erpTotal()
		total()
		//discount()
		//quantityInvoiced()
		//quantityCanceled()
		quantityRefunded()
		quantityShipped()
	}

	static mapping = {
		table   'sales_flat_order_item'

		id column: 'item_id', sqlType: 'int(10) unsigned'

		dateCreated      column: 'created_at'
		discount         column: 'base_discount_amount'
		lastUpdated      column: 'updated_at'
		erpPrice         column: 'original_erp_price'
		erpTotal         column: 'original_erp_row_total'
		order            sqlType: 'int(10) unsigned'
		originalPrice    column: 'base_original_price'
		parentItem       sqlType: 'int(10) unsigned'
		price            column: 'base_price_incl_tax'
		product          sqlType: 'int(10) unsigned'
		quantityOrdered  column: 'qty_ordered',  sqlType: 'decimal(12,4)'
		quantityInvoiced column: 'qty_invoiced', sqlType: 'decimal(12,4)'
		quantityCanceled column: 'qty_canceled', sqlType: 'decimal(12,4)'
		quantityRefunded column: 'qty_refunded', sqlType: 'decimal(12,4)'
		quantityShipped  column: 'qty_shipped', sqlType: 'decimal(12,4)'
		store            sqlType: 'smallint(5) unsigned'
		total            column: 'base_row_total_incl_tax'
		totalInvoiced    column: 'base_row_invoiced'

		version false
	}

}
