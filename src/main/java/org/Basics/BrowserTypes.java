package org.Basics;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

public class BrowserTypes {
    @Test
    public void BrowserType() throws InterruptedException {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setExecutablePath(Paths.get("/Users/aashok/Desktop/Google Chrome.app/Contents/MacOS/Google Chrome")).setArgs(arguments));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println(page.title());
        Thread.sleep(2000);
        page.close();
        browserContext.close();
        playwright.close();

    }
}
