package com.appspot.remhelp.client.core.view;

import java.util.Map;

import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.appspot.remhelp.client.core.presenter.MainPageUiHandler;
import com.appspot.remhelp.shared.data.Category;
import com.appspot.remhelp.shared.data.Good;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class Main extends ViewImpl implements MainPagePresenter.MyView {

	private static MainUiBinder uiBinder = GWT.create(MainUiBinder.class);
	@UiField
	StackLayoutPanel stack;
	@UiField SimplePanel center;

	interface MainUiBinder extends UiBinder<Widget, Main> {
	}

	private Widget widget;
	private MainPageUiHandler uiHandlers;

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

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPagePresenter.TYPE_SetGoodsDetails) {
			center.clear();
			center.add(content);
		} else {
			super.setInSlot(slot, content);
		}
	}

	private Widget buildTree(Map<Category, Iterable<Good>> goods) {
		Tree result = new Tree();
		result.addSelectionHandler(new SelectionHandler<TreeItem>() {

			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				TreeItem item = event.getSelectedItem();
				String good = item.getText();
				uiHandlers.showGoodsDetails(good);
			}
		});
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

	@Override
	public void setUiHandlers(MainPageUiHandler uiHandlers) {
		this.uiHandlers = uiHandlers;

	}
}
