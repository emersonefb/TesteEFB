package br.com.efb.controller.util;

public class StringUtils {
	
	public static String getStringSemAcento(String s){
		if (s != null){
			s = s.replaceAll("[��������]","E");
			s = s.replaceAll("[������]","U");
			s = s.replaceAll("[��������]","I");
			s = s.replaceAll("[��������]","A");
			s = s.replaceAll("[��������]","A");
			s = s.replaceAll("[�,�]","C");
		}
		return s;
	}

}
