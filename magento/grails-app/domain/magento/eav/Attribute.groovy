package magento.eav

class Attribute {

	EntityType entityType

	String code
	String type

	static belongsTo = [entityType: EntityType]

	String toString() {
		"Attribute[$id]($code)"
	}

	static mapping = {
		table 'eav_attribute'

		id column: 'attribute_id', sqlType: 'smallint(5) unsigned'

		code column: 'attribute_code'
		entityType sqlType: 'smallint(5) unsigned'
		type column: 'backend_type', sqlType: "enum('static','datetime','decimal','int','text','varchar')"

		version false
	}

}
