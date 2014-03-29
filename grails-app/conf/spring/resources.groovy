import org.springframework.cache.ehcache.EhCacheFactoryBean

// Place your Spring DSL code here
beans = {

    xmlns context: 'http://www.springframework.org/schema/context'
    xmlns aop: "http://www.springframework.org/schema/aop"

    context.'component-scan'('base-package': 'com.spring3.base.test')
    aop.config("proxy-target-class": true) {

    }

    // Eh cache configuration
/*    studentCache(EhCacheFactoryBean) { bean ->
        cacheManager = ref("springcacheCacheManager")
        cacheName = "studentCache"
        // these are just examples of properties you could set
        eternal = false
       // timeToLiveSeconds=10
        diskPersistent = false
        memoryStoreEvictionPolicy = "LRU"
    }*/

}
