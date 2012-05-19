package com.appspot.remhelp.client.gin;

import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.appspot.remhelp.client.core.view.Main;
import com.appspot.remhelp.client.place.ClientPlaceManager;
import com.appspot.remhelp.client.place.DefaultPlace;
import com.appspot.remhelp.client.place.NameTokens;
import com.appspot.remhelp.shared.model.GoodsModel;
import com.appspot.remhelp.shared.model.impl.GoodsModelImpl;
import com.google.inject.Singleton;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
				Main.class, MainPagePresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.main);
		
		bind(GoodsModel.class).to(GoodsModelImpl.class).in(Singleton.class);
	}
}
