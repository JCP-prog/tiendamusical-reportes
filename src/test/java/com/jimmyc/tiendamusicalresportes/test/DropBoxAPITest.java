/**
 * 
 */
package com.jimmyc.tiendamusicalresportes.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.users.FullAccount;

/**
 * @author JimmyC
 * Prueba Unitaria para verificar la comunicacion de un aplicativo Java con DropBox
 */
public class DropBoxAPITest {

	@Test
	public void test() {
		// SE CONFIGURA EL TOKEN DE ACCESO A LA APP CREADA EN DROPBOX
		String TOKEN = "sl.AtQnCZmwzrJlQgP5FCSlDlvhu5MNt0cO2RPaDzLj6Xpm_tATQdxKOZbSlOTooea_hNwSeVwhDhe8gCPpqix1JQNBVYnPxxoe_mquGY_19zYHex3964BbsfWOyhuMTB6eiL1l6r8";
		
		// SE CONFIGURA EL TOKEN Y EL AMBIENTE DE CONFIGURACION INICIAL DEL DROPBOX
		DbxRequestConfig dbxRequestConfig = DbxRequestConfig.newBuilder("jimmyc/test-dropbox").build();
		DbxClientV2 dbxClientV2 = new DbxClientV2(dbxRequestConfig, TOKEN);
		
		try {
			assertNotNull(dbxClientV2);
			
			//SE OBTIENE Y SE MUESTRA LA INFORMACION DE LA CUENTA PERTENECIENTE A LA APP
			FullAccount fullAccount = dbxClientV2.users().getCurrentAccount();
			
			System.out.println("Email de la cuenta: "+fullAccount.getEmail());
			System.out.println("Pais de la cuenta: "+fullAccount.getCountry());
			System.out.println("Nombre de la cuenta: "+fullAccount.getName());
		} catch (DbxException e) {
			e.printStackTrace();
			assertNull(dbxClientV2);
		}
		
	}

}
