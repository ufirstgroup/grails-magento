package magento

class Transaction implements Comparable {

	Transaction parentTransaction

	Order order
	Payment payment

	String type
	String code
	String parentCode

	Date dateCreated

	String additionalInformation

	static belongsTo = [payment: Payment, parentTransaction: Transaction]
	static hasMany   = [childTransactions: Transaction]

	String toString() {
		"Transaction[$id]($payment.method, $type, $code)"
	}

	int compareTo(obj) {
		id.compareTo(obj.id)
	}

	static constraints = {
		order()
		payment()
		dateCreated()
		type()
		code()
		parentCode()
		parentTransaction()
		childTransactions()
	}

	static mapping = {
		table   'sales_payment_transaction'
		sort    'dateCreated'

		id          column: 'transaction_id', sqlType: 'int(10) unsigned'

		additionalInformation type: 'text', sqlType: 'blob'
		code              column: 'txn_id'
		dateCreated       column: 'created_at'
		order             sqlType: 'int(10) unsigned'
		parentTransaction column: 'parent_id', sqlType: 'int(10) unsigned'
		parentCode        column: 'parent_txn_id'
		payment           sqlType: 'int(10) unsigned'
		type              column: 'txn_type'

		version false
	}

}
