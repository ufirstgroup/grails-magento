package magento

class Order implements Comparable {

	Date dateCreated
	Date lastUpdated

	String state
	String status

	Store store
	Customer customer

	BigDecimal erpTotal
	BigDecimal subTotal
	BigDecimal shipping
	BigDecimal paidTotal
	BigDecimal refunded

	String currency
	String shippingDescription

	String customerFirstname
	String customerLastname
	String customerEmail

	SortedSet items
	SortedSet transactions
	SortedSet history

	// doesn't belong to customer because customer can be null
	static belongsTo = [store: Store]
	static hasMany = [items: OrderItem, payments: Payment, transactions: Transaction, creditMemos: CreditMemo, invoices: Invoice, history: OrderHistory, addresses: OrderAddress]

	String toString() {
		if (customer) {
			return "Order[$id](Customer: $customerFirstname $customerLastname)"
		}
		"Order[$id](Guest: $customerFirstname $customerLastname)"
	}

	int compareTo(obj) {
		dateCreated.compareTo(obj.dateCreated)
	}

	static constraints = {
		dateCreated()
		customerFirstname()
		customerLastname()
		customerEmail()
		customer nullable: true
		currency()
		erpTotal()
		items()
		subTotal()
		shippingDescription()
		shipping()
		paidTotal()
		invoices()
		refunded()
		creditMemos()
		payments()
		transactions()
		history()
		state()
		status()
	}

	static mapping = {
		table   'sales_flat_order'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		code           column: 'txn_id'
		currency       column: 'base_currency_code', sqlType: 'char(3)'
		customer       sqlType: 'int(10) unsigned'
		dateCreated    column: 'created_at'
		erpTotal       column: 'original_erp_total'
		lastUpdated    column: 'updated_at'
		paidTotal      column: 'base_total_paid'
		parentCode     column: 'parent_txn_id'
		refunded       column: 'base_total_refunded'
		shipping       column: 'base_shipping_incl_tax'
		store          sqlType: 'smallint(5) unsigned'
		subTotal       column: 'base_subtotal_incl_tax'
		type           column: 'txn_type'

		version false
	}

}
