package com.appspot.remhelp.client.core.presenter;

import java.util.Map;

import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.appspot.remhelp.client.place.NameTokens;
import com.appspot.remhelp.shared.data.Category;
import com.appspot.remhelp.shared.data.Good;
import com.appspot.remhelp.shared.model.GoodsModel;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.GwtEvent.Type;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;
import com.gwtplatform.mvp.client.proxy.RevealRootLayoutContentEvent;

public class MainPagePresenter extends
		Presenter<MainPagePresenter.MyView, MainPagePresenter.MyProxy>
		implements MainPageUiHandler {

	public interface MyView extends View, HasUiHandlers<MainPageUiHandler> {
		void setGoodsTree(Map<Category, Iterable<Good>> goods);
	}

	@ProxyStandard
	@NameToken(NameTokens.main)
	public interface MyProxy extends ProxyPlace<MainPagePresenter> {
	}

	@ContentSlot
	public static final Type<RevealContentHandler<?>> TYPE_SetGoodsDetails = new Type<RevealContentHandler<?>>();

	private final PlaceManager placeManager;
	private final GoodsModel model;

	@Inject
	public MainPagePresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, final PlaceManager placeManager,
			final GoodsModel model) {
		super(eventBus, view, proxy);

		this.placeManager = placeManager;
		this.model = model;

		getView().setUiHandlers(this);
	}

	@Override
	protected void revealInParent() {
		RevealRootLayoutContentEvent.fire(this, this);
	}

	@Override
	protected void onBind() {
		super.onBind();
		// registerHandler(getView().getSendClickHandlers().addClickHandler(
		// new ClickHandler() {
		// @Override
		// public void onClick(ClickEvent event) {
		// sendNameToServer();
		// }
		// }));
	}

	@Override
	protected void onReset() {
		super.onReset();
		getView().setGoodsTree(model.getGoodsByCategories());
	}

	@Override
	public void showGoodsDetails(String good) {
		PlaceRequest request = new PlaceRequest(NameTokens.good);
		request = request.with("g", good);
		placeManager.revealPlace(request);
	}

}
