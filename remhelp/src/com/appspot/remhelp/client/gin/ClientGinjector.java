package com.appspot.remhelp.client.gin;

import com.google.gwt.inject.client.GinModules;
import com.gwtplatform.dispatch.client.gin.DispatchAsyncModule;
import com.appspot.remhelp.client.gin.ClientModule;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.event.shared.EventBus;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.google.inject.Provider;
import com.appspot.remhelp.client.core.presenter.MainPagePresenter;
import com.google.gwt.inject.client.AsyncProvider;
import com.appspot.remhelp.client.core.presenter.GoodDetailPresenter;

@GinModules({ DispatchAsyncModule.class, ClientModule.class })
public interface ClientGinjector extends Ginjector {

	EventBus getEventBus();

	PlaceManager getPlaceManager();

	Provider<MainPagePresenter> getMainPagePresenter();

	AsyncProvider<GoodDetailPresenter> getGoodDetailPresenter();
}
