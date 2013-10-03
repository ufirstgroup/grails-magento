package magento

class OrderAddress {

	Order order
	Customer customer
//	CustomerAddress customerAddress

	String type

	String firstname
	String lastname
	String street
	String postcode
	String city
	String country

	String telephone
	String email

	String toString() {
		"OrderAddress[$id]($type, $firstname, $lastname, $street, $postcode, $city, $country)"
	}

	static constraints = {
		order()
		customer nullable: true
	}

	static mapping = {
		table   'sales_flat_order_address'

		id column: 'entity_id', sqlType: 'int(10) unsigned'

		country         column: 'country_id', sqlType: 'char(2)'
		customer        sqlType: 'int(10) unsigned'
		customerAddress sqlType: 'int(10)'
		order           column: 'parent_id', sqlType: 'int(10) unsigned'
		type            column: 'address_type'

		version false
	}
}
