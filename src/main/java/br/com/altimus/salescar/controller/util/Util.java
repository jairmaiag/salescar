package br.com.altimus.salescar.controller.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Util {
	final static DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
	public static String mensageRetorno(String texto) {
		Mensagem mensagem = new Mensagem(texto);
		return mensagem.toString();
	}
	
	public static String calendarToString(Calendar data) {
		if(data == null) {
			return null;
		}
		return df.format(data.getTime());
	}
	
	public static Calendar stringToCalendar(String data) {
		Calendar retorno = null;
		if(data == null) {
			return retorno;
		}
		try {
			retorno = Calendar.getInstance();
			retorno.setTime(df.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
			return retorno;
		}
		return retorno;
	}

}
