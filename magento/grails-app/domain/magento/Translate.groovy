package magento

class Translate {

	String key

	String translate
	String locale

	Store store

	static mapping = {
		table 'core_translate'

		id column: 'key_id', sqlType: 'int(10) unsigned'
		key column: 'string'
		store sqlType: 'smallint(5) unsigned'

		version false
	}

}
