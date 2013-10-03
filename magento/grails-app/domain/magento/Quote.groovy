package magento

class Quote {

	Date dateCreated
	Date lastUpdated

	Store store
	Customer customer

	Boolean active

	SortedSet items

	// doesn't belong to customer because customer can be null
	static belongsTo = [store: Store]
	static hasMany = [items: QuoteItem]

	String toString() {
		"Quote[$id](active:$active)"
	}

	static constraints = {
		dateCreated()
		customer nullable: true
	}

	static mapping = {
		table   'sales_flat_quote'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		active         column: 'is_active', sqlType: 'smallint(5) unsigned'
		customer       sqlType: 'int(10) unsigned'
		dateCreated    column: 'created_at'
		lastUpdated    column: 'updated_at'
		store          sqlType: 'smallint(5) unsigned'

		version false
	}

}
