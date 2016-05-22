package com.br.uepb.hl7;

import java.io.IOException;

import com.br.uepb.model.PacienteDomain;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.datatype.ID;
import ca.uhn.hl7v2.model.v25.datatype.TS;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.OBR;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;

public class HL7Mensagem {

	public void lerMensagem(String mensagem) throws HL7Exception, IOException {
		
		PacienteDomain paciente = new PacienteDomain();
		
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getGenericParser();
		
		Message hapiMsg;
		try {
			hapiMsg = parser.parse(mensagem);
		} catch (EncodingNotSupportedException e) {
			e.printStackTrace();
			return;
		} catch (HL7Exception e) {
			e.printStackTrace();
			return;
		}
		
		ORU_R01 oru = (ORU_R01) hapiMsg;
		
		MSH msh = oru.getMSH();
		
		PID pid = oru.getPATIENT_RESULT().getPATIENT().getPID();
		ID sexo = pid.getIdentityUnknownIndicator();
		
		System.out.println("Sexo: "+sexo.getValue());
		TS dataNiver = pid.getDateTimeOfBirth();
		System.out.println("Data: "+dataNiver);
		
		paciente.setNome(oru.getPATIENT_RESULT().getPATIENT().getPID().getPatientName()+"");
		
		System.out.println(paciente.getNome());
	
//			TS dataDeObservacao = obx.getDateTimeOfTheObservation();		
//			NM nm = obx.getProbability();
//			TS ts = obx.getObx14_DateTimeOfTheObservation();
//		
		OBR obr = oru.getPATIENT_RESULT().getORDER_OBSERVATION().getOBR();
		String status = obr.getResultStatus().getValue();
		
		System.out.println("Status: " + status);		
		
	}
	
	public static void main(String[] args) throws HL7Exception, IOException {
		String msg = "MSH|^~\\&|VSM001|MIRTH_CONNECT|HIS001|MIRTH_CONNECT|20100511220525||ORU ^R01|MSG0000001|P|2.5|||NE|NE|CO|8859/1|ES-CO"
				+ "PID||6537077|6537077^^^^CC||ANDRES FELIPE^FERNANDEZ CORTES||19860705|M"
				+ "OBR|1||VS12340000|28562-7^Vital Signs^LN"
				+ "OBX|1|NM|271649006^Systolic blood pressure^SNOMED-CT||132|mm[Hg]|90-120|H|||F|||20100511220525"
				+ "OBX|2|NM|271650006^Diastolic blood pressure^SNOMED-CT||86|mm[Hg]|60-80|H|||F|||20100511220525"
				+ "OBX|3|NM|6797001^Mean blood pressure^SNOMED-CT||94|mm[Hg]|92-96|N|||F|||20100511220525";
		new HL7Mensagem().lerMensagem(msg);
	}
}
