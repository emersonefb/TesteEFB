package br.com.efb.controller.util;

public class StringUtils {
	
	public static String getStringSemAcento(String s){
		if (s != null){
			s = s.replaceAll("[èéêëÈÉÊË]","E");
			s = s.replaceAll("[ûùúÛÙÚ]","U");
			s = s.replaceAll("[ïîíìÏÎÍÌ]","I");
			s = s.replaceAll("[àâáãÀÂÁÃ]","A");
			s = s.replaceAll("[óòÒÓôÔõÕ]","A");
			s = s.replaceAll("[ç,Ç]","C");
		}
		return s;
	}

}
