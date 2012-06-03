package com.appspot.remhelp.shared.model;

import com.appspot.remhelp.shared.data.Good;
import com.smartgwt.client.data.DataSource;

public interface GoodsModel {

	DataSource getGoodsByCategories();

	Good getGoodByName(String goodName);
}
