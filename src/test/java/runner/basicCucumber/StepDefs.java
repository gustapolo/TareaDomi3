package runner.basicCucumber;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class StepDefs {

    AppiumDriver android;
    @Given("que la app: whenDo esta abierta")
    public void queLaAppWhenDoEstaAbierta() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:deviceName","aNDROID9");
        capabilities.setCapability("appium:platformVersion","9.0");
        capabilities.setCapability("appium:appPackage","com.vrproductiveapps.whendo");
        capabilities.setCapability("appium:appActivity","com.vrproductiveapps.whendo.ui.HomeActivity");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("appium:automationName","uiautomator2");
        android = new AndroidDriver(new URL("http://127.0.0.1:4723/"),capabilities);
        android.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @When("agrego una nueva tarea")
    public void agregoUnaNuevaTarea() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/fab")).click();
    }

    @And("registrar Un Titulo: {string}")
    public void registrarUnTitulo(String titulo) {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextTitle")).sendKeys(titulo);
    }

    @And("registrar Una Descripcion: {string}")
    public void registrarUnaDescripcion(String descripcion) {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/noteTextNotes")).sendKeys(descripcion);
    }

    @And("hago click en guardar")
    public void hagoClickEnGuardar() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/saveItem")).click();
    }


    @And("Seleccionar el tipo de orden")
    public void seleccionarElTipoDeOrden() {
        android.findElement(By.id("com.vrproductiveapps.whendo:id/home_header_icon")).click();
    }

    @And("seleccionar el orden alfabetico")
    public void seleccionarElOrdenAlfabetico() {
        android.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Alphabetic\"]")).click();
    }

    @Then("la tarea {string} deberia ser mostrado")
    public void laTareaDeberiaSerMostrado(String expectedResult) {
        String actualResult =android.findElement(By.xpath("//android.widget.TextView[@text='"+expectedResult+"']")).getText();
        Assertions.assertEquals(expectedResult,actualResult,"ERROR ! la tarea no se creo correctamente");

    }

}
