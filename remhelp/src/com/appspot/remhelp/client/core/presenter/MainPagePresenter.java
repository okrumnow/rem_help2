package com.appspot.remhelp.client.core.presenter;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.appspot.remhelp.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

public class MainPagePresenter extends
		Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy> {

	public interface MyView extends View {
	}

	@ProxyStandard
	@NameToken(NameTokens.main)
	public interface MyProxy extends ProxyPlace<MainPagePresenter> {
	}

	private final PlaceManager placeManager;

	@Inject
	public MainPagePresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final PlaceManager placeManager) {
		super(eventBus, view, proxy);

		this.placeManager = placeManager;
	}

	@Override
	protected void revealInParent() {
		RevealRootLayoutContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
//		registerHandler(getView().getSendClickHandlers().addClickHandler(
//				new ClickHandler() {
//					@Override
//					public void onClick(ClickEvent event) {
//						sendNameToServer();
//					}
//				}));
	}

	@Override
	protected void onReset() {
		super.onReset();
//		getView().resetAndFocus();
	}

}
