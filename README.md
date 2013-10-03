grails-magento
==============

Grails plugin for Magento

you can use the domain classes to interact with a Magento DB, for example:

```
$ grails shell
groovy:000> magento.ConfigData.findByPathAndScopeId('general/locale/timezone', 0).value
===> Australia/Darwin
groovy:000> magento.Website.list().each { println(it) }
Website[0](Admin)
Website[1](Test 1)
Website[2](Test 2)
===> [Website[0](Admin), Website[1](Test 1), Website[2](Test 2)]
```

have a look at the classes in grails-app/domain/magento/
