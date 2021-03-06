package consulting.jjs.be;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class BeApplication implements ApplicationListener<ContextRefreshedEvent> {

  private static final Logger LOG = LoggerFactory.getLogger(BeApplication.class);


  @Value("${spring.profiles.active}")
  protected String springProfilesActive;


  public static void main(String[] args) {
    SpringApplication.run(BeApplication.class, args);
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    LOG.info("=======================================");
    LOG.info("App running with active profiles: {}", springProfilesActive);
    LOG.info("=======================================");
  }
}
