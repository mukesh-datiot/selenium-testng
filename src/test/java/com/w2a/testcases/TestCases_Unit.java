package com.w2a.testcases;

import com.w2a.utilities.ExcelReader;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.util.*;

public class TestCases_Unit {

    public static WebDriver driver;

    @BeforeTest
    public static void beforeClassSetup() {
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chrome\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("\"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe\"");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public static void afterMethodSetup(){
        driver.close();
    }


    @Test
    public void a_addUnit() throws Exception {
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");
        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

        dataList = read(wb, "Unit");
        ip.close();
        for (Map<String, String> dataMap : dataList) {
            addUnit(dataMap);
        }
    }


    public static void addUnit(Map<String, String> dataMap) throws InterruptedException, Exception {

        WebDriverWait wait = new WebDriverWait(driver, 50);
        String name = "";

        String name1 = "";
        String name2 = "";
        String name3 = "";
        String name4 = "";
        String name5 = "";

        String aliases1 = "";
        String aliases2 = "";
        String aliases3 = "";
        String aliases4 = "";
        String aliases5 = "";

        String selectedField = "";
        Set<String> mapKeys = dataMap.keySet();
        for (String s : mapKeys) {
            System.out.println("s = " + s);
            if (s.equals("selectedField")) {
                selectedField = dataMap.get(s);
            }
            if (s.equals("name")) {
                name = dataMap.get(s);
            }
            if (s.equals("name1")) {
                name1 = dataMap.get(s);
            }
            if (s.equals("name2")) {
                name2 = dataMap.get(s);
            }
            if (s.equals("name3")) {
                name3 = dataMap.get(s);
            }
            if (s.equals("name4")) {
                name4 = dataMap.get(s);
            }
            if (s.equals("name5")) {
                name5 = dataMap.get(s);
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

        WebElement addUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
        addUnitButton.click();
        Select selectVertical = new Select(driver.findElement(By.cssSelector("[data-test='test-vertical-input']")));
        selectVertical.selectByVisibleText(selectedField);
        WebElement addName = driver.findElement(By.cssSelector("[data-test='test--unit-name']"));
        addName.sendKeys(name);
        WebElement addUnits = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[1]"));
        addUnits.sendKeys(name1);
        WebElement addAliases1 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[1]"));
        addAliases1.sendKeys(aliases1);
        addAliases1.sendKeys(Keys.ENTER);

        if (!name2.trim().isEmpty()) {
            WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@class='mx-1 btn btn-secondary btn-sm'])"));
            clickOnPlusButton.click();
            WebElement addUnits2 = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[2]"));
            addUnits2.sendKeys(name2);
            WebElement addAliases2 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[2]"));
            addAliases2.sendKeys(aliases2);
            addAliases2.sendKeys(Keys.ENTER);
        }

        if (!name3.trim().isEmpty()) {
            WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@class='mx-1 btn btn-secondary btn-sm'])"));
            clickOnPlusButton.click();
            WebElement addUnits3 = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[3]"));
            addUnits3.sendKeys(name3);
            WebElement addAliases3 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[3]"));
            addAliases3.sendKeys(aliases3);
            addAliases3.sendKeys(Keys.ENTER);
        }

