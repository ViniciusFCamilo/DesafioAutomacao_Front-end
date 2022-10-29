package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import support.Utils;

public class HomePage extends Utils {
    WebDriver driver;
    private String lCheckBoxSelecionarPrimeiro = "(//input[@class='select-row'])[1]";//xpath
    private String lBtnConfirmaçãoDeletar = "//button[@class='btn btn-danger delete-multiple-confirmation-button']";//xpath
    private String lLblMensagemConfirmaçãoDeletar = "//*[@class=\"alert-delete-multiple-one\"][contains(.,'Are you sure that you want to delete')]";//xpath

    Utils utils = new Utils();

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void esperarLoadingDaGrid(String quantidadeTotalCustomers){
        String lquantidadeTotalCustomers = "//span[@class='current-total-results'][contains(.,'"+quantidadeTotalCustomers+"')]";//xpath
        utils.esperarElementoDesaparecer(By.xpath(lquantidadeTotalCustomers), 10);
    }
    public void deletarCustomerCriado() throws InterruptedException {
        driver.findElement(By.xpath(lCheckBoxSelecionarPrimeiro)).sendKeys(Keys.SPACE);
        driver.findElement(By.linkText("Delete")).click();
        utils.esperarElementoAparecer(By.xpath(lBtnConfirmaçãoDeletar), 10);
        utils.validarMensagem(By.xpath(lLblMensagemConfirmaçãoDeletar),"Are you sure that you want to delete this 1 item?");
        driver.findElement((By.xpath(lBtnConfirmaçãoDeletar))).click();
    }
}
