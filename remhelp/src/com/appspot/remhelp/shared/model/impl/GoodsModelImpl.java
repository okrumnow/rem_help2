package com.appspot.remhelp.shared.model.impl;

import java.util.ArrayList;
import java.util.HashMap;

import com.appspot.remhelp.shared.data.Category;
import com.appspot.remhelp.shared.data.Good;
import com.appspot.remhelp.shared.model.GoodsModel;
import com.smartgwt.client.data.DataSource;

public class GoodsModelImpl implements GoodsModel {

	private static final Good OLIVE = new Good() {
		
		@Override
		public String getname() {
			return "Oliven";
		}
	};
	private static final Good OLIVEOIL = new Good() {
		
		@Override
		public String getname() {
			return "Olivenöl";
		}
	};

	@Override
	public DataSource getGoodsByCategories() {
		HashMap<Category, Iterable<Good>> result = new HashMap<Category, Iterable<Good>>();
		ArrayList<Good> foods = new ArrayList<Good>();
		foods.add(OLIVE);
		foods.add(OLIVEOIL);
		result.put(new Category() {
			
			@Override
			public String getName() {
				return "Nahrung";
			}
		}, foods);
		return null;
	}

	@Override
	public Good getGoodByName(String goodName) {
		if (goodName.toLowerCase().equals("olivenöl")) return OLIVEOIL;
		else if (goodName.toLowerCase().equals("oliven")) return OLIVE;
		else throw new IllegalArgumentException("Unknown good '"+goodName+"'");
	}

}
