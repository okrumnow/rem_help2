package com.appspot.remhelp.client.core.presenter;

import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.appspot.remhelp.client.place.NameTokens;
import com.gwtplatform.mvp.client.proxy.PlaceRequest;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.google.inject.Inject;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.appspot.remhelp.shared.data.Good;
import com.appspot.remhelp.shared.model.GoodsModel;

public class GoodDetailPresenter extends
		Presenter<GoodDetailPresenter.MyView, GoodDetailPresenter.MyProxy> {

	private final GoodsModel model;

	public interface MyView extends View {
		void setTitle(String getname);
	}

	@ProxyCodeSplit
	@NameToken(NameTokens.good)
	public interface MyProxy extends ProxyPlace<GoodDetailPresenter> {
	}

	@Inject
	public GoodDetailPresenter(final EventBus eventBus, final MyView view,
			final MyProxy proxy, GoodsModel model) {
		super(eventBus, view, proxy);
		this.model = model;
	}

	@Override
	protected void revealInParent() {
		RevealContentEvent.fire(this, MainPagePresenter.TYPE_SetGoodsDetails, this);
	}
	
	@Override
	public void prepareFromRequest(PlaceRequest request) {
		super.prepareFromRequest(request);
		String goodName = request.getParameter("g", "");
		if (goodName.isEmpty()) throw new IllegalArgumentException("Parameter 'g' is missing");
		Good good = model.getGoodByName(goodName);
		getView().setTitle(good.getname());
	}

	@Override
	protected void onBind() {
		super.onBind();
	}

	@Override
	protected void onReveal() {
		super.onReveal();
	}
}
