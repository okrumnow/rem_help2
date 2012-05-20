package com.appspot.remhelp.shared.model.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.appspot.remhelp.shared.data.Category;
import com.appspot.remhelp.shared.data.Good;
import com.appspot.remhelp.shared.model.GoodsModel;

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
	public Map<Category, Iterable<Good>> getGoodsByCategories() {
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
		return result;
	}

	@Override
	public Good getGoodByName(String goodName) {
		if (goodName == "oliveoil") return OLIVEOIL;
		else if (goodName == "olive") return OLIVE;
		else throw new IllegalArgumentException("Unknown good '"+goodName+"'");
	}

}
