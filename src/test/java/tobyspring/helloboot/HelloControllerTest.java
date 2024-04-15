package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HelloControllerTest {
    @Test
    void controllerTest() {
        HelloController helloController = new HelloController(name -> name);
        String response = helloController.hello("Test");

        assertThat(response).isEqualTo("Test");
    }

    @Test
    void failControllerTest() {
        HelloController helloController = new HelloController(name -> name);
        assertThatThrownBy(()-> {
            String ret = helloController.hello(null);
        }).isInstanceOf(NullPointerException.class);

//        assertThatThrownBy(()-> {
//            String ret = helloController.hello("");
//        }).isInstanceOf(NullPointerException.class);
    }
}
