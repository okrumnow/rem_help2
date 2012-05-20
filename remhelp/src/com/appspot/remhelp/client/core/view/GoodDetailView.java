package com.appspot.remhelp.client.core.view;

import com.appspot.remhelp.client.core.presenter.GoodDetailPresenter;
import com.appspot.remhelp.client.core.presenter.GoodDetailPresenter.MyView;
import com.gwtplatform.mvp.client.ViewImpl;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

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
}
