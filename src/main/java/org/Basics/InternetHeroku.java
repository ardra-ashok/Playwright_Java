package org.Basics;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class InternetHeroku {

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
        page.navigate("https://the-internet.herokuapp.com/");
        assertEquals("The Internet",page.title());
        System.out.println(page.locator("a").count());
        Locator content = page.locator("id=content");
        Locator contentLinks =  content.locator("a");
        for(int i=0;i<contentLinks.count();i++)
            System.out.println(contentLinks.nth(i).innerText()+"-----"+contentLinks.nth(i).getAttribute("href"));
        page.click("text=Dropdown");
        page.selectOption("select",new SelectOption().setLabel("Option 1"));
        String selectedText = page.evalOnSelector("select","el=>el.options[el.selectedIndex].text").toString();
        assertEquals("Option 1",selectedText);
    }

    @AfterMethod
    public void afterTest(){

        page.close();
//        browserContext.close();
        browser.close();
        playwright.close();

    }
}
