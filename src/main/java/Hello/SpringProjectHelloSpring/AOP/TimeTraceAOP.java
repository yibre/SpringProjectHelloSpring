package Hello.SpringProjectHelloSpring.AOP;

import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;


@Component
@EnableAspectJAutoProxy
public class TimeTraceAOP {

    // 뭘 실행했는지 알려줌 -> e.g. execution 어쩌고.findMember() n 시간 소요 등
    // @Around("execution(*Hello.SpringProjectHelloSpring..*(..))")
    // Around 왜 import 불가한지 미지수
    public Object execute(MethodInvocationProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timeMs + "ms");
        }
    }
}
