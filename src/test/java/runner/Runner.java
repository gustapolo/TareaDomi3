package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Runner {

    @Before
    public void setup() {
        System.out.println("esta logica se ejecuta antes del Scenario");
    }
    @After
    public void clean() {
        System.out.println("esta logica se ejecuta despues del Scenario");
    }
    @Before("@Taller")
    public void setupRegression() {
        System.out.println("esta logica se ejecuta antes del Scenario: Taller");
    }
    @After("@Taller")
    public void cleanRegression() {
        System.out.println("esta logica se ejecuta despues del Scenario: Taller");
    }

}
