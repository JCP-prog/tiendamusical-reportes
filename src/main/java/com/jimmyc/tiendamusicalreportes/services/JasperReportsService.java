/**
 * 
 */
package com.jimmyc.tiendamusicalreportes.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

/**
 * @author JimmyC
 * Interfaz que contiene los metodos de logica de negocio para compilar y generar el reporte pdf
 */
public interface JasperReportsService {

	/**
	 * Metodo que permite compilar el archivo Jasper jrxml descargado de Dropbox
	 * @param archivoBytes {@link ByteArrayOutputStream} archivo jrxml a compilar.
	 * @param orderID {@link String} orden de pedido del cliente.
	 * @return {@link JasperPrint} archivo jasper con la informacion a generarse con el pdf
	 * @throws ClassNotFoundException {@link ClassNotFoundException} exception en caso de error al encontrar el driver
	 * @throws SQLException {@link SQLException} Excepcion en caso de error al conectarse a la base de datos
	 * @throws JRException {@link JRException} Excepcion en caso de error al compilar el reporte de Jasper
	 * @throws IOException {@link IOException} Excepcion en caso de error al cerrar el flujo de datos de los archivos
	 */
	JasperPrint compilarReporteJasper(ByteArrayOutputStream archivoBytes, String orderID) throws ClassNotFoundException, SQLException, JRException, IOException;
}
