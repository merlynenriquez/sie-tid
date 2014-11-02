package pe.gob.mininter.dirandro.vaadin.panel.bandeja;

import java.util.List;

import pe.gob.mininter.dirandro.model.Opcion;
import pe.gob.mininter.dirandro.vaadin.util.DirandroComponent;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.ui.AbsoluteLayout;

public class PanelBandejaNotaInformativa extends DirandroComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -925673737555162946L;
	@AutoGenerated
	private AbsoluteLayout mainLayout; 
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public PanelBandejaNotaInformativa(List<Opcion> acciones, String height) {
		super(acciones, height);
		
		buildMainLayout();
		setCompositionRoot(mainLayout);
		
		//hojaRemisionService = Injector.obtenerServicio(HojaRemisionService.class);

		postConstruct();
	}

	@AutoGenerated
	private void buildMainLayout() {
		// the main layout and components will be created here
		mainLayout = new AbsoluteLayout();
	}

	@Override
	public void postConstruct() {
		// TODO Auto-generated method stub
		
	}

}
