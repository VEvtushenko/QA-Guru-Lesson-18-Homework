package guru.qa.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/local.properties")
public interface TestConfiguration extends Config {
    String login();
    String password();
    String remoteHub();
    String baseTestedURI();
    String baseTestedURL();
}
