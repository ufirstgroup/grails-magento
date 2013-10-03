package magento

class CreditMemo {

	Date dateCreated
	Date lastUpdated

	Store store

	Order order
	Invoice invoice

	BigDecimal erpTotal
	BigDecimal shipping
	BigDecimal total
	// BigDecimal discount

	String currency
	String transactionCode

	OrderAddress billingAddress
	OrderAddress shippingAddress

	static belongsTo = [order: Order, invoice: Invoice]

	Transaction getTransaction() {
		if (transactionCode) {
			return Transaction.findByCode(transactionCode)
		}
	}

	String toString() {
		if (transactionCode) {
			return "CreditMemo[$id](online, $total, $transactionCode)"
		}
		else {
			return "CreditMemo[$id](offline, $total, $transactionCode)"
		}
	}

	static constraints = {
		order()
		invoice()
		dateCreated()
		erpTotal()
		shipping()
		total()
		currency()
		transactionCode()
		billingAddress()
		shippingAddress()
	}

	static mapping = {
		table 'sales_flat_creditmemo'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		billingAddress  sqlType: 'int(10)'
		currency        column: 'base_currency_code', sqlType: 'char(3)'
		dateCreated     column: 'created_at'
		discount        column: 'base_discount_amount'
		lastUpdated     column: 'updated_at'
		order           sqlType: 'int(10) unsigned'
		invoice         sqlType: 'int(10)'
		store           sqlType: 'smallint(5) unsigned'
		erpTotal        column: 'original_erp_total'
		shipping        column: 'base_shipping_incl_tax'
		shippingAddress sqlType: 'int(10)'
		total           column: 'base_grand_total'
		transactionCode column: 'transaction_id'

		version false
	}

}
