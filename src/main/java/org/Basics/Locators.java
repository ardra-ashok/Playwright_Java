package org.Basics;

import com.microsoft.playwright.*;
import org.testng.annotations.*;






public class Locators {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    private static Page page;

    @BeforeMethod
    public void Before(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
//        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1512,982));
        page = browser.newPage();


    }

    @Test
    public void locators(){
        page.navigate("http://gmail.com");
//        page.locator("#identifierId").fill("trainer@way2automation.com");
//        page.fill("#identifierId","trainer@way2automation.com");
        page.type("id=identifierId","trainer@way2automation.com", new Page.TypeOptions().setDelay(100));
        page.click("text=Next");
        page.locator("[type='Password']").fill("twttweee");
        page.click("button:has-text('Next')");

        page.selectOption("select", "hi");
    }


    @AfterMethod
    public void afterTest(){

        page.close();
        browserContext.close();
        browser.close();
        playwright.close();

    }

}
