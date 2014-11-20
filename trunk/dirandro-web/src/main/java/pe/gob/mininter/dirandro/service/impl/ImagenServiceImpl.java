package pe.gob.mininter.dirandro.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.mininter.dirandro.dao.hibernate.ImagenHibernate;
import pe.gob.mininter.dirandro.model.Adjunto;
import pe.gob.mininter.dirandro.model.Imagen;
import pe.gob.mininter.dirandro.service.AdjuntoService;
import pe.gob.mininter.dirandro.service.ImagenService;
import pe.gob.mininter.dirandro.util.Busqueda;
import pe.gob.mininter.dirandro.util.HarecUtil;

@Service
public class ImagenServiceImpl extends BaseServiceImpl<Imagen, Long> implements ImagenService{

	private static final long serialVersionUID = 4250579045882035484L;
	
	private ImagenHibernate imagenHibernate;
	
	@Autowired
	private AdjuntoService adjuntoService;
	
	@Autowired
	public ImagenServiceImpl(ImagenHibernate imagenHibernate) {
		super(imagenHibernate);
		this.imagenHibernate = imagenHibernate;
	}
	
	@Override
	public List<Imagen> buscar(Imagen imagen) {		
		Busqueda filtro = Busqueda.forClass(Imagen.class);		
		if(imagen !=null){			
			if(imagen.getPersona()!=null){
				if(imagen.getPersona().getId()!=null)
				filtro.add(Restrictions.eq("persona.id", imagen.getPersona().getId()));
			}
		}						
		return imagenHibernate.buscar(filtro);		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Imagen registrarImagenAdjunta(Imagen imagen) {
		
		imagen.validar();
		
		logger.debug("Si hay imagen cargada");
		
		Adjunto imagAdjunta = imagen.getAdjunto();
		
		adjuntoService.crear(imagAdjunta);	
		
		imagenHibernate.crear(imagen);
		
		//grabar binario en disco duro
		HarecUtil.adjuntarDocumentos(imagAdjunta);
		
		return imagen;
	}
		
}
