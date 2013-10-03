package magento

class CronSchedule {

	String jobCode

	String status

	String messages

	Date createdAt
	Date scheduledAt

	// these 2 have a default value of 0000-00-00 00:00:00 which make GORM very unhappy
	// Date executedAt
	// Date finishedAt

	static mapping = {
		id column: 'schedule_id', sqlType: 'int(10) unsigned'
		status sqlType: "enum('pending','running','success','missed','error')"
		messages sqlType: 'text'

		version false
	}

}
