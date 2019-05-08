package cucumber.features.steps.hooks;


import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void beforeMethod () {
            System.out.println("HOOK Start");
    }


    @After
    public void afterMethod () {
        System.out.println("HOOK after");
    }

}
