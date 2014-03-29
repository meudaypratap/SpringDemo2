package com.spring3.test

import com.test.Student
import grails.plugin.springcache.annotations.CacheFlush
import grails.plugin.springcache.annotations.Cacheable

class StudentService {

   // @Cacheable(cache="studentCache")
    List<Student> getListDataValue() throws  Exception{
        println("=====Service method call. Not from cache=======")
        List<Student> list= Student.list()
        return list
    }

    @Cacheable(cache="studentCache")
    Student showStudent(long id){
        println("=====Service method call For showing user id::::${id} . Not from cache=======")
        return Student.get(id)
    }

    @Cacheable(cache="studentCache")
    List<Student> getListData() throws  Exception{
        println("=====Service method call for showing list of users. Not from cache=======")
        List<Student> list= Student.list()
        return list
    }

    @CacheFlush("studentCache")
    void cacheRemove(){
        println("Cache Removed")
    }

    Student saveDataStudent(Student student) throws Exception{
        return student.save(flush: true,failOnError: true)
    }

    Student saveDataUpdated(Student student){
        return student.save(flush: true,failOnError: true)
    }
}
