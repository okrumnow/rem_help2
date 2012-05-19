package com.appspot.remhelp.client.gin;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import com.appspot.remhelp.client.place.ClientPlaceManager;
import com.appspot.remhelp.client.place.DefaultPlace;
import com.appspot.remhelp.client.place.NameTokens;
import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.appspot.remhelp.client.core.presenter.ResponsePresenter;
import com.appspot.remhelp.client.core.view.Main;
import com.appspot.remhelp.client.core.view.ResponseView;

public class ClientModule extends AbstractPresenterModule {

	@Override
	protected void configure() {
		install(new DefaultModule(ClientPlaceManager.class));

		bindPresenter(MainPagePresenter.class, MainPagePresenter.MyView.class,
				Main.class, MainPagePresenter.MyProxy.class);

		bindConstant().annotatedWith(DefaultPlace.class).to(NameTokens.main);

		bindPresenter(ResponsePresenter.class, ResponsePresenter.MyView.class,
				ResponseView.class, ResponsePresenter.MyProxy.class);
	}
}
