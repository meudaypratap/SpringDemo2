package com.spring3.base.test

import com.test.LogException
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.ProceedingJoinPoint
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import org.aspectj.lang.annotation.*

@Aspect
@Component
class LoggerInterceptor {

    @Pointcut("within(com.spring3.test..*)")
    private void anyMethodInGivenPackage() {
    }

    @Pointcut("execution(* com.spring3.test..saveData* (..))")
    private void saveDataMethod() {

    }

    @Pointcut("execution(* com.spring3.test..*.*(..))")
    private void executionAnyMethodInTestPackage() {

    }

    @Pointcut("execution(* com.spring3.test..*.get*(..))")
    private void executionAnyGetterInTestPackage() {

    }


    @Before("saveDataMethod()")
    public void logBefore(JoinPoint joinPoint) {
        String logMessage = String.format("Beginning method: %s.%s(%s)",
                joinPoint.target.class.name,
                joinPoint.signature.name,
                Arrays.toString(joinPoint.args))

        println(logMessage)
    }

    //@After("executionAnyMethod()")
    public void logAfter(JoinPoint joinPoint) {
        String logMessage = String.format("After method: %s.%s(%s)",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()))

        println(logMessage)
    }


      //  @AfterReturning(pointcut = "within(com.spring3.test..*)", returning = "retVal")
    public void logAfterReturning(JoinPoint joinPoint, Object retVal) {

        String logMessage = String.format("Method Returning method: %s.%s(%s)",
                joinPoint.target.class.name,
                joinPoint.signature.name,
                Arrays.toString(joinPoint.args))

        println "Result:::::" + retVal


        println(logMessage)
    }

    //@AfterReturning(pointcut = "execution(* com.spring3.test..*.getList*(..))", returning = "retVal")
    public void logAfterReturningGetter(JoinPoint joinPoint, Object retVal) {

        String logMessage = String.format("Method Returning Value method: %s.%s(%s)======(%s)",
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()), retVal)

        if (!joinPoint.getTarget().getClass().isInstance(MetaClass))
            println(logMessage)
    }


    /**
     * Exception Handling
     */
    //@AfterThrowing(pointcut = "execution(* com.spring3.test..saveData* (..))", throwing = "ex")
    public void errorInterceptor(JoinPoint joinPoint, Exception ex) {
        LogException logException = new LogException()
        logException.data = joinPoint.getArgs()
        logException.message = ex.message
        logException.exception = "excpetion"
        logException.save(flush: true, failOnError: true)

    }

}
