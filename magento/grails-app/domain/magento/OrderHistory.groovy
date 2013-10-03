package magento

class OrderHistory implements Comparable {

	Date dateCreated

	Order order

	String status
	String text

	String toString() {
		"$dateCreated ($status) $text"
	}

	int compareTo(obj) {
		id.compareTo(obj.id)
	}

	static constraints = {
		order()
		dateCreated()
		status()
		text()
	}

	static mapping = {
		table   'sales_flat_order_status_history'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		dateCreated     column: 'created_at'
		order           column: 'parent_id', sqlType: 'int(10) unsigned'
		status          column: 'status'
		text            column: 'comment', sqlType: 'text'

		version false
	}

}
