package magento

class Subscriber {

	Integer storeId
	Integer customerId
	String  email
	Integer status
	String  confirmCode
	Date    statusChanged

	// Customer customer

	static constraints = {
		statusChanged nullable: true
		confirmCode   nullable: true
	}

	static mapping = {
		table 'newsletter_subscriber'

		id column: 'subscriber_id', sqlType: 'int(7) unsigned'

		storeId sqlType: 'smallint(5) unsigned'
		email column: 'subscriber_email'
		status column: 'subscriber_status'
		confirmCode column: 'subscriber_confirm_code'
		statusChanged column: 'change_status_at'
		customerId sqlType: 'int(11) unsigned'

		version false
	}

}
