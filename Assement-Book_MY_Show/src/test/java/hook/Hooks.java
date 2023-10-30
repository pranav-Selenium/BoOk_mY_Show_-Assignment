package hook;

import diverInit.Initializing_Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;


import java.io.IOException;
import java.util.Properties;

import static diverInit.Initializing_Driver.ldriver;

public class Hooks {

     public Initializing_Driver init_driver;




    @Before(order = 0)
    public  void selectBrowser() throws IOException {


        init_driver = new Initializing_Driver();
        ldriver = init_driver.ini_driver();

    }



    @After(order = 0)
     public void teardown(){
          ldriver.quit();
    }


    }




