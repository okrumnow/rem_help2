package com.appspot.remhelp.client.core.view;

import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
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
}
