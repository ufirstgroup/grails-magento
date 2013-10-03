package magento

class AdminUser {

	String firstname
	String lastname
	String email

	String username
	String password

	boolean active
	Date lastLogin
	int loginCount
	int loginFailedCount

	Date dateCreated
	Date lastUpdated

	static constraints = {
	}

	static mapping = {
		id column: 'user_id', sqlType:'int(10) unsigned'
		active column: 'is_active', sqlType:'smallint(6)'
		lastLogin column: 'logdate'
		loginCount column: 'lognum', sqlType:'smallint(5) unsigned'
		loginFailedCount column: 'failures_num', sqlType:'smallint(5) unsigned'
		dateCreated column: 'created'
		lastUpdated column: 'modified'

		version false
	}

}
