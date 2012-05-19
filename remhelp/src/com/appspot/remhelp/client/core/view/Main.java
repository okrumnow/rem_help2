package com.appspot.remhelp.client.core.view;

import java.util.Map;

import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.appspot.remhelp.shared.data.Category;
import com.appspot.remhelp.shared.data.Good;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.StackLayoutPanel;

public class Main extends ViewImpl implements MainPagePresenter.MyView {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);
	@UiField StackLayoutPanel stack;

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	private Widget widget;

	public Main() {
		widget = uiBinder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setGoodsTree(Map<Category, Iterable<Good>> goods) {
		stack.clear();
		stack.add(buildTree(goods), new HTML("Goods"), 25.0);
	}

	private Widget buildTree(Map<Category, Iterable<Good>> goods) {
		Tree result = new Tree();
		for (Category cat : goods.keySet()) {
			TreeItem catNode = new TreeItem(cat.getName());
			for (Good good : goods.get(cat)) {
				TreeItem goodNode = new TreeItem(good.getname());
				catNode.addItem(goodNode);
			}
			result.addItem(catNode);
		}
		return result;
	}
}
