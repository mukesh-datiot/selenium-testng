package com.w2a.testcases;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


public class UnitTestCases  {

    private static WebDriver driver;

    @Before
    @BeforeTest
    public static void beforeClassSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chrome\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
//        driver = new ChromeDriver();
//        driver.get("http://localhost:3000/");
//        driver.manage().window().maximize();
    }

    @BeforeMethod
    public static void beforeMethodSetup(){
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public static void afterMethodSetup(){
        driver.close();
    }

    @After
    @AfterTest
    public static void afterClassSetup() {
        // driver.close();
    }


  //  @Test(dataProviderClass= TestUtil.class,dataProvider="dp")
    @Test
    public void unitTestCases() throws Exception {

        SoftAssert softAssert = new SoftAssert();

        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");
        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

            dataList = read(wb, "Main");
            ip.close();
            for (Map<String, String> dataMap : dataList) {
                addUnit(dataMap);
            }

//        String name = "";
//        String unit1 = "";
//        String unit2 = "";
//        String unit3 = "";
//        String unit4 = "";
//        String unit5 = "";
//
//        String aliases1 = "";
//        String aliases2 = "";
//        String aliases3 = "";
//        String aliases4 = "";
//        String aliases5 = "";
//
//        String selectedField = "";
//
////        if(!data.get("runmode").equals("Y")){
////
////            throw new SkipException("Skipping the test case as the Run mode for data set is NO");
////        }
//         click("clc_AddUnitButton_XPATH");
////        Select selectVertical = new Select(driver.findElement(By.cssSelector("[data-test='test-vertical-input']")));
////        selectVertical.selectByVisibleText(selectedField);
//         select("select_Vertical_CSS", data.get("selectedField"));
//         type("addName_CSS",data.get("name"));
//         type("addUnit1_XPATH", data.get("unit1"));
//        type("addAliases1_XPATH", data.get("aliases1"));
//        WebElement addAliases1 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[1]"));
//        addAliases1.sendKeys(aliases1);
//        addAliases1.sendKeys(Keys.ENTER);
//
//        if (!data.get("unit2").isEmpty()) {
//            click("clickONPlusButton_XPATH");
//            type("addUnit2_XPATH",data.get("unit2"));
//            type("addAliases2_XPATH", data.get("aliases2"));
//            WebElement addAliases2 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[2]"));
//            addAliases2.sendKeys(aliases2);
//            addAliases2.sendKeys(Keys.ENTER);
//        }
//        if (!data.get("unit3").isEmpty()) {
//            click("clickONPlusButton_XPATH");
//            type("addUnit3_XPATH",data.get("unit3"));
//            type("addAliases3_XPATH", data.get("aliases3"));
//            WebElement addAliases3 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[3]"));
//            addAliases3.sendKeys(aliases3);
//            addAliases3.sendKeys(Keys.ENTER);
//        }
//        if (!data.get("unit4").isEmpty()){
//            click("clickONPlusButton_XPATH");
//            type("addUnit4_XPATH",data.get("unit4"));
//            type("addAliases4_XPATH", data.get("aliases4"));
//            WebElement addAliases4 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[4]"));
//            addAliases4.sendKeys(aliases4);
//            addAliases4.sendKeys(Keys.ENTER);
//
//        }
//        if (!data.get("unit5").isEmpty()) {
//            click("clickONPlusButton_XPATH");
//            type("addUnit5_XPATH",data.get("unit5"));
//            type("addAliases5_XPATH", data.get("aliases5"));
//            WebElement addAliases5 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[5]"));
//            addAliases5.sendKeys(aliases5);
//            addAliases5.sendKeys(Keys.ENTER);
//
//        }
//
//        click("savButton_CSS");
//
//        WebElement createMessageOnAddUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
//        System.out.println(createMessageOnAddUnit.getText());
//        verifyEquals("Meta data saved successfully", createMessageOnAddUnit.getText());
//
//        Thread.sleep(6000);
//
//        log.debug("Inside AddUnit test");


    }


    public static void addUnit(Map<String, String> dataMap) throws InterruptedException {

            WebDriverWait wait = new WebDriverWait(driver, 50);
            String name = "";
            String unit1 = "";
            String unit2 = "";
            String unit3 = "";
            String unit4 = "";
            String unit5 = "";

            String aliases1 = "";
            String aliases2 = "";
            String aliases3 = "";
            String aliases4 = "";
            String aliases5 = "";

            String selectedField = "";
            // String aliases = "";
            Set<String> mapKeys = dataMap.keySet();
            for (String s : mapKeys) {
                System.out.println("s = " + s);
                if (s.equals("selectedField")) {
                    selectedField = dataMap.get(s);
                }
                if (s.equals("name")) {
                    name = dataMap.get(s);
                }

                if (s.equals("unit1")) {
                    unit1 = dataMap.get(s);
                }
                if (s.equals("unit2")) {
                    unit2 = dataMap.get(s);
                }
                if (s.equals("unit3")) {
                    unit3 = dataMap.get(s);
                }
                if (s.equals("unit4")) {
                    unit4 = dataMap.get(s);
                }
                if (s.equals("unit5")) {
                    unit5 = dataMap.get(s);
                }
                if (s.equals("aliases1")) {
                    aliases1 = dataMap.get(s);
                }
                if (s.equals("aliases2")) {
                    aliases2 = dataMap.get(s);
                }
                if (s.equals("aliases3")) {
                    aliases3 = dataMap.get(s);
                }
                if (s.equals("aliases4")) {
                    aliases4 = dataMap.get(s);
                }
                if (s.equals("aliases5")) {
                    aliases5 = dataMap.get(s);
                }
            }

            Reporter.log("Test case start for " + selectedField);
            WebElement addUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
            addUnitButton.click();
            Thread.sleep(100);
            Select selectVertical = new Select(driver.findElement(By.cssSelector("[data-test='test-vertical-input']")));
            selectVertical.selectByVisibleText(selectedField);
            Thread.sleep(100);
            WebElement addName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='test--unit-name']")));
            addName.sendKeys(name);

            WebElement addUnits = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[1]")));
            addUnits.sendKeys(unit1);
            Thread.sleep(100);
            WebElement addAliases1 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[1]"));
            addAliases1.sendKeys(aliases1);
            addAliases1.sendKeys(Keys.ENTER);

            if (!unit2.trim().isEmpty()) {
                WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@data-test='test-unitDto-addUnit'])"));
                clickOnPlusButton.click();
                Thread.sleep(1000);
                WebElement addUnits2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[2]")));
                addUnits2.sendKeys(unit2);
                Thread.sleep(100);
                WebElement addAliases2 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[2]"));
                addAliases2.sendKeys(aliases2);
                addAliases2.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }

            if (!unit3.trim().isEmpty()) {
                WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@data-test='test-unitDto-addUnit'])"));
                clickOnPlusButton.click();
                Thread.sleep(100);
                WebElement addUnits3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[3]")));
                addUnits3.sendKeys(unit3);
                Thread.sleep(100);
                WebElement addAliases3 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[3]"));
                addAliases3.sendKeys(aliases3);
                addAliases3.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }

            if (!unit4.trim().isEmpty()) {
                WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@data-test='test-unitDto-addUnit'])"));
                clickOnPlusButton.click();
                Thread.sleep(100);
                WebElement addUnits4 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[4]")));
                addUnits4.sendKeys(unit4);
                Thread.sleep(100);
                WebElement addAliases4 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[4]"));
                addAliases4.sendKeys(aliases4);
                addAliases4.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }

            if (!unit5.trim().isEmpty()) {
                WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@data-test='test-unitDto-addUnit'])"));
                clickOnPlusButton.click();
                Thread.sleep(100);
                WebElement addUnits5 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[5]")));
                addUnits5.sendKeys(unit5);
                Thread.sleep(100);
                WebElement addAliases5 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[5]"));
                addAliases5.sendKeys(aliases5);
                addAliases5.sendKeys(Keys.ENTER);
                Thread.sleep(1000);
            }



            WebElement saveDetailButton = driver.findElement(By.cssSelector("[data-test='test-submit-button']"));
            saveDetailButton.click();
            WebElement createMessageOnAddUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
            System.out.println(createMessageOnAddUnit.getText());
            Assert.assertEquals("Meta data saved successfully", createMessageOnAddUnit.getText());
            Thread.sleep(5000);


    }

   // @Test(dataProviderClass= TestUtil.class,dataProvider="dp")
    @Test
    public void b_editUnit() throws Exception {
//        if(!data.get("runmode").equals("Y")){
//
//            throw new SkipException("Skipping the test case as the Run mode for data set is NO");
//        }
            String name = "";
            String updatedUnitName = "";
            FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");

            Workbook wb = WorkbookFactory.create(ip);
            List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
            dataList = read(wb, "Main");
            for (Map<String, String> dataMap : dataList) {
                Set<String> mapKeys = dataMap.keySet();
                for (String s : mapKeys) {
                    //  System.out.println("s = " + s);
                    if (s.equals("name")) {
                        name = dataMap.get(s);
                    }

                    if (s.equals("updatedUnitName")) {
                        updatedUnitName = dataMap.get(s);
                    }
                }
                ip.close();

                WebDriverWait wait = new WebDriverWait(driver, 50);
                WebElement searchUnitByName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='form-control']")));
                searchUnitByName.sendKeys(name);
                Thread.sleep(200);
                WebElement editUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("edit-unit")));
                editUnitButton.click();
                Thread.sleep(200);
                WebElement editName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='test--unit-name']")));
                editName.click();
                editName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
                editName.clear();
                editName.sendKeys(updatedUnitName);
                Thread.sleep(200);
                WebElement editUnits = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='test-unitName']")));
                editUnits.click();

                WebElement editPopUpOnEditUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
                System.out.println(editPopUpOnEditUnit.getText());
                Assert.assertEquals("unit name updated successfully", editPopUpOnEditUnit.getText());
                Thread.sleep(200);
                WebElement clickOnBackButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn btn-info ml-1']")));
                clickOnBackButton.click();

            }

  }


    private static List<Map<String, String>> read(Workbook wb, String main){
        Sheet sheet = wb.getSheet(main);
        List dataList = new ArrayList<Map<String, String>>();
        int i, j;
        Map<String, Integer> cellHeader = new HashMap<String, Integer>();
        for (i = 0; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (i == 0) {
                for (j = 0; j < row.getLastCellNum(); j++) {
                    cellHeader.put(row.getCell(j).getStringCellValue(), j);
                }
                continue;
            }
            //  System.out.println("&&&&&&&&& "+ row.getCell(cellHeader.get("Execute")).toString().equals("Yes"));
          //  row.getCell(cellHeader.get("runmode")).toString().equals("Yes");
            if (row.getCell(cellHeader.get("runmode")).toString().equals("Y")) {
                Map<String, String> data = new HashMap<String, String>();
                Set<String> mapKey = cellHeader.keySet();
                for (String s : mapKey){
                    if (row.getCell(cellHeader.get(s)) != null) {
                        data.put(s, row.getCell(cellHeader.get(s)).toString());
                    }
                }
                dataList.add(data);
            }
        }

        System.out.println("dataList " + dataList.toString());
        return dataList;
    }



}

