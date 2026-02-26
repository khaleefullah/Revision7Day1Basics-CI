package testcases;

import pages.*;
import base.BaseTest;
import data.wintertours.dataprovider.WinterToursDataProvider;
import data.wintertours.model.WinterToursData;

import org.testng.annotations.Test;

public class WinterToursTest extends BaseTest {

	@Test(dataProviderClass = WinterToursDataProvider.class, dataProvider = "dp")
	public void winterToursTest(WinterToursData data) throws InterruptedException {

		HomePage homePage = new HomePage(driver);
		homePage.openWinterToursPage().fillForm(data);
		Thread.sleep(2000);
	}

}
