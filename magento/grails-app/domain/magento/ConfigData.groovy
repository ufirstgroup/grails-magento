package magento

class ConfigData {

	// scope has sql type enum that hibernate doesn't like
	// String scope
	Integer scopeId

	String path
	String value

	static mapping = {
		table 'core_config_data'

		id column: 'config_id', sqlType: 'int(10) unsigned'
		value sqlType: 'text'

		version false
	}

}
