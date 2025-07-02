package org.Basics;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingCheckboxes {

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
    public void herokuElements(){
        page.navigate("https://the-internet.herokuapp.com/checkboxes");
        Locator formLoc = page.locator("#checkboxes");
        Locator checkboxes = formLoc.locator("[type='checkbox']");
        for(int i=0;i<checkboxes.count();i++)
            checkboxes.nth(i).click();
        System.out.println(checkboxes.count());
    }

    @AfterMethod
    public void afterTest(){

        page.close();
//        browserContext.close();
        browser.close();
        playwright.close();

    }
}
