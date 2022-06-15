package guru.qa.data;

import guru.qa.config.Project;

public class TestData {
    public static final String login = Project.config.login(),
                                password = Project.config.password(),
                                loginRequest = "Email=" + login +
                                                "&Password=" + password +
                                                "&RememberMe=true" +
                                                "&RememberMe=false",
                                authCookieName = "NOPCOMMERCE.AUTH";
}
