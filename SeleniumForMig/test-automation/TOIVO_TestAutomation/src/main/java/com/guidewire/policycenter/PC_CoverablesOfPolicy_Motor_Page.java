package com.guidewire.policycenter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.guidewire.commonpagefunctions.PC_GenericFunctions;
import com.guidewire.config.PC_CONSTANTS;

public class PC_CoverablesOfPolicy_Motor_Page extends PC_GenericFunctions{

	public PC_CoverablesOfPolicy_Motor_Page(WebDriver driver, ExtentTest test, ExtentReports extent) {
		super(driver, test, extent);
	}

	//Objects
	@FindBy(xpath="//div[contains(@id,'MVIMotorVehicle_LTScreen-ttlBar')]/div[1]/div")
	public WebElement MotorCoverablesOfPolicy_Header;

	@FindBy(xpath="//div[contains(@id,'AddMotorVehicle_LT')]/div")
	public WebElement Add_Button;
	
	@FindBy(xpath="//div[@id='MVIMotorVehicle_LTPopup-MVIMotorVehicle_LTPanelSet-TrafiSearchButtonId']/div")
	public WebElement TrafiSearchLink;
	
	@FindBy(xpath="//div[contains(@id,'OwnerLV_tb-AddDriver-AddExistingContact-0-UnassignedOwner')]/div/div[2]")
	public WebElement ExistingPolicyHolder_Option;
	
	@FindBy(xpath="//div[@id='MVIMotorVehicle_LTPopup-MVIMotorVehicle_LTPanelSet-VehicleOwnerHolderRole-MVIVehicleOwnerHolderRoleDV-OwnerLV_tb-AddDriver-AddExistingContact']/div[1]")
	public WebElement ExistingVehicleOwner_option;
	
	@FindBy(xpath="//div[@id='MVIMotorVehicle_LTPopup-MVIMotorVehicle_LTPanelSet-VehicleOwnerHolderRole-MVIVehicleOwnerHolderRoleDV-OwnerLV_tb-AddDriver']/div[1]")
	public WebElement AddOwner_Dropdown;
	
	String CoverageProposal_DropDown = "//div[@id='MVIMotorVehicle_LTPopup-MVIMotorVehicle_LTPanelSet-ClausePackageListNew']/div/div/select";

	@FindBy(xpath="//div[text()='Bonus']")
	public WebElement Bonus_Button;

	@FindBy(xpath="//div[@id='MVIMotorVehicle_LTPopup-MVIMotorVehicle_LTPanelSet-detailsTab']/div/div[2]")
	public WebElement Basic_Button;

	@FindBy(xpath="//div[contains(@id,'Next')]/div")
	public WebElement Next_Button;

	@FindBy(xpath="//div[contains(@id,'QuoteTypeToolbarButtonSet-Quote')]/div")
	public WebElement Quote_Button;

	@FindBy(xpath="//div[@id='MVIMotorVehicle_LTPopup-MVIMotorVehicle_LTPanelSet-OwnerHolderRoleTab']/div/div[2]")
	public WebElement VehicleRoles_Button;

	@FindBy(xpath="//div[@id='MVIMotorVehicle_LTPopup-MVIMotorVehicle_LTPanelSet-CoverageSummaryTab']/div/div[2]")
	public WebElement Coverages_Button;

	@FindBy(xpath="//div[contains(@id,'Update')]/div")
	public WebElement OK_Button;


	/*
	 * Function to click on tabs
	 */
	public void ClickOnTabs(String TabName) throws Exception {
		WebElement TabToClick = null;
		switch (TabName) {

		case PC_CONSTANTS.PC_NEXT_BUTTON:
			TabToClick = Next_Button;
			break;

		case PC_CONSTANTS.PC_QUOTE_BUTTON:
			TabToClick = Quote_Button;
			break;

		case PC_CONSTANTS.PC_ADD_BUTTON:
			TabToClick = Add_Button;
			break;

		case PC_CONSTANTS.PC_COVERAGES:
			TabToClick = Coverages_Button;
			break;

		case PC_CONSTANTS.PC_OK:
			TabToClick = OK_Button;
			break;

		case PC_CONSTANTS.PC_VEHICLE_ROLES:
			TabToClick = VehicleRoles_Button;
			break;

		case PC_CONSTANTS.PC_BONUS:
			TabToClick = Bonus_Button;
			break;

		case PC_CONSTANTS.PC_BASIC:
			TabToClick = Basic_Button;
			break;

		}  		
		Click_On_Button("", TabToClick, "Clicked on the tab '"+TabName+"'.");
		wait_For_Overlay(2);

	}
	
	/*
	 * Function to select Bonus Dropdown
	 */
	public void SelectBonusDropdown(String OptionToSelect) throws Exception {
		Select_DropDown("Permission to use VVH", OptionToSelect);
		Thread.sleep(1000);
	}

	/*
	 * Function to select Coverage proposal
	 */
	public void SelectCoverageProposal(String OptionToSelect) throws Exception {
		try {
			Select_DropDown("Coverage proposals", OptionToSelect);
		}catch(Exception E) {
			Select_UsingXpath(CoverageProposal_DropDown, OptionToSelect);
		}
		Thread.sleep(5000);
	}
	
	/*
	 * Function to Add owner
	 */
	public void AddOwner() throws InterruptedException {
		Actions actions = new Actions(driver);
		Click_On_Button("", AddOwner_Dropdown);Thread.sleep(2500);
		actions.moveToElement(ExistingVehicleOwner_option).build().perform();
		Thread.sleep(2500);
		Click_On_Button("", ExistingPolicyHolder_Option);
		Thread.sleep(1000);
	}
	
	/*
	 * Function to click on Trafi search link
	 * 
	 */
	public void ClickonTrafiSearchLink() throws Exception {
		Click_On_Button("", TrafiSearchLink);
		wait_For_Overlay(5);
	}
}

