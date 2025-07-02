package org.example;

import com.microsoft.playwright.*;
import org.junit.Test;

import java.util.ArrayList;

public class MaxWindow {
    @Test
    public void maxWindow() throws InterruptedException {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false).setArgs(arguments));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        playwright.close();
    }
}
