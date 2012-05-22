package com.appspot.remhelp.client.core.view;

import com.appspot.remhelp.client.core.presenter.GoodDetailPresenter;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.VLayout;

public class GoodDetailView extends ViewImpl implements
		GoodDetailPresenter.MyView {

	private final Widget widget;
	private Canvas viewLabel;

	@Inject
	public GoodDetailView() {
		widget = getDetails();
	}
	
	private Widget getDetails() {
		VLayout result = new VLayout();
		result.setOverflow(Overflow.AUTO);
		
		result.addMember(new BlueBox(null, 200, "Box 1"));
		viewLabel = new BlueBox(null, 100, "Box 2");
		result.addMember(viewLabel);
		result.addMember(new BlueBox(null, 600, "Box 3"));
		result.addMember(new BlueBox(null, 200, "Box 4"));
		
		return result;
	}



	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setTitle(String name) {
		viewLabel.setContents(name);
		
	}
	
	class BlueBox extends Label {  
		  
        public BlueBox(String contents) {  
            setAlign(Alignment.CENTER);  
            setBorder("1px solid #808080");  
            setBackgroundColor("#C3D9FF");  
            setContents(contents);  
        }  
  
        public BlueBox(Integer width, Integer height, String contents) {  
            this(contents);  
            if (width != null) setWidth(width);  
            if (height != null) setHeight(height);  
        }  
    }  
}
