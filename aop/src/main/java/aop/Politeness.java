package aop;

import model.Customer;
import model.Squishee;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Politeness {

    @Pointcut("execution(* sellSquishee(..))")
    private void sellSquishee(){}

    @Before("sellSquishee()")
    public void sayHello(JoinPoint joinPoint){
        AopLog.append(String.format("Hello, %s. How are you doing?\n", ((Customer)joinPoint.getArgs()[0]).getName()));
    }

    @AfterReturning(pointcut = "sellSquishee()", returning = "retVal", argNames = "retVal")
    public void askOpinion(Object retVal) {
        AopLog.append(String.format("Is %s Good Enough?\n", ((Squishee) retVal).getName()));
    }

    /*@Before("execution(* sellSquishee(..))")
    public void sayHello(JoinPoint joinPiont) {
        AopLog.append("Hello " + ((Customer) joinPiont.getArgs()[0]).getName() + ". How are you doing? \n");
    }

    @AfterReturning(pointcut = "execution(* sellSquishee(..))",
            returning = "retVal", argNames = "retVal")
    public void askOpinion(Object retVal) {
        AopLog.append("Is " + ((Squishee) retVal).getName() + " Good Enough? \n");
    }*/

    @AfterThrowing("sellSquishee()")
    public void sayYouAreNotAllowed() {
        AopLog.append("Hmmm... \n");
    }

    @After("sellSquishee()")
    public void sayGoodBye() {
        AopLog.append("Good Bye!\n");
    }

    @Around("sellSquishee()")
    public Object sayPoliteWordAndSell(ProceedingJoinPoint pjp) throws Throwable {
        AopLog.append("Hi!\n");
        Object retVal = pjp.proceed();
        AopLog.append("See you!\n");
        return  retVal;
    }

}