package data.wintertours.datasource;

import java.util.ArrayList;
import java.util.List;

import data.wintertours.model.WinterToursData;

public class ExcelWinterToursDataSource implements WinterToursDataSource{

	@Override
	public List<WinterToursData> getData() {

		List<WinterToursData> list = new ArrayList<WinterToursData>();
		list.add(new WinterToursData("khaleef", "khaleef@gmail.com", "9791253589", "Chennai"));
		return list;
	}

}
