package magento

class StoreGroup {

	String name

	Website website

	static hasMany = [stores: Store]

	String toString() {
		"StoreGroup[$id]($name)"
	}

	static mapping = {
		table 'core_store_group'

		id column: 'group_id', sqlType: 'smallint(5) unsigned'
		website sqlType: 'smallint(5) unsigned'

		version false
	}

}
