package magento.eav

class EntityType {

	String code

	String entityModel
	String attributeModel

	String entityTable

	static hasMany = [attributes: Attribute]

	String toString() {
		"EntityType[$id]($code)"
	}

	static constraints = {
		code()
		entityModel()
		attributeModel()
		entityTable()
	}

	static mapping = {
		table 'eav_entity_type'

		id column: 'entity_type_id', sqlType: 'smallint(5) unsigned'

		code column: 'entity_type_code'

		version false
	}

}
