package com.bookstore.libraries.report;

import java.io.OutputStream;
import java.util.Map;

import com.bookstore.libraries.exception.ReportException;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class ReportGenerator {

	private ReportGenerator() {}
	
	public static void generatePDF(String jasper, Map<String, Object> parameters, JRDataSource dataSource, OutputStream out) throws ReportException {

		try {
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, parameters, dataSource);
			JRExporter exporter = new JRPdfExporter();
			
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
			
			exporter.exportReport();
			
		} catch (JRException e) {
			throw new ReportException(e);
		}
	}
}