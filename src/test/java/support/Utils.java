package support;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import runners.RunDesafioTest;

import java.time.Duration;

public class Utils extends RunDesafioTest {
    public void acessarPagina(String URL){
        start();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    public void esperarElementoAparecer(By elemento, int tempo){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }
    public void esperarElementoDesaparecer(By elemento, int tempo){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tempo));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elemento));
    }

    public void preencherComboboxByValue(By lCombobox, String valueItemCombobox){
        Select select = new Select(driver.findElement(lCombobox));
        select.selectByValue(valueItemCombobox);
    }

    public void preencherInput(By elemento, String valor){
        driver.findElement(elemento).sendKeys(valor);
    }

    public void validarMensagem(By elemento, String mensagemEsperada){
        String resultadoMensagem = driver.findElement(elemento).getText();
        Assert.assertEquals(mensagemEsperada, resultadoMensagem);
    }
}
