package data.wintertours.datasource.factory;

import config.Config;
import data.wintertours.datasource.DbWinterToursDataSource;
import data.wintertours.datasource.ExcelWinterToursDataSource;
import data.wintertours.datasource.JsonWinterToursDataSource;
import data.wintertours.datasource.WinterToursDataSource;

public class WinterToursDataSourceFactory {

	public static WinterToursDataSource get() {

		String source = Config.getSource();

		switch (source.trim()) {
		
		case "excel":
			return new ExcelWinterToursDataSource();
		case "json":
			return new JsonWinterToursDataSource();
		case "db":
			return new DbWinterToursDataSource();

		default:
			throw new IllegalArgumentException("Invalid source passed : " + source);
		}
	}

}
