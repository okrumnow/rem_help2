package com.appspot.remhelp.client.core.view;

import java.util.Map;

import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.appspot.remhelp.client.core.presenter.MainPageUiHandler;
import com.appspot.remhelp.shared.data.Category;
import com.appspot.remhelp.shared.data.Good;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;

public class Main extends ViewImpl implements MainPagePresenter.MyView {

	private Widget widget;
	private MainPageUiHandler uiHandlers;

	public Main() {
		widget = createLayout();
	}

	private Widget createLayout() {
		VLayout result = new VLayout();
		result.setWidth100();
		result.setHeight100();
		
		HLayout top = new HLayout();
		top.setMargin(10);
		top.setHeight("1em");
		Label labelLeft = new Label("Remanum Hilfe");
		labelLeft.setAlign(Alignment.LEFT);
		top.addMember(labelLeft);
		top.addMember(new LayoutSpacer());
		Label labelRight = new Label("(C)2012 Remanum Help Team");
		labelRight.setOverflow(Overflow.VISIBLE);
		labelRight.setAlign(Alignment.RIGHT);
		labelRight.setSize("300px", "1em");
		top.addMember(labelRight);
		
		result.addMember(top);
		return result;
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setGoodsTree(Map<Category, Iterable<Good>> goods) {
	}

	@Override
	public void setInSlot(Object slot, Widget content) {
		if (slot == MainPagePresenter.TYPE_SetGoodsDetails) {
		} else {
			super.setInSlot(slot, content);
		}
	}

	private Widget buildTree(Map<Category, Iterable<Good>> goods) {
		TreeGrid result = new TreeGrid();
		for (Category cat : goods.keySet()) {
			for (Good good : goods.get(cat)) {
			}
		}
		return result;
	}

	@Override
	public void setUiHandlers(MainPageUiHandler uiHandlers) {
		this.uiHandlers = uiHandlers;

	}
}
