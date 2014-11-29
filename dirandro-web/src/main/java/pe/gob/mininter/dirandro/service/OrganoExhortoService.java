package pe.gob.mininter.dirandro.service;

import java.util.List;

import pe.gob.mininter.dirandro.model.OrgExhorto;

public interface OrganoExhortoService extends BaseService<OrgExhorto, Long> {

	public List<OrgExhorto> buscar(OrgExhorto detGrem);

}
