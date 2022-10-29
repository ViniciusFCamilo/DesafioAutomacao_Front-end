package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class FormAddCustomerPage extends Utils {
    private String lTxtCombobox = "//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input[contains(@type,'text')]";//xpath
    WebDriver driver;

    public FormAddCustomerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherFromEmployeer(By lCombobox, String vCombobox){
        driver.findElement(lCombobox).click();
        esperarElementoAparecer(By.xpath(lTxtCombobox), 10);
        driver.findElement(By.xpath(lTxtCombobox)).sendKeys(vCombobox);
        driver.findElement(By.xpath(lTxtCombobox)).sendKeys(Keys.ENTER);
    }

}
