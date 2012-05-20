package com.appspot.remhelp.client.core.view;

import com.appspot.remhelp.client.core.presenter.GoodDetailPresenter;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.InlineHTML;

public class GoodDetailView extends ViewImpl implements
		GoodDetailPresenter.MyView {

	private final Widget widget;

	public interface Binder extends UiBinder<Widget, GoodDetailView> {
	}

	@Inject
	public GoodDetailView(final Binder binder) {
		widget = binder.createAndBindUi(this);
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setTitle(String name) {
		title.setHTML(name);
		
	}
	@UiField InlineHTML title;
}
