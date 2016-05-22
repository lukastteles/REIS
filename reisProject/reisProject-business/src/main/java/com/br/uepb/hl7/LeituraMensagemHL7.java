package com.br.uepb.hl7;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.StringTokenizer;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.OBR;
import ca.uhn.hl7v2.model.v25.segment.OBX;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageIterator;
import ca.uhn.hl7v2.util.Hl7InputStreamMessageStringIterator;

public class LeituraMensagemHL7 {

	public void lerString(String mensagem) {

		StringTokenizer tokenizer = new StringTokenizer(mensagem, "|");
		ArrayList<String> hl7_MSH = new ArrayList<String>();
		ArrayList<String> hl7_PID = new ArrayList<String>();
		ArrayList<String> hl7_OBX = new ArrayList<String>();
		ArrayList<String> hl7_OBR = new ArrayList<String>();
		
		ORU_R01 oru = new ORU_R01();

		// Cabeçalho da mensagem
		MSH mshMensagem = oru.getMSH();
		// Informações básicas do paciente
		PID pid = oru.getPATIENT_RESULT().getPATIENT().getPID();
		// OBR
		ORU_R01_ORDER_OBSERVATION orderOBR = oru.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBR obr = orderOBR.getOBR();
		// OBX 1 - Pressão Sistolica
		ORU_R01_OBSERVATION orderOBX = orderOBR.getOBSERVATION();
		OBX obx = orderOBX.getOBX();
		
		boolean auxMSH = false;
		boolean auxPID = false;
		boolean auxOBX = false;
		boolean auxOBR = false;

		while (tokenizer.hasMoreTokens()) {
			String str = (String) tokenizer.nextToken();
			
			if (str.equals("MSH")) {				
				hl7_MSH.add(str);	 		
//				System.out.print(str+" ");
				auxMSH = true;
				auxPID = false;
				auxOBR = false;
				auxOBX = false;
			} else if (auxMSH && !auxPID && !auxOBR && !auxOBX) {
				if (!str.contains("PID")) {
					hl7_MSH.add(str);	
				}				 
//				System.out.print(str+" ");
				auxPID = false;
				auxOBR = false;
				auxOBX = false;
			}		
			if (str.contains("PID")) {
				for (int i = 0; i <= str.length(); i++) {
					if (str.substring(i, str.length()).equals("PID")) {				
						hl7_MSH.add(str.substring(0, i)); 
					}
				}				
				hl7_PID.add("PID");
				auxMSH = false;
				auxPID = true;
				tokenizer.nextToken();
			}
			if (str.equals("PID")) {				
				hl7_PID.add(str); 
//				System.out.print(str+" ");
				auxMSH = false;
				auxPID = true;
				auxOBX = false;
			}
			if (str.contains("OBX")) {
				auxPID = false;
			}
			
			if (str.equals("OBX") || str.contains("OBX")) {
				hl7_OBX.add(str); 
//				System.out.print(str+" ");
				auxMSH = false;
				auxPID = false;
				auxOBX = true;
				auxOBR = false;
			}  
			
			if (str.equals("OBR") || str.contains("OBR")) {
				hl7_OBR.add(str); 
//				System.out.print(str+" ");
				auxMSH = false;
				auxPID = false;
				auxOBX = false;
				auxOBR = true;
			} 
			
			if (!auxMSH && auxPID && !auxOBR && !auxOBX) {
				hl7_PID.add(str); 
//				System.out.print(str+" ");
				auxMSH = false;
				auxPID = true;
				auxOBX = false;
				auxOBR = false;
			}
			
			if (!auxMSH && auxPID && !auxOBR && auxOBX) {				
				hl7_OBX.add(str); 
//				System.out.print(str+" ");
				auxMSH = false;
				auxPID = false;
				auxOBX = true;
				auxOBR = false;
			}
			
			if (!auxMSH && !auxPID && auxOBR && !auxOBX) {
				hl7_OBR.add(str); 
//				System.out.print(str+" ");
				auxMSH = false;
				auxPID = false;
				auxOBX = false;
				auxOBR = true;
			}
		}

		for (String obr7 : hl7_MSH) {
			System.out.print(obr7 + " ");
		}
		System.out.println();
		for (String obr7 : hl7_PID) {
			System.out.print(obr7 + " ");
		}
		System.out.println();
		for (String obr7 : hl7_OBX) {
			System.out.print(obr7 + " ");
		}
		System.out.println();
		for (String obr7 : hl7_OBR) {
			System.out.print(obr7 + " ");
		}
	}

