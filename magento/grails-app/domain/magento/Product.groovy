package magento

class Product {

	String sku
	String type

	static hasMany = [images: ProductImage]

	Date dateCreated
	Date lastUpdated

	def getFormatedSku() {
		SKU.format(sku)
	}

	String toString() {
		"Product[$id]($sku, $type)"
	}

	static mapping = {
		datasource 'ALL'
		table 'catalog_product_entity'

		id column: 'entity_id', sqlType: 'int(10) unsigned'
		type column: 'type_id'
		dateCreated column: 'created_at'
		lastUpdated column: 'updated_at'

		version false
	}
}
