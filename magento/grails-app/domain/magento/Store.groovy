package magento

class Store {

	String code
	String name

	Boolean active

	StoreGroup group
	Website website

	// too many customers
	static hasMany = [/*customers: Customer, */orders: Order]

	String toString() {
		"Store[$id]($website.name, $group.name, $name, $code)"
	}

	static constraints = {
		active()
		code()
		name()
		group()
		website()
		// too many customers
		//customers()
		orders()
	}


	static mapping = {
		table 'core_store'

		id column: 'store_id', sqlType: 'smallint(5) unsigned'
		active column: 'is_active', sqlType: 'smallint(5) unsigned'
		group sqlType: 'smallint(5) unsigned'
		website sqlType: 'smallint(5) unsigned'

		version false
	}

}
