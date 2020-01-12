package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/24
 */

@Controller
@EnableAutoConfiguration
public class SampleController
{


    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "hello world!";
    }
    public static void main(String[] args) {
        SpringApplication.run(SampleController.class,args);
    }

}