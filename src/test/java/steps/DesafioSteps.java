package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.openqa.selenium.By;
import pages.FormAddCustomerPage;
import pages.HomePage;
import runners.RunDesafioTest;


public class DesafioSteps extends RunDesafioTest {
    //-----------------------------------------------------------------------------------------------
    //LOCATORS HOME + URL
    String URL = "https://www.grocerycrud.com/v1.x/demo/bootstrap_theme/";
    String lCombobox = "switch-version-select";//id
    String lBtnAddCustomer = "//a[@class='btn btn-default btn-outline-dark'][contains(.,'Add Customer')]";//xpath
    String lTxtName = "customerName";//name
    String lHomeMensagem = "//div[@class=\"alert alert-success growl-animated animated bounceInDown\"]/span/p";//xpath

    //--------------------------------------------------------------------------------------------------
    //VALUES HOME
    String valueItemCombobox = "/v1.x/demo/bootstrap_theme_v4";
    //--------------------------------------------------------------------------------------------------
    //LOCATORS TELA FORMULARIO
    String lBtnSave = "form-button-save";//id
    String lFormName = "field-customerName";//id
    String lFormLastName = "field-contactLastName";//id
    String lFormContactName = "field-contactFirstName";//id
    String lFormPhone = "field-phone";//id
    String lFormAdressLine1 = "field-addressLine1";//id
    String lFormAdressLine2 = "field-addressLine2";//id
    String lFormCity = "field-city";//id
    String lFormState = "field-state";//id
    String lFormPostalCode = "field-postalCode";//id
    String lFormCountry = "field-country";//id
    String lFormComboboxFromEmployeer = "//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span[text()='Select from Employeer']";//xpath
    String lFormCreditLimit = "field-creditLimit";//id
    String lFormDeleted = "field-deleted";//id
    String lFormMensagem = "//*[@id=\"report-success\"]/p";
    String lGoBackToList = "//*[@id=\"report-success\"]/p/a[text()='Go back to list']";

    //----------------------------------------------------------------------------------------------
    String quantidadeTotalCustomers;
    FormAddCustomerPage formAddCustomerPage = new FormAddCustomerPage(driver);
    HomePage homePage = new HomePage(driver);

    @Dado("^que estou no site$")
    public void acessarSite(){
        homePage.acessarPagina(URL);
        formAddCustomerPage = new FormAddCustomerPage(driver);
        homePage = new HomePage(driver);
    }

    @Quando("^eu seleciono “Bootstrap V4 Theme” no combobox$")
    public void preencherCombobox(){
        homePage.esperarElementoAparecer(By.id(lCombobox), 20);
        homePage.preencherComboboxByValue(By.id(lCombobox), valueItemCombobox);
    }

    @E("^clico em Add Customer$")
    public void clicarAddCustomer(){
        driver.findElement(By.xpath(lBtnAddCustomer)).click();
    }

    @E("^preencho as informações do formulário$")
    public void preencherFormulario(){
        formAddCustomerPage.esperarElementoAparecer(By.id(lFormName), 20);
        formAddCustomerPage.preencherInput(By.id(lFormName), "Teste Nome");
        formAddCustomerPage.preencherInput(By.id(lFormLastName), "Ultimo Nome");
        formAddCustomerPage.preencherInput(By.id(lFormContactName), "Primeiro Nome");
        formAddCustomerPage.preencherInput(By.id(lFormPhone), "48 9999-9999");
        formAddCustomerPage.preencherInput(By.id(lFormAdressLine1), "Imigrante Meller, 1430");
        formAddCustomerPage.preencherInput(By.id(lFormAdressLine2), "Apartamento 201");
        formAddCustomerPage.preencherInput(By.id(lFormCity), "Criciúma");
        formAddCustomerPage.preencherInput(By.id(lFormState), "SC");
        formAddCustomerPage.preencherInput(By.id(lFormPostalCode), "88800-001");
        formAddCustomerPage.preencherInput(By.id(lFormCountry), "Brasil");
        formAddCustomerPage.preencherInput(By.id(lFormCreditLimit), "100");
        formAddCustomerPage.preencherInput(By.id(lFormDeleted), "Deleted");
        formAddCustomerPage.preencherFromEmployeer(By.xpath(lFormComboboxFromEmployeer), "Fixter");

    }

    @E("^clico em Salvar$")
    public void clicarSalvar(){
        driver.findElement(By.id(lBtnSave)).click();
    }

    @Então("^eu vejo a mensagem de sucesso$")
    public void validarMensagemDeSucesso(){
        formAddCustomerPage.esperarElementoAparecer(By.xpath(lFormMensagem), 10);
        formAddCustomerPage.validarMensagem(By.xpath(lFormMensagem), "Your data has been successfully stored into the database. Edit Customer or Go back to list");
    }
    @E("^que visualizo o texto Go back to list dentro da mensagem de sucesso$")
    public void validarElementoDentroDaMensagemDeSuceso(){
        formAddCustomerPage.esperarElementoAparecer(By.xpath(lGoBackToList), 10);
    }
    @Quando("^clico no texto$")
    public void clicarEmGoBackToList(){
        driver.findElement(By.xpath(lGoBackToList)).click();
    }
    @Então("^sou direcionado para a pagina principal$")
    public void validarElementoDaPaginaPrincipal(){
        homePage.esperarElementoAparecer(By.name(lTxtName), 10);
    }
    @E("^pesquiso o nome do customer que criei$")
    public void pesquisarCustomer(){
        quantidadeTotalCustomers = driver.findElement(By.className("current-total-results")).getText();
        driver.findElement(By.name(lTxtName)).sendKeys("Teste Nome");
    }
    @E("^deleto esse customer$")
    public void deletarCustomer() throws InterruptedException {
        homePage.esperarLoadingDaGrid(quantidadeTotalCustomers);
        homePage.deletarCustomerCriado();

    }
    @Então("^eu vejo a mensagem de cadastro deletado com sucesso$")
    public void validarMensagem(){
        homePage.esperarElementoAparecer(By.xpath(lHomeMensagem), 20);
        homePage.validarMensagem(By.xpath(lHomeMensagem), "Your data has been successfully deleted from the database.");
    }

    @Então("^fecho o navegador$")
    public void fecharNavegador(){
        driver.quit();
    }

}
