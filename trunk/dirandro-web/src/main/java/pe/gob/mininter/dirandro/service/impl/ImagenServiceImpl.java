package pe.gob.mininter.dirandro.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
	@Transactional(propagation=Propagation.REQUIRED)
	public void crear(Imagen object) {		
		super.crear(object);
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void actualizar(Imagen object) {
		imagenHibernate.actualizar(object);
	}
	
	@Override
	public List<Imagen> buscar(Imagen imagen) {		
		Busqueda filtro = Busqueda.forClass(Imagen.class);		
		if(imagen !=null){			
			
		}						
		return imagenHibernate.buscar(filtro);		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Imagen registrarImagenAdjunta(Imagen imagen) {
		
		
		Adjunto imagAdjunta = imagen.getAdjunto();
		adjuntoService.crear(imagAdjunta);
		
		
		logger.debug("creacion completada");
		imagenHibernate.crear(imagen);
		
		adjuntarDocumentos(imagAdjunta);
		
		return imagen;
	}
	
	public void adjuntarDocumentos(Adjunto documentoAdjunto) {
		String directorio = documentoAdjunto.getRuta();
		
		File file = new File(directorio);
		if(!file.exists()) file.mkdirs();		
		
		ByteArrayOutputStream arrayOutputStream = documentoAdjunto.getOutputStream();
		FileOutputStream outputStream = null;
		
		try {
			outputStream = new FileOutputStream(file+"//"+documentoAdjunto.getId()+"."+documentoAdjunto.getExtension());
			arrayOutputStream.writeTo(outputStream);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
