package magento

class Payment {

	Order order

	String method

	BigDecimal amountOrdered
	BigDecimal amountPaid
	BigDecimal amountRefunded

	static belongsTo = [order: Order]
	static hasMany = [transactions: Transaction]

	String toString() {
		"Payment[$id]($method, paid: $amountPaid, refunded: $amountRefunded)"
	}

	static constraints = {
		order()
		method()
	}

	static mapping = {
		table 'sales_flat_order_payment'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		amountOrdered  column: 'base_amount_ordered'
		amountPaid     column: 'base_amount_paid'
		amountRefunded column: 'base_amount_refunded'
		order          column: 'parent_id', sqlType: 'int(10) unsigned'

		version false
	}

}
