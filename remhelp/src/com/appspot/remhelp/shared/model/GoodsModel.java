package com.appspot.remhelp.shared.model;

import java.util.Map;

import com.appspot.remhelp.shared.data.Category;
import com.appspot.remhelp.shared.data.Good;

public interface GoodsModel {

	Map<Category, Iterable<Good>> getGoodsByCategories();
}
