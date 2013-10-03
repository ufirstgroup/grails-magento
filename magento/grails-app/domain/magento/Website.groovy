package magento

class Website {

	String code
	String name

	Boolean defaultSite
	Boolean staging

	String masterLogin
	String masterPassword

	String visibility

	StoreGroup defaultStoreGroup
	static hasMany = [storeGroups: StoreGroup, stores: Store]

	String toString() {
		"Website[$id]($name)"
	}

	static mapping = {
		table 'core_website'

		id column: 'website_id', sqlType: 'smallint(5) unsigned'
		defaultStoreGroup column: 'default_group_id', sqlType: 'smallint(5) unsigned'
		defaultSite column: 'is_default', sqlType: 'smallint(5) unsigned'
		staging column: 'is_staging'

		version false
	}

}
