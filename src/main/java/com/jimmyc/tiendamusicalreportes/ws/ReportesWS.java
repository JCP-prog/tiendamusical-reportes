/**
 * 
 */
package com.jimmyc.tiendamusicalreportes.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.jimmyc.tiendamusicalreportes.services.DropboxAPIService;

/**
 * @author JimmyC
 * WebService que contendra los metodos configurados como servicios del WS
 */

@Component
@Path("/reportesWS")
public class ReportesWS {

	/**
	 * ACCES TOKEN DE LA API DE DROPBOX
	 */
	@Value("${spring.dropbox.access.token}")
	String ACCESS_TOKEN;
	
	/**
	 * 
	 * Se inyecta el servicio de Dropbox con Spring
	 */
	@Autowired
	private DropboxAPIService dropboxAPIServiceImpl;
	
	@GET
	@Path("/pruebaWS")
	public String pruebaWS() {
		return "Ingresando al WS...";
	}

	@POST
	@Path("/generarReporte")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response generarReporte(@FormParam("orderID") String orderID, @FormParam("cliente") String cliente, @FormParam("destinatario") String destinatario) {
		DbxRequestConfig dbxRequestConfig = DbxRequestConfig.newBuilder("dropbox/jimmyc").build();
		
		DbxClientV2 dbxClientV2 = new DbxClientV2(dbxRequestConfig, ACCESS_TOKEN);
		
		Response response = this.dropboxAPIServiceImpl.descargarReporte(dbxClientV2, orderID, cliente);
		
		return response;
	}
}
