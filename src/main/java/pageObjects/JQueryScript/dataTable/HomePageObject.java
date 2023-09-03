package pageObjects.JQueryScript.dataTable;

import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIsJQueryScript.HomePageUIdataTable;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void paginationByPageNumber(WebDriver driver, String pageNumber) {
		waitForElementVisible(driver, HomePageUIdataTable.PAGINATION_BY_PAGE_NUMBER_LINK, pageNumber);
		clickToElement(driver, HomePageUIdataTable.PAGINATION_BY_PAGE_NUMBER_LINK, pageNumber);
	}
	public boolean isPageNumberActive(WebDriver driver, String pageNumber)
	{
		waitForElementVisible(driver, HomePageUIdataTable.PAGINATION_PAGE_ACTIVED_BY_NUMBER_LINK, pageNumber);
		return isElementDisplayed(driver, HomePageUIdataTable.PAGINATION_PAGE_ACTIVED_BY_NUMBER_LINK, pageNumber);
	}
	public void inputToDynamicTextbox(String value, String textboxName) {
		waitForElementVisible(driver, HomePageUIdataTable.DYNAMIC_TEXTBOX,textboxName);
		sendKeyToElement(driver, HomePageUIdataTable.DYNAMIC_TEXTBOX,  value, textboxName);
		pressKeyToElement (driver,HomePageUIdataTable.DYNAMIC_TEXTBOX, Keys.ENTER, textboxName);
	}
	public void inputToFemalesNumberTextbox(String femalesNumber) {
		inputToDynamicTextbox(femalesNumber, "Females");
	}
	public void inputToCountryTextbox(String countryName) {
		inputToDynamicTextbox(countryName, "Country");
	}
	public void inputToMalesNumberTextbox(String malesNumber) {
		inputToDynamicTextbox(malesNumber, "Males");
	}
	public void inputToTotalNumberTextbox(String totalNumber) {
		inputToDynamicTextbox(totalNumber, "Total");
	}
	public List<String> getValueEachRowAtAllPage()
	{
		int totalPage = getElementSize(driver, HomePageUIdataTable.TOTAL_PAGINATION);
		
		List<String> allRowValueAllPage = new ArrayList<String>();

		for (int index = 1; index <= totalPage; index++)
		{
			clickToElement(driver, HomePageUIdataTable.PAGINATION_BY_PAGE_INDEX, String.valueOf(index));
			sleepInSecond(5);
			
			List<WebElement> allRowElementEachPage = getElements(driver, HomePageUIdataTable.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage)
			{
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		for (String value : allRowValueAllPage)
		{
			System.out.println("-----------------------");
			System.out.println(value);
		}
		return allRowValueAllPage;
	}
	public void inputToTextboxByIndexRowAndColumn(String value, String indexRow, String indexColumn) 
	{
		waitForElementVisible(driver, HomePageUIdataTable.TEXTBOX_BY_INDEX_ROW_AND_COMLUMN, indexRow, indexColumn);
		sendKeyToElement(driver, HomePageUIdataTable.TEXTBOX_BY_INDEX_ROW_AND_COMLUMN, value, indexRow, indexColumn);
	}
	public void inputToCompanyTextbox(String value, String indexRow)
	{
		inputToTextboxByIndexRowAndColumn(value, indexRow, "1");
	}
	public void inputToContactPersonTextbox(String value, String indexRow)
	{
		inputToTextboxByIndexRowAndColumn(value, indexRow, "2");
	}
	public void inputToOrderPlacedTextbox(String value, String indexRow)
	{
		inputToTextboxByIndexRowAndColumn(value, indexRow, "5");
	}
	public void selectValueAtCountryDropDown(String textItem, String indexRow) {
		waitForElementVisible(driver, HomePageUIdataTable.COUNTRY_DROPDOWN, indexRow, "3");
		selectItemInDefaultDropDown(driver, HomePageUIdataTable.COUNTRY_DROPDOWN, textItem, indexRow, "3");
	}
	public void checkAtNPOCheckbox(String indexRow) {
		waitForElementVisible(driver, HomePageUIdataTable.NPO_CHECKBOX, indexRow, "4");
		checkToDefaultCheckboxRadio(driver, HomePageUIdataTable.NPO_CHECKBOX, indexRow, "4");
	}
	public void selectMemberSinceDatetimePicker(String value, String indexRow) {
		inputToTextboxByIndexRowAndColumn(value, indexRow, "6");
	}
	public void clickToButtonByNameAndIndexRow(String buttonName, String indexRow) {
		waitForElementClickable(driver, HomePageUIdataTable.BUTTON_BY_FUNCTION_AND_INDEX_ROW, buttonName, indexRow);
		clickToElement(driver, HomePageUIdataTable.BUTTON_BY_FUNCTION_AND_INDEX_ROW, buttonName, indexRow);
	}
	public void inserRowAbove(String indexRow) {
		clickToButtonByNameAndIndexRow("insert", indexRow);
	}
	public void removeCurrentRow(String indexRow) {
		clickToButtonByNameAndIndexRow("remove", indexRow);
	}
	public void moveUp(String indexRow) {
		clickToButtonByNameAndIndexRow("moveUp", indexRow);
	}
	public void moveDown(String indexRow) {
		clickToButtonByNameAndIndexRow("moveDown", indexRow);
	}
	
	
}
