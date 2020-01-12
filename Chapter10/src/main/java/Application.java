import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/24
 */
@SpringBootApplication
@ComponentScan("com.course")
@EnableAutoConfiguration
public class Application{

    public static void main(String[] args) {
        SpringApplication.run(Application.class ,args);
    }
}
