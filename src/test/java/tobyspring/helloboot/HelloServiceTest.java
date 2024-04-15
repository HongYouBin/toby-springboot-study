package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@UnitTest
@interface FaceUnitTest {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Test
@interface UnitTest {
}

public class HelloServiceTest {
    @Test
    void simpleServiceTest() {
        SimpleHelloService helloService = new SimpleHelloService();
        String response = helloService.sayHello("Test");
        Assertions.assertThat(response).isEqualTo("Hello Test");
    }

    @UnitTest
    void helloDecorator() {
        HelloDecorator helloDecorator = new HelloDecorator(name -> name);
        String returnValue = helloDecorator.sayHello("Test");
        Assertions.assertThat(returnValue).isEqualTo("*Test*");
    }
}
