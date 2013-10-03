package magento

class Resource {

	String code
	// version has a special meaning for GORM
	// String version
	String dataVersion

	static mapping = {
		table 'core_resource'

		id name: 'code'

		version false
	}

}
