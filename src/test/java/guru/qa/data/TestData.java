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


    public static final String softwhereAtribute = "";

    public static final String[] processorType = new String[] {"80", "81", "82"};
    public static final String[] ramType = new String[] {"83", "84", "85"};
    public static final String[] hddType = new String[] {"86", "87"};
    public static final String imageVievier = "88",
                                officeSuite = "89",
                                otherOfficeSuite = "90";

    public static final String addComputerRequest = "product_attribute_74_5_26=" + processorType[0] +
                                                    "&product_attribute_74_6_27=" + ramType[1] +
                                                    "&product_attribute_74_3_28=" + hddType[0] +
                                                    "&product_attribute_74_8_29=" + officeSuite +
                                                    "&addtocart_74" +
                                                    ".EnteredQuantity=2";
}
