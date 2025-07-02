package org.Basics;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;


import java.nio.file.Path;
import java.nio.file.Paths;

public class NonIncognito {

    @Test
    public void NonIncognito() throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Path userDataDir = Paths.get(System.getProperty("java.io.tmpdir"), "playwright-user-data");
        BrowserContext browserContext = playwright.chromium().launchPersistentContext(userDataDir, new BrowserType.LaunchPersistentContextOptions().setHeadless(false).setExecutablePath(Paths.get("/Users/aashok/Desktop/Google Chrome.app/Contents/MacOS/Google Chrome")));
        Page page = browserContext.newPage();
        page.navigate("http://way2automation.com");
        System.out.println(page.title());
        page.navigate("http://google.com");
        Thread.sleep(1000);
        page.goBack(new Page.GoBackOptions().setTimeout(500));
        Thread.sleep(1000);

        page.goForward(new Page.GoForwardOptions().setTimeout(500));

        page.close();
        browserContext.close();
        playwright.close();
    }
}
