package magento

class CustomerGroup {

	String code

	String toString() {
		"CustomerGroup($code)"
	}

	static mapping = {
		id column: 'customer_group_id', sqlType: 'smallint(3) unsigned'
		code column: 'customer_group_code'

		version false
	}

}
