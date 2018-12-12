package test.cfg;

import akka.actor.ActorSystem;
import akka.actor.Props;
import com.kc.test.bean.DemoActor;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/11/9
 */
@Configuration
public class Logconfig {
    @PostConstruct
    public void init(){
        ActorSystem system=ActorSystem.create("log-demo");
        for (int i = 0; i < 3; i++) {
            system.actorOf(Props.create(DemoActor.class,i));
        }
    }
}