        if (!name4.trim().isEmpty()) {
            WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@class='mx-1 btn btn-secondary btn-sm'])"));
            clickOnPlusButton.click();
            WebElement addUnits4 = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[4]"));
            addUnits4.sendKeys(name4);
            WebElement addAliases4 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[4]"));
            addAliases4.sendKeys(aliases4);
            addAliases4.sendKeys(Keys.ENTER);
        }

        if (!name5.trim().isEmpty()) {
            WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@class='mx-1 btn btn-secondary btn-sm'])"));
            clickOnPlusButton.click();
            WebElement addUnits5 = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[5]"));
            addUnits5.sendKeys(name5);
            WebElement addAliases5 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[5]"));
            addAliases5.sendKeys(aliases5);
            addAliases5.sendKeys(Keys.ENTER);
        }

        WebElement saveDetailButton = driver.findElement(By.cssSelector("[data-test='test-submit-button']"));
        saveDetailButton.click();
        WebElement createMessageOnAddUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
        System.out.println(createMessageOnAddUnit.getText());
        Assert.assertEquals("Meta data saved successfully", createMessageOnAddUnit.getText());
        Thread.sleep(2000);
        verifyUnit();
        String vertical = driver.findElement(By.cssSelector("[data-test='test-vertical-input']")).getAttribute("value");
        Assert.assertEquals(vertical, selectedField);
        String nameVerify = driver.findElement(By.cssSelector("[data-test='test--unit-name']")).getAttribute("value");
        Assert.assertEquals(nameVerify, name);
        String name1Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[1]")).getAttribute("value");
        Assert.assertEquals(name1Verify, name1);

        if(isElementPresent(By.xpath("(//input[@data-test='test-unitName'])[2]"))){
            String name2Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[2]")).getAttribute("value");
            Assert.assertEquals(name2Verify, name2);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        if(isElementPresent(By.xpath("(//input[@data-test='test-unitName'])[3]"))){
            String name3Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[3]")).getAttribute("value");
            Assert.assertEquals(name3Verify, name3);
        }
       // boolean eleDisplayed = isElementPresent(By.xpath("(//input[@data-test='test-unitName'])[4]"));
        if(isElementPresent(By.xpath("(//input[@data-test='test-unitName'])[4]"))){
            String name4Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[4]")).getAttribute("value");
            Assert.assertEquals(name4Verify, name4);
        }
        js.executeScript("window.scrollBy(0,200)", "");
//        WebElement Element1 = driver.findElement(By.xpath("//input[@data-test='test-unitName'])[5]"));
//
//        // Scrolling down the page till the element is found
//        js.executeScript("arguments[0].scrollIntoView();", Element1);
        if(isElementPresent(By.xpath("(//input[@data-test='test-unitName'])[5]"))){
            String name5Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[5]")).getAttribute("value");
            Assert.assertEquals(name5Verify, name5);
        }

    }

    public static boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    public static void verifyUnit() throws Exception {

        String updatedUnitName = "";
        String selectedField = "";
        String name = "";
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");

        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        dataList = read(wb, "Unit");
        for (Map<String, String> dataMap : dataList) {
            Set<String> mapKeys = dataMap.keySet();
            for (String s : mapKeys) {
                //  System.out.println("s = " + s);
                if (s.equals("name")) {
                    name = dataMap.get(s);
                }

                if (s.equals("selectedField")) {
                    selectedField = dataMap.get(s);
                }
                if (s.equals("updatedUnitName")) {
                    updatedUnitName = dataMap.get(s);
                }
            }
            ip.close();

            List<WebElement> rowSize =
                    driver.findElements(By.xpath("*//table/tbody/tr"));
            WebElement row = null;
            for (int i = 0; i < rowSize.size(); i++) {
                String col1 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(1)"))).getText();
                String col2 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText();
//            System.out.println(rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText());
//            System.out.println(col1 + "  " + col2);
                if (col1.equals(selectedField) && col2.equals(name)) {
                    System.out.println(col1 + "  " + col2);
                    row = rowSize.get(i);
                    break;
                }
            }
            System.out.println("CHAL JAA BHAI");
            System.out.println(row.getText());
            row.findElement((By.cssSelector("td:nth-of-type(4)"))).findElement(By.id("edit-unit")).click();
            Thread.sleep(1000);
        }
    }

