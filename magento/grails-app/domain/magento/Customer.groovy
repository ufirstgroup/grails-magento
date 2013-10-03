package magento

class Customer {

	String email
	Boolean active

	Website website
	Store store
	CustomerGroup group

	//SortedSet orders

	//static hasMany = [orders: Order, quotes: Quote]

	String toString() {
		"Customer[$id]($email)"
	}

	static mapping = {
		table 'customer_entity'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		active column: 'is_active', sqlType: 'smallint(5) unsigned'
		group sqlType: 'smallint(3) unsigned'
		store sqlType: 'smallint(5) unsigned'
		website sqlType: 'smallint(5) unsigned'

		version false
	}

}
