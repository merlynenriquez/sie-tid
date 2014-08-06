package pe.gob.mininter.dirandro.vaadin.panel;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;

public class panelTest extends CustomComponent {

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
	private AbsoluteLayout mainLayout;
	@AutoGenerated
	private Button button_1;
	@AutoGenerated
	private Accordion accordion_1;
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public panelTest() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		// TODO add user code here
	}

	@AutoGenerated
	private AbsoluteLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new AbsoluteLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// accordion_1
		accordion_1 = new Accordion();
		accordion_1.setImmediate(false);
		accordion_1.setWidth("-1px");
		accordion_1.setHeight("-1px");
		mainLayout.addComponent(accordion_1, "top:100.0px;left:540.0px;");
		
		// button_1
		button_1 = new Button();
		button_1.setCaption("Grabar");
		button_1.setImmediate(false);
		button_1.setWidth("-1px");
		button_1.setHeight("26px");
		mainLayout.addComponent(button_1, "top:104.0px;left:300.0px;");
		
		return mainLayout;
	}

}