//    public static void verifyEditedUnit() throws Exception {
//
//        String selectedField = "";
//        String name = "";
//        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");
//
//        Workbook wb = WorkbookFactory.create(ip);
//        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//        dataList = read(wb, "Unit");
//        for (Map<String, String> dataMap : dataList) {
//            Set<String> mapKeys = dataMap.keySet();
//            for (String s : mapKeys) {
//                //  System.out.println("s = " + s);
//                if (s.equals("name")) {
//                    name = dataMap.get(s);
//                }
//
//                if (s.equals("selectedField")) {
//                    selectedField = dataMap.get(s);
//                }
//
//            }
//            ip.close();
//
//            List<WebElement> rowSize =
//                    driver.findElements(By.xpath("*//table/tbody/tr"));
//            WebElement row = null;
//            for (int i = 0; i < rowSize.size(); i++) {
//                String col1 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(1)"))).getText();
//                String col2 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText();
////            System.out.println(rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText());
////            System.out.println(col1 + "  " + col2);
//                if (col1.equals(selectedField) && col2.equals(name)) {
//                    System.out.println(col1 + "  " + col2);
//                    row = rowSize.get(i);
//                    break;
//                }
//            }
//            System.out.println("CHAL JAA BHAI");
//            System.out.println(row.getText());
//            row.findElement((By.cssSelector("td:nth-of-type(4)"))).findElement(By.id("edit-unit")).click();
//            Thread.sleep(1000);
//        }
//    }

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
            row.getCell(cellHeader.get("runmode")).toString().equals("Y");
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

    @Test
    public void createUnitWithBlankData() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        WebElement addUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
        addUnitButton.click();
        WebElement saveDetailButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='test-submit-button']")));
        saveDetailButton.click();
        WebElement errorOnNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='error invalid-feedback'])[1]")));
        System.out.println(errorOnNameField.getText());
        Assert.assertEquals("Name is required", errorOnNameField.getText());
        WebElement errorOnUnitFiels = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class='error invalid-feedback'])[2]")));
        System.out.println(errorOnUnitFiels.getText());
        Assert.assertEquals("unit name is required", errorOnUnitFiels.getText());

    }

    @Test
    public void d_deleteOneUnitButton() throws Exception {
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");
        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

        dataList = read(wb, "Unit");
        ip.close();
        for (Map<String, String> dataMap : dataList) {
            deleteOneUnitFromMultipleUnits(dataMap);
        }
    }

    public void deleteOneUnitFromMultipleUnits(Map<String, String> dataMap) throws InterruptedException, Exception {

        WebDriverWait wait = new WebDriverWait(driver, 50);
        String name = "";

        String name1 = "";
        String name2 = "";
        String name3 = "";

        String aliases1 = "";
        String aliases2 = "";
        String aliases3 = "";


        String selectedField = "";
        String deletedUnit = "";
        Set<String> mapKeys = dataMap.keySet();
        for (String s : mapKeys) {
            System.out.println("s = " + s);
            if (s.equals("selectedField")) {
                selectedField = dataMap.get(s);
            }
            if (s.equals("deletedUnit")) {
                deletedUnit = dataMap.get(s);
            }
            if (s.equals("name")) {
                name = dataMap.get(s);
            }

            if (s.equals("name1")) {
                name1 = dataMap.get(s);
            }
            if (s.equals("name2")) {
                name2 = dataMap.get(s);
            }
            if (s.equals("name3")) {
                name3 = dataMap.get(s);
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
        }

        WebElement addUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
        addUnitButton.click();
        Select selectVertical = new Select(driver.findElement(By.cssSelector("[data-test='test-vertical-input']")));
        selectVertical.selectByVisibleText(selectedField);
        WebElement addName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='test--unit-name']")));
        addName.sendKeys(name);
        WebElement addUnits = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[1]")));
        addUnits.sendKeys(name1);
        WebElement addAliases1 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[1]"));
        addAliases1.sendKeys(aliases1);
        addAliases1.sendKeys(Keys.ENTER);

        if (!name2.trim().isEmpty()) {
            WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@class='mx-1 btn btn-secondary btn-sm'])"));
            clickOnPlusButton.click();
            WebElement addUnits2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[2]")));
            addUnits2.sendKeys(name2);
            WebElement addAliases2 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[2]"));
            addAliases2.sendKeys(aliases2);
            addAliases2.sendKeys(Keys.ENTER);
        }

        if (!name3.trim().isEmpty()) {
            WebElement clickOnPlusButton = driver.findElement(By.xpath("(//button[@class='mx-1 btn btn-secondary btn-sm'])"));
            clickOnPlusButton.click();
            WebElement addUnits3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@data-test='test-unitName'])[3]")));
            addUnits3.sendKeys(name3);
            WebElement addAliases3 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[3]"));
            addAliases3.sendKeys(aliases3);
            addAliases3.sendKeys(Keys.ENTER);
        }


       // Thread.sleep(1000);
        boolean isPresent = driver.findElement(By.xpath("//*[@value='" + deletedUnit + "']")).isDisplayed();
        System.out.println(isPresent);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@value='" + deletedUnit + "']")).isDisplayed());
        WebElement element2 = driver.findElement(By.xpath("//input[@value='" + deletedUnit + "']/../../../../preceding-sibling::div[1]/button"));
        element2.click();
       // Thread.sleep(2000);
        boolean eleDisplayed = isElementPresent(By.xpath("//*[@value='" + deletedUnit + "']"));
        Assert.assertEquals(eleDisplayed, false);

        WebElement saveDetailButton = driver.findElement(By.cssSelector("[data-test='test-submit-button']"));
        saveDetailButton.click();
        WebElement createMessageOnAddUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
        System.out.println(createMessageOnAddUnit.getText());
        Assert.assertEquals("Meta data saved successfully", createMessageOnAddUnit.getText());
        Thread.sleep(2000);
        verifyUnit();
        String vertical = driver.findElement(By.cssSelector("[data-test='test-vertical-input']")).getAttribute("value");
        Assert.assertEquals(vertical, selectedField);
        String nameVerify = driver.findElement(By.cssSelector("[data-test='test--unit-name']")).getAttribute("value");
        Assert.assertEquals(nameVerify, name);
        String name1Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[1]")).getAttribute("value");
        Assert.assertEquals(name1Verify, name1);

        if(isElementPresent(By.xpath("(//input[@data-test='test-unitName'])[2]"))){
            String name2Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[2]")).getAttribute("value");
            Assert.assertEquals(name2Verify, name2);
        }

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
        if(isElementPresent(By.xpath("(//input[@data-test='test-unitName'])[3]"))){
            String name3Verify = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[3]")).getAttribute("value");
            Assert.assertEquals(name3Verify, name3);
        }

    }

