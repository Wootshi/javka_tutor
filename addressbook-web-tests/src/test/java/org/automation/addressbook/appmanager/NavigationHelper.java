package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends BaseHelper {

    public NavigationHelper(WebDriver driver) {

        super(driver);
    }

    public void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return;
        }
        click(By.linkText("groups"));
    }

    public void HomePage() {

        if (isElementPresent(By.name("maintable"))) {
            return;
        }

        click(By.xpath("//*[@id=\"nav\"]/ul/li[1]/a"));
    }

    public void wait(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

//    public void enterFirstLastName(ContactData contactData) {
//
//        type(By.name("firstname"), contactData.getFirstname());
//        type(By.name("lastname"), contactData.getLastname());
//
//    }
}
