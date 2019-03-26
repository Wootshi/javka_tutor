package org.automation.addressbook.appmanager;

import org.automation.addressbook.model.ContactData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactHelper extends BaseHelper {

    public ContactHelper(WebDriver driver) {
        super(driver);

    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {

        click(By.name("submit"));
    }


    public void fillContactForm(ContactData contactData, boolean creation) {

        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getSecondname());

        if (creation) {
            new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }


    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void deleteSelectedContact() {

        click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
        driver.switchTo().alert().accept();
    }

    public void selectContact() {

        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

}
