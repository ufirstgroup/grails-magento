package magento

class ProductImage {

	Product product

	String value

	String toString() {
		"Product[${product.id}]Image[$id]($value)"
	}

	static mapping = {
 		datasource 'ALL'
		table 'catalog_product_entity_media_gallery'

		id column: 'value_id', sqlType: 'int(11) unsigned'
		product column: 'entity_id', sqlType: 'int(10) unsigned'

		version false
	}

}
