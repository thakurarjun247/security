package security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.ObjectInputFilter;
import java.util.Arrays;

@SpringBootApplication
public class SecurityApplication {

  public int devide(int x, int y){
        return x/y;
    }
    public static void main(String[] args) {

        ConfigurableApplicationContext configurableApplicationContext = SpringApplication.run(SecurityApplication.class, args);
        Arrays.stream(configurableApplicationContext.getBeanDefinitionNames()).forEach(System.out::println);
    }


}