//    @Test
//    public void d_deleteUnit() throws Exception {
//
//        WebDriverWait wait = new WebDriverWait(driver, 50);
//
//        String selectedField = "";
//        String name = "";
//        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");
//
//        Workbook wb = WorkbookFactory.create(ip);
//        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
//        dataList = read(wb, "Unit");
//        for (Map<String, String> dataMap : dataList) {
//            Set<String> mapKeys = dataMap.keySet();
//            for (String s : mapKeys) {
//                if (s.equals("name")) {
//                    name = dataMap.get(s);
//                }
//
//                if (s.equals("selectedField")) {
//                    selectedField = dataMap.get(s);
//                }
//            }
//            ip.close();
//
//            List<WebElement> rowSize =
//                    driver.findElements(By.xpath("*//table/tbody/tr"));
//            WebElement row = null;
//            for (int i = 0; i < rowSize.size(); i++) {
//                String col1 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(1)"))).getText();
//                String col2 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText();
//                if (col1.equals(selectedField) && col2.equals(name)) {
//                    System.out.println(col1 + "  " + col2);
//                    row = rowSize.get(i);
//                    break;
//                }
//            }
//            System.out.println("CHAL JAA BHAI");
//            System.out.println(row.getText());
//            row.findElement((By.cssSelector("td:nth-of-type(4)"))).findElement(By.id("delete-unit")).click();
//            WebElement deleteUnit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='swal2-confirm swal2-styled']")));
//            deleteUnit.click();
//            WebElement deletePopUpOnDeleteUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
//            System.out.println(deletePopUpOnDeleteUnit.getText());
//            Assert.assertEquals("Unit Deleted successfully", deletePopUpOnDeleteUnit.getText());
//            Thread.sleep(5000);
////            WebElement searchUnitName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='form-control']")));
////            searchUnitName.click();
////            searchUnitName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
////            searchUnitName.clear();
////            searchUnitName.sendKeys(name);
////            WebElement msgOnPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='react-bs-table-no-data']")));
////            System.out.println(msgOnPage.getText());
////            Assert.assertEquals("No Data Found", msgOnPage.getText());
//        }
//    }

    @Test
    public void b_editVerticalAndName() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 50);

        String updatedUnitName = "";
        String selectedField = "";
        String name = "";
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");

        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        dataList = read(wb, "Unit");
        for (Map<String, String> dataMap : dataList) {
            Set<String> mapKeys = dataMap.keySet();
            for (String s : mapKeys) {
                //  System.out.println("s = " + s);
                if (s.equals("name")) {
                    name = dataMap.get(s);
                }

                if (s.equals("selectedField")) {
                    selectedField = dataMap.get(s);
                }
                if (s.equals("updatedUnitName")) {
                    updatedUnitName = dataMap.get(s);
                }
            }
            ip.close();

            List<WebElement> rowSize =
                    driver.findElements(By.xpath("*//table/tbody/tr"));
            WebElement row = null;
            for (int i = 0; i < rowSize.size(); i++) {
                String col1 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(1)"))).getText();
                String col2 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText();
                if (col1.equals(selectedField) && col2.equals(name)) {
                    System.out.println(col1 + "  " + col2);
                    row = rowSize.get(i);
                    break;
                }
            }
            System.out.println("CHAL JAA BHAI");
            System.out.println(row.getText());
            row.findElement((By.cssSelector("td:nth-of-type(4)"))).findElement(By.id("edit-unit")).click();
            WebElement editVertical = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-test='test-vertical-input']")));
            Assert.assertFalse(editVertical.isEnabled());

            WebElement editName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='test--unit-name']")));
            editName.click();
            editName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            editName.clear();
            editName.sendKeys(updatedUnitName);
            WebElement editUnits = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='test-unitName']")));
            editUnits.click();
            String editName1 = editName.getAttribute("value");

            WebElement editPopUpOnEditUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
            System.out.println(editPopUpOnEditUnit.getAttribute("value"));
            Assert.assertEquals("unit name updated successfully", editPopUpOnEditUnit.getText());

            Assert.assertEquals(editName1, updatedUnitName);

            WebElement clickOnBackButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn btn-info ml-1']")));
            clickOnBackButton.click();
          //  Thread.sleep(2000);
            verifyUnit();
            String vertical = driver.findElement(By.cssSelector("[data-test='test-vertical-input']")).getAttribute("value");
            Assert.assertEquals(vertical, selectedField);
            String nameVerify = driver.findElement(By.cssSelector("[data-test='test--unit-name']")).getAttribute("value");
            Assert.assertEquals(nameVerify, name);
        }
    }

    @Test
    public void a_addDeletedUnit() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 50);

        String selectedField = "";
        String name = "";
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");

        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        dataList = read(wb, "Unit");
        for (Map<String, String> dataMap : dataList) {
            Set<String> mapKeys = dataMap.keySet();
            for (String s : mapKeys) {
                //  System.out.println("s = " + s);
                if (s.equals("name")) {
                    name = dataMap.get(s);
                }

                if (s.equals("selectedField")) {
                    selectedField = dataMap.get(s);
                }
            }
            ip.close();

            List<WebElement> rowSize =
                    driver.findElements(By.xpath("*//table/tbody/tr"));
            WebElement row = null;
            for (int i = 0; i < rowSize.size(); i++) {
                String col1 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(1)"))).getText();
                String col2 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText();
//            System.out.println(rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText());
//            System.out.println(col1 + "  " + col2);
                if (col1.equals(selectedField) && col2.equals(name)) {
                    System.out.println(col1 + "  " + col2);
                    row = rowSize.get(i);
                    break;
                }
            }
            System.out.println("CHAL JAA BHAI");
            System.out.println(row.getText());
            row.findElement((By.cssSelector("td:nth-of-type(4)"))).findElement(By.id("delete-unit")).click();
            WebElement deleteUnit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='swal2-confirm swal2-styled']")));
            deleteUnit.click();
            WebElement deletePopUpOnDeleteUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
            System.out.println(deletePopUpOnDeleteUnit.getText());
            Assert.assertEquals("Unit Deleted successfully", deletePopUpOnDeleteUnit.getText());
            Thread.sleep(5000);
            for (Map<String, String> dataMap1 : dataList) {
                addUnit(dataMap1);
            }


        }
    }

    @Test
    public void clickingOnBackButton() throws Exception {
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");
        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();

        dataList = read(wb, "Unit");
        ip.close();
        for (Map<String, String> dataMap : dataList) {
            checkingBackButton(dataMap);
        }
    }

    public  void checkingBackButton(Map<String, String> dataMap) throws InterruptedException, Exception {

        WebDriverWait wait = new WebDriverWait(driver, 50);
        String name = "";

        String unit1 = "";


        String aliases1 = "";

        String selectedField = "";
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

            if (s.equals("aliases1")) {
                aliases1 = dataMap.get(s);
            }


        }

        //   Reporter.log("Test case start for " + selectedField);
        WebElement addUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
        addUnitButton.click();
        Select selectVertical = new Select(driver.findElement(By.cssSelector("[data-test='test-vertical-input']")));
        selectVertical.selectByVisibleText(selectedField);
        WebElement addName = driver.findElement(By.cssSelector("[data-test='test--unit-name']"));
        addName.sendKeys(name);
        WebElement addUnits = driver.findElement(By.xpath("(//input[@data-test='test-unitName'])[1]"));
        addUnits.sendKeys(unit1);
        WebElement addAliases1 = driver.findElement(By.xpath("(//input[starts-with(@id,'react-select')])[1]"));
        addAliases1.sendKeys(aliases1);
        addAliases1.sendKeys(Keys.ENTER);

        WebElement clickOnBackButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='btn btn-info ml-1']")));
        clickOnBackButton.click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='btn btn-primary']")).isDisplayed());
