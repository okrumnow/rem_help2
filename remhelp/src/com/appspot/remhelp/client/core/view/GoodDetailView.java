package com.appspot.remhelp.client.core.view;

import com.appspot.remhelp.client.core.presenter.GoodDetailPresenter;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.tab.Tab;
import com.smartgwt.client.widgets.tab.TabSet;

public class GoodDetailView extends ViewImpl implements
		GoodDetailPresenter.MyView {

	private final Widget widget;
	private Canvas viewLabel;

	@Inject
	public GoodDetailView() {
		widget = getDetails();
	}
	
	private TabSet getDetails() {
		TabSet tabSet = new TabSet();  
        Tab viewTab = new Tab("View");  
  
        viewLabel = new Canvas();  
        viewLabel.setContents("[Record Details can be dispalyed here]");  
        viewTab.setPane(viewLabel);  
  
        Tab editTab = new Tab("Edit");  
  
        Canvas editLabel = new Canvas();  
        editLabel.setContents("[Form for edits can be dispalyed here]");  
        editTab.setPane(editLabel);  
  
        tabSet.setTabs(viewTab, editTab);
		return tabSet;
	}



	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setTitle(String name) {
		viewLabel.setContents(name);
		
	}
}
