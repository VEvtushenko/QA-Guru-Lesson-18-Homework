package guru.qa.helpers.apiRequests;

import static guru.qa.helpers.ApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class Product {

    /*
    product_attribute_74_5_26=82
    &product_attribute_74_6_27=85
    &product_attribute_74_3_28=87
    &product_attribute_74_8_29=88
    &product_attribute_74_8_29=90
    &addtocart_74
    .EnteredQuantity=1

    product_attribute_72_5_18=53
    &product_attribute_72_6_19=54
    &product_attribute_72_3_20=57
    &addtocart_72
    .EnteredQuantity=1
    */

    public static void addToCart() {
        given()
                .filter(withCustomTemplates())
        .when()
                .cookie("ARRAffinity=92eb765899e80d8de4d490df907547e5cb10de899e8b754a4d5fa1a7122fad69; " +
                        "SLG_G_WPT_TO=ru; " +
                        "__utmc=78382081; " +
                        "SLG_GWPT_Show_Hide_tmp=1; " +
                        "SLG_wptGlobTipTmp=1; " +
                        "__RequestVerificationToken=5CUy4ovUzG7ZP_QV4SgaHkw3v6GrhWLzfhBTV-OgXkUWh-FxNMko-J91Jr16M1Adg7R9OHjNZVHodNrCxqNKlyu8xSQrDz_QSzFlZYDDxXE1; " +
                        "ASP.NET_SessionId=cc03vht0c5lqxp0hfhlvy0mk; " +
                        "NOPCOMMERCE.AUTH=3D8FA4CB1B1F8B60E6C0B262D292E349F022653A22C0A87FC068924BD9AEF083D6C8295A5C315ADBA721132721E069C0A68C60C498334EBC703690990FFE048768B3DFC94921665AE3E96F21A34A8D35102FE93BACE76EBD5509BD36EB7BF47E4F771B50067EEA3F0BE9C6EDF54F8E88BE1CAADFEE1432A54CB0CFB4E3E8D0F46072C972479444CE0CBA2D0BDDEA9AC2; " +
                        "Nop.customer=9345ab71-54a6-468e-a89a-20fd34d3cc66; " +
                        "__utmz=78382081.1655378584.8.2.utmcsr=192.168.56.1:57737|utmccn=(referral)|utmcmd=referral|utmcct=/; " +
                        "nop.CompareProducts=; " +
                        "NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72&RecentlyViewedProductIds=13; " +
                        "__atuvc=6%7C24; " +
                        "__atuvs=62ab343c4a8d257e000; " +
                        "__utma=78382081.1055963931.1654610359.1655382398.1655387196.10; " +
                        "__utmt=1; __utmb=78382081.1.10.1655387196")
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("    product_attribute_74_5_26=82" +
                        "    &product_attribute_74_6_27=85" +
                        "    &product_attribute_74_3_28=87" +
                        "    &product_attribute_74_8_29=88" +
                        "    &product_attribute_74_8_29=90" +
                        "    &addtocart_74" +
                        ".EnteredQuantity=10")
                .post("/addproducttocart/details/74/1")
        .then()
                .log().all()
                .statusCode(200);
    }
}