//        WebElement searchUnitName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='form-control']")));
//        searchUnitName.click();
//        searchUnitName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//        searchUnitName.clear();
//        searchUnitName.sendKeys(name);
//        WebElement msgOnPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='react-bs-table-no-data']")));
//        System.out.println(msgOnPage.getText());
//        Assert.assertEquals("No Data Found", msgOnPage.getText());

    }

    @Test
    public void checkNavigationButton() throws Exception{
        List<WebElement> rows = driver.findElements(By.xpath("*//table/tbody/tr"));
        int count = rows.size();
        System.out.println(count);
        if(count<10){
            WebElement navigationButton1 = driver.findElement(By.xpath("//button[@class='btn btn-icon btn-sm btn-primary mr-2 my-1'][1]"));
            Assert.assertTrue(navigationButton1.isEnabled());

            WebElement navigationButton2 = driver.findElement(By.xpath("//button[@class='btn btn-icon btn-sm btn-primary mr-2 my-1'][2]"));
            Assert.assertFalse(navigationButton2.isEnabled());
        }else {
            WebElement navigationButton1 = driver.findElement(By.xpath("//button[@class='btn btn-icon btn-sm btn-primary mr-2 my-1'][1]"));
            Assert.assertTrue(navigationButton1.isEnabled());

            WebElement navigationButton2 = driver.findElement(By.xpath("//button[@class='btn btn-icon btn-sm btn-primary mr-2 my-1'][2]"));
            Assert.assertTrue(navigationButton2.isEnabled());
            navigationButton2.click();
            Assert.assertTrue(rows.size()>0);

        }
    }

    @Test(enabled = false)
    public void createUnitWithBlankUnit() throws Exception {
        String name = "";
        String selectedField = "";
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");

        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        dataList = read(wb, "Unit");
        for (Map<String, String> dataMap : dataList) {
            Set<String> mapKeys = dataMap.keySet();
            for (String s : mapKeys) {
                if (s.equals("name")) {
                    name = dataMap.get(s);
                }
                if (s.equals("selectedField")) {
                    selectedField = dataMap.get(s);
                }

            }
            ip.close();
            WebDriverWait wait = new WebDriverWait(driver, 50);
            WebElement addUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
            addUnitButton.click();
            Select selectVertical = new Select(driver.findElement(By.cssSelector("[data-test='test-vertical-input']")));
            selectVertical.selectByVisibleText(selectedField);
            WebElement addName = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='test--unit-name']")));
            addName.sendKeys(name);
            WebElement saveDetailButton = driver.findElement(By.cssSelector("[data-test='test-submit-button']"));
            saveDetailButton.click();
            WebElement errorOnUnitFied = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='error invalid-feedback']")));
            System.out.println(errorOnUnitFied.getText());
            Assert.assertEquals("unit name is required", errorOnUnitFied.getText());

        }

    }


    @Test(enabled = false)
    public void createUnitWithBlankName() throws Exception {
        String unit1 = "";
        String selectedField = "";
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");

        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        dataList = read(wb, "Unit");
        for (Map<String, String> dataMap : dataList) {
            Set<String> mapKeys = dataMap.keySet();
            for (String s : mapKeys) {
                if (s.equals("unit1")) {
                    unit1 = dataMap.get(s);
                }
                if (s.equals("selectedField")) {
                    selectedField = dataMap.get(s);
                }
            }
            ip.close();
            driver.get("http://localhost:3000/");
            WebDriverWait wait = new WebDriverWait(driver, 50);
            WebElement addUnitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-primary']")));
            addUnitButton.click();
            Select selectVertical = new Select(driver.findElement(By.cssSelector("[data-test='test-vertical-input']")));
            selectVertical.selectByVisibleText(selectedField);
            WebElement saveDetailButton = driver.findElement(By.cssSelector("[data-test='test-submit-button']"));
            saveDetailButton.click();
            WebElement addUnits = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-test='test-unitName']")));
            addUnits.sendKeys(unit1);
            WebElement errorOnNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='error invalid-feedback']")));
            System.out.println(errorOnNameField.getText());
            Assert.assertEquals("Name is required", errorOnNameField.getText());

        }

    }

    @Test
    public void d_deleteUnit() throws Exception {

        WebDriverWait wait = new WebDriverWait(driver, 50);

        String selectedField = "";
        String name = "";
        FileInputStream ip = new FileInputStream("D:\\code\\Selenium-testng\\demo\\src\\test\\resources\\excel\\unit.xlsx");

        Workbook wb = WorkbookFactory.create(ip);
        List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
        dataList = read(wb, "Unit");
        for (Map<String, String> dataMap : dataList) {
            Set<String> mapKeys = dataMap.keySet();
            for (String s : mapKeys) {
                if (s.equals("name")) {
                    name = dataMap.get(s);
                }

                if (s.equals("selectedField")) {
                    selectedField = dataMap.get(s);
                }
            }
            ip.close();

//            List<WebElement> rowSize =
//                    driver.findElements(By.xpath("*//table/tbody/tr"));
//            WebElement row = null;
//            for (int i = 0; i < rowSize.size(); i++) {
//                String col1 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(1)"))).getText();
//                String col2 = rowSize.get(i).findElement((By.cssSelector("td:nth-of-type(2)"))).getText();
//                if (col1.equals(selectedField) && col2.equals(name)) {
//                    System.out.println(col1 + "  " + col2);
//                    row = rowSize.get(i);
//                    break;
//                }
//            }
//            System.out.println("CHAL JAA BHAI");
//            System.out.println(row.getText());
//            row.findElement((By.cssSelector("td:nth-of-type(4)"))).findElement(By.id("delete-unit")).click();
            WebElement deleteButton = driver.findElement(By.xpath("//tbody/tr/td[text()='"+ selectedField +"']/../../tr/td[text()='"+ name +"']/following-sibling::td/div/button[@id='delete-unit']"));
            deleteButton.click();
            WebElement deleteUnit = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class='swal2-confirm swal2-styled']")));
            deleteUnit.click();
            Thread.sleep(200);
            WebElement popUpOnDeleteUnit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("swal2-title")));
            System.out.println(popUpOnDeleteUnit.getText());
            org.junit.Assert.assertEquals("Unit Deleted successfully", popUpOnDeleteUnit.getText());
            Thread.sleep(5000);
            boolean eleDisplayed = isElementPresent(By.xpath("//tbody/tr/td[text()='"+ selectedField +"']/../../tr/td[text()='"+ name +"']/following-sibling::td/div/button[@id='delete-unit']"));
            Assert.assertEquals(eleDisplayed, false);
        //    Assert.assertFalse(isElementPresent(By.xpath("//tbody/tr/td[text()='"+ selectedField +"']/../../tr/td[text()='"+ name +"']/following-sibling::td/div/button[@id='delete-unit']")));
//            WebElement searchUnitName = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='form-control']")));
//            searchUnitName.click();
//            searchUnitName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
//            searchUnitName.clear();
//            searchUnitName.sendKeys(name);
//            WebElement msgOnPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='react-bs-table-no-data']")));
//            System.out.println(msgOnPage.getText());
//            Assert.assertEquals("No Data Found", msgOnPage.getText());
        }
    }
}
