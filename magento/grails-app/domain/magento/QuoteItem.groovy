package magento

class QuoteItem implements Comparable {

 	Date dateCreated
	Date lastUpdated

	Store store
	Quote quote

	Integer productId
	String  productType
	String  sku
	String  name

	Integer quantity

	BigDecimal price
	// BigDecimal originalPrice
	BigDecimal total

	static belongsTo = [quote: Quote]

	String toString() {
		"QuoteItem[$id]($sku, product_id:$productId, quantity:$quantity, total:$total, $name)"
	}

	int compareTo(obj) {
		id.compareTo(obj.id)
	}

	static constraints = {
		quote()
		sku()
		productId()
		productType()
		name()
		price()
		quantity()
		total()
	}

	static mapping = {
		table   'sales_flat_quote_item'

		id column: 'item_id', sqlType: 'int(10) unsigned'

		dateCreated      column: 'created_at'
		lastUpdated      column: 'updated_at'
		quote            sqlType: 'int(10) unsigned'
		// originalPrice    column: 'base_original_price'
		parentItem       sqlType: 'int(10) unsigned'
		price            column: 'base_price'
		product          sqlType: 'int(10) unsigned'
		quantity         column: 'qty',  sqlType: 'decimal(12,4)'
		store            sqlType: 'smallint(5) unsigned'
		total            column: 'base_row_total'

		version false
	}

}
