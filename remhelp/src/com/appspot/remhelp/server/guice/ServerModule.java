package com.appspot.remhelp.server.guice;

import com.gwtplatform.dispatch.server.guice.HandlerModule;
import com.appspot.remhelp.shared.SendTextToServer;
import com.appspot.remhelp.server.SendTextToServerActionHandler;

public class ServerModule extends HandlerModule {

	@Override
	protected void configureHandlers() {

		bindHandler(SendTextToServer.class, SendTextToServerActionHandler.class);
	}
}
