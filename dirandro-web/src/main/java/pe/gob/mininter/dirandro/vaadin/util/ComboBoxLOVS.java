package pe.gob.mininter.dirandro.vaadin.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import pe.gob.mininter.dirandro.model.Valor;
import pe.gob.mininter.dirandro.service.ValorService;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;

public class ComboBoxLOVS extends ComboBox {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7302008755794920607L;
	
	private BeanItemContainer<Valor> containerValor;
	
	private String codigoLista;
	
	private ValorService valorService;
	
	public ComboBoxLOVS() {
		this(null);
	}
	
	public ComboBoxLOVS(String codigoLista) {
		super();
		this.codigoLista = codigoLista;
		valorService = Injector.obtenerServicio(ValorService.class);
	}

	@Override
	public void attach() {
		super.attach();
		
		List<Valor> valores = null;
		
		if(StringUtils.isNotEmpty(codigoLista)){
			valores = valorService.obtenerLista(codigoLista);
		}
		else{
			valores = new ArrayList<Valor>();	
			
			Valor v = new Valor();
			v.setId(0l);
			v.setCodigo("TEMP");
			v.setNombre("Sin Valores");
			
			valores.add(v);
		}
		
		containerValor = new BeanItemContainer<Valor>(Valor.class,  valores);
		setContainerDataSource(containerValor);
		setItemCaptionPropertyId("nombre");
	}

}
