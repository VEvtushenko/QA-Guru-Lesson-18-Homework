package guru.qa.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static TestConfiguration config = ConfigFactory.create(TestConfiguration.class);
}
