class MagentoGrailsPlugin {
    def version = "0.1"
    def grailsVersion = "2.0 > *"
    def pluginExcludes = [
        "web-app/**"
    ]

    def title = "Magento Plugin"
    def author = "Jean-Luc Geering"
    def authorEmail = "jeanluc.geering@ufirstgroup.com"
    def description = 'Domain, service, and controller classes to interact with a Magento DB.'
    def documentation = "http://grails.org/plugin/magento"

    def license = "APACHE"
    def organization = [ name: "UFirst Group", url: "http://www.ufirstgroup.com/" ]
    def issueManagement = [ system: "GITHUB", url: "https://github.com/ufirstgroup/grails-magento/issues" ]
    def scm = [ url: "https://github.com/ufirstgroup/grails-magento/" ]
}