	public static void main(String[] args) throws FileNotFoundException {

		String mensagem = "MSH|^~\\&|VSM001|MIRTH_CONNECT|HIS001|MIRTH_CONNECT|20100511220525||ORU ^R01|MSG0000001|P|2.5|||NE|NE|CO|8859/1|ES-CO"
				+ "PID||6537077|6537077^^^^CC||ANDRES FELIPE^FERNANDEZ CORTES||19860705|M"
				+ "OBR|1||VS12340000|28562-7^Vital Signs^LN"
				+ "OBX|1|NM|271649006^Systolic blood pressure^SNOMED-CT||132|mm[Hg]|90-120|H|||F|||20100511220525"
				+ "OBX|2|NM|271650006^Diastolic blood pressure^SNOMED-CT||86|mm[Hg]|60-80|H|||F|||20100511220525"
				+ "OBX|3|NM|6797001^Mean blood pressure^SNOMED-CT||94|mm[Hg]|92-96|N|||F|||20100511220525"
				+ "OBX|4|NM|386725007^Body temperature^SNOMED-CT||37|C|37|N|||F|||20100511220525"
				+ "OBX|5|NM|78564009^Pulse rate^SNOMED-CT||80|bpm|60-100|N|||F|||20100511220525"
				+ "OBX|6|NM|431314004^SpO2^SNOMED-CT||90|%|94-100|L|||F|||20100511220525";

//		LeituraMensagemHL7 hl7 = new LeituraMensagemHL7();
//		String st = "LucasPID", retorno = "";
//		
//		for (int i = 0; i <= st.length(); i++) {
//			if (st.substring(i, st.length()).equals("PID")) {				
//				st = st.substring(0, i);
//			}
//		}
//		System.out.println(st);
		
		
//		hl7.lerString(mensagem);

				/**
		  		 * This example shows how to read a series of messages from a file
		  		 * containing a number of HL7 messages. Assume you have a text file
		 		 * containing a number of messages.
		  		 */
		  		
		  		// Open an InputStream to read from the file
		  		File file = new File("C:/Users/Lucas/Documents/REIS/reisProject/reisProject-business/src/main/java/com/br/uepb/hl7/hl7_messages.txt");
		  		InputStream is = new FileInputStream(file);
		  		
		  		// It's generally a good idea to buffer file IO
		  		is = new BufferedInputStream(is);
		  		
		  		// The following class is a HAPI utility that will iterate over
		  		// the messages which appear over an InputStream
		  		Hl7InputStreamMessageIterator iter = new Hl7InputStreamMessageIterator(is);
		  		
		  		while (iter.hasNext()) {		  			
		  			Message next = iter.next();		  			
		  			// Do something with the message
		  			
		  		}
		  		
		  		/*
		  		 * If you don't want the message parsed, you can also just
		  		 * read them in as strings.
		  		 */
		  		
		  		file = new File("hl7_messages.txt");
		  		is = new FileInputStream(file);
		  		is = new BufferedInputStream(is);
		  		Hl7InputStreamMessageStringIterator iter2 = new Hl7InputStreamMessageStringIterator(is); 
		  		
		  		while (iter2.hasNext()) {
		  			
		  			String next = iter2.next();
		  			
		  			// Do something with the message
  			
}
	}
}
