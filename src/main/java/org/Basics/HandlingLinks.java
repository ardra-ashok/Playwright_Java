package org.Basics;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandlingLinks {


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
    public void handlingLinks(){
        page.navigate("https://www.wikipedia.org/");
        Locator links = page.locator("a");
        System.out.println(links.count());

//        for(int i=0; i<links.count(); i++)
//            System.out.println(links.nth(i).innerText()+"---URL: ----"+links.nth(i).getAttribute("href"));


        Locator block = page.locator(".other-projects");
        Locator blocklinks = block.locator("a");
        System.out.println("----Printing links from the block------");
        System.out.println(blocklinks.count());
        for(int i=0; i<blocklinks.count(); i++)
            System.out.println(blocklinks.nth(i).innerText()+"---URL: ----"+blocklinks.nth(i).getAttribute("href"));


    }

    @AfterMethod
    public void afterTest(){

        page.close();
//        browserContext.close();
        browser.close();
        playwright.close();

    }
}
