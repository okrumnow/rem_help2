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
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.LayoutSpacer;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;

public class Main extends ViewImpl implements MainPagePresenter.MyView {

	private Widget widget;
	private MainPageUiHandler uiHandlers;
	private VLayout detailPane;
	private Canvas lastMember;

	public Main() {
		widget = createLayout();
	}

	private Widget createLayout() {
		VLayout result = new VLayout();
		result.setMargin(10);
		result.setBackgroundColor("yellow");
		result.setWidth100();
		result.setHeight100();
		
		HLayout top = new HLayout();
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
		
		HLayout center = new HLayout();
		
		SectionStack navigation = new SectionStack();
		navigation.setHeight100();
		navigation.setWidth(400);
		navigation.setShowResizeBar(true);

		SectionStackSection goodsSection = new SectionStackSection();
		goodsSection.setTitle("Waren");
		goodsSection.setExpanded(true);
		
		navigation.addSection(goodsSection);
		
		detailPane = new VLayout();
		detailPane.setBackgroundColor("orange");

		center.addMember(navigation);
		center.addMember(detailPane);
		
		result.addMember(top);
		result.addMember(center);
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
			if (lastMember != null) {
				detailPane.removeMember(lastMember);
			}
			lastMember = (Canvas) content;
			detailPane.addMember(lastMember);
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
