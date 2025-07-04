package org.Basics;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class DropDowns {
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
    public void dropDownExample() {
        page.navigate("https://www.wikipedia.org/");
        page.selectOption("select","en");
//        page.selectOption("select", new SelectOption().setIndex(1));
        String selectedOption = page.evalOnSelector("select","el=>el.options[el.selectedIndex].text").toString();
        assertEquals(selectedOption,"English");
//        page.selectOption("select", new SelectOption().setLabel("Eesti"));
        System.out.println(page.locator("select > option").count());
        Locator selectOptions = page.locator("select > option");

        for (int i = 0; i < selectOptions.count(); i++)
            System.out.println(selectOptions.nth(i).innerText()+"----"+selectOptions.nth(i).getAttribute("lang"));
    }

    @AfterMethod
    public void afterTest(){

        page.close();
//        browserContext.close();
        browser.close();
        playwright.close();

    }
}
