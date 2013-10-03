package magento

class Invoice {

	Date dateCreated
	Date lastUpdated

	Order order
	Store store

	BigDecimal erpTotal
	BigDecimal shipping
	BigDecimal total
	// BigDecimal discount

	String currency
	String transactionCode

	OrderAddress billingAddress
	OrderAddress shippingAddress

	static belongsTo = [order: Order]
	static hasMany = [creditMemos: CreditMemo]

	String toString() {
		"Invoice[$id]($total, $transactionCode)"
	}

	static constraints = {
		order()
		dateCreated()
		erpTotal()
		shipping()
		total()
		currency()
		transactionCode()
		creditMemos()
		lastUpdated()
		billingAddress()
		shippingAddress()
	}

	static mapping = {
		table 'sales_flat_invoice'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		billingAddress  sqlType: 'int(10)'
		currency        column: 'base_currency_code', sqlType: 'char(3)'
		dateCreated     column: 'created_at'
		discount        column: 'base_discount_amount'
		erpTotal        column: 'original_erp_total'
		lastUpdated     column: 'updated_at'
		order           sqlType: 'int(10) unsigned'
		store           sqlType: 'smallint(5) unsigned'
		shipping        column: 'base_shipping_incl_tax'
		shippingAddress  sqlType: 'int(10)'
		total           column: 'base_grand_total'
		transactionCode column: 'transaction_id'

		version false
	}

}
