package com.appspot.remhelp.client.core.view;

import com.appspot.remhelp.client.core.presenter.GoodDetailPresenter;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.types.Overflow;
import com.smartgwt.client.types.VisibilityMode;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.SectionStack;
import com.smartgwt.client.widgets.layout.SectionStackSection;
import com.smartgwt.client.widgets.layout.VLayout;

public class GoodDetailView extends ViewImpl implements
		GoodDetailPresenter.MyView {

	private final Widget widget;
	private Canvas viewLabel;
	private ListGrid donationGrid;
	private ListGrid cityEquipmentGrid;

	@Inject
	public GoodDetailView() {
		widget = getDetails();
	}
	
	private Widget getDetails() {
		VLayout result = new VLayout();
		result.setOverflow(Overflow.AUTO);
		result.setMembersMargin(10);
		
		viewLabel = new Label("Name der Ware");
		viewLabel.setHeight("1em");
		result.addMember(viewLabel);
		
		SectionStack stack = new SectionStack();
		stack.setVisibilityMode(VisibilityMode.MULTIPLE);
//		result.addMember(getProduction());
//		result.addMember(getManufacturing());
//		result.addMember(getEstateEquipment());
		stack.addSection(buildStack("Instandhaltung", getCityEquipment()));
		stack.addSection(buildStack("Spenden", getCityDonation()));
		result.addMember(stack);
		
		return result;
	}

	private SectionStackSection buildStack(String title, Canvas cancas) {
		SectionStackSection result = new SectionStackSection();
		result.setTitle(title);
		result.addItem(cancas);
		result.setExpanded(true);
		return result;
	}

	private Canvas getCityDonation() {
		VLayout result = new VLayout();
		result.setHeight(100);
		Label label = getHeaderLabel("Diese Ware kann in folgenden Stadtgebäuden für deren Ausbau gespendet werden:");
		result.addMember(label);
		donationGrid = new ListGrid();
		result.addMember(donationGrid);
		return result;
	}

	private Canvas getCityEquipment() {
		VLayout result = new VLayout();
		result.setHeight(100);
		Label label = getHeaderLabel("Diese Ware kann als Instandhaltung in folgenden Stadtgebäuden eingesetzt werden:");
		result.addMember(label);
		cityEquipmentGrid = new ListGrid();
		result.addMember(cityEquipmentGrid);
		return result;
	}

	private Canvas getEstateEquipment() {
		// TODO Auto-generated method stub
		return null;
	}

	private Canvas getManufacturing() {
		// TODO Auto-generated method stub
		return null;
	}

	private Canvas getProduction() {
		// TODO Auto-generated method stub
		return null;
	}

	private Label getHeaderLabel(String text) {
		Label label = new Label(text);
		label.setMargin(10);
		label.setAlign(Alignment.CENTER);
		label.setStyleName("remhelp-goodsdetail-header");
		label.setHeight("1em");
		return label;
	}

	@Override
	public Widget asWidget() {
		return widget;
	}

	@Override
	public void setTitle(String name) {
		viewLabel.setContents(name);
	}
}
