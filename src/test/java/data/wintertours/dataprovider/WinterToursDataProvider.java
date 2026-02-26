package data.wintertours.dataprovider;

import data.wintertours.datasource.WinterToursDataSource;
import data.wintertours.datasource.factory.WinterToursDataSourceFactory;
import org.testng.annotations.DataProvider;

public class WinterToursDataProvider {

	@DataProvider(name="dp")
	public Object[][] getData() {

		WinterToursDataSource winterToursDataSource = WinterToursDataSourceFactory.get();

		return winterToursDataSource.getData().stream().map(d -> new Object[] { d }).toArray(Object[][]::new);
	}

}
