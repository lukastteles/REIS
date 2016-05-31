
package com.br.uepb.hl7;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import com.br.uepb.business.MedicoesBusiness;
import com.br.uepb.dao.MedicaoBalancaDAO;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.MedicaoOximetroDomain;
import com.br.uepb.model.MedicaoPressaoDomain;
import com.br.uepb.model.PacienteDomain;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.datatype.CE;
import ca.uhn.hl7v2.model.v25.datatype.NM;
import ca.uhn.hl7v2.model.v25.datatype.ST;
import ca.uhn.hl7v2.model.v25.datatype.TX;
import ca.uhn.hl7v2.model.v25.group.ORM_O01_PATIENT;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_OBSERVATION;
import ca.uhn.hl7v2.model.v25.group.ORU_R01_ORDER_OBSERVATION;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.message.ORM_O01;
import ca.uhn.hl7v2.model.v25.segment.MSH;
import ca.uhn.hl7v2.model.v25.segment.OBR;
import ca.uhn.hl7v2.model.v25.segment.OBX;
import ca.uhn.hl7v2.model.v25.segment.ORC;
import ca.uhn.hl7v2.model.v25.segment.PID;
import ca.uhn.hl7v2.model.v25.segment.PV1;
import ca.uhn.hl7v2.parser.Parser;

public class MensagensHL7 {
	
	private MedicoesBusiness business = new MedicoesBusiness();

	public MensagensHL7() {

	}

	// Segundo o nosso gerente, o nome do método teria que ser esse, se não entenderem pergunte a ele!!
	public String criarMensagemHL7Pressao(PacienteDomain paciente) throws HL7Exception, IOException {
		
		MedicaoPressaoDomain medicaoPressaoDomain = business.lisatUltimaMedicaoPressao(paciente.getId());
		
		ORU_R01 mensagem = new ORU_R01();
		mensagem.initQuickstart("ORU", "R01", "P");

		// Cabeçalho da mensagem
		MSH mshMensagem = mensagem.getMSH();
		mshMensagem.getMessageControlID().setValue("MESSAGE_CONTROL");
		mshMensagem.getSequenceNumber().setValue("123");

		// Informações básicas do paciente
		PID pid = mensagem.getPATIENT_RESULT().getPATIENT().getPID();
		pid.getPatientName(0).getGivenName().setValue(paciente.getNome());
		//pid.getPatientID().getIdentifierTypeCode().setTable(paciente.getId());
		pid.getSetIDPID().setValue(String.valueOf(paciente.getId()));
		pid.getPatientAddress(0).getCity().setValue(paciente.getCidade());
		pid.getPatientAddress(0).getStreetAddress().getStreetName().setValue(paciente.getEndereco());
		pid.getPhoneNumberBusiness(0).getTelephoneNumber().setValue(paciente.getTelefoneCasa());

		// OBR
		ORU_R01_ORDER_OBSERVATION orderOBR = mensagem.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBR obr = orderOBR.getOBR();
		obr.getSetIDOBR().setValue("1");
		obr.getFillerOrderNumber().getEntityIdentifier().setValue("Dispositivo");
		obr.getUniversalServiceIdentifier().getIdentifier().setValue("Pressão");

		// OBX 1 - Pressão Sistolica
		ORU_R01_OBSERVATION orderOBX = orderOBR.getOBSERVATION();
		OBX obx = orderOBX.getOBX();
		obx.getSetIDOBX().setValue("1");
		obx.getObservationIdentifier().getIdentifier().setValue("Pressão Sistolica");
		obx.getValueType().setValue("NM");

		CE ce = new CE(mensagem);
		ce.getText().setValue(String.valueOf(medicaoPressaoDomain.getPressaoSistolica()));

		obx.getUnits().getCe2_Text().setValue(medicaoPressaoDomain.getUnidadePressaoSistolica());
		obx.getObx7_ReferencesRange().setValue("90-120");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoPressaoDomain.getDataHora());
		
		Varies varie = obx.getObservationValue(0);
		varie.setData(ce);//
		
		// OBX 2 - Pressão Diastolica
		obx = orderOBR.getOBSERVATION(1).getOBX();
		
		obx.getSetIDOBX().setValue("2");
		obx.getObservationIdentifier().getIdentifier().setValue("Pressão Diastolica");
		obx.getValueType().setValue("NM");
		
		CE ce1 = new CE(mensagem);
		ce1.getText().setValue(String.valueOf(medicaoPressaoDomain.getPressaoDiastolica()));

		obx.getUnits().getCe2_Text().setValue(medicaoPressaoDomain.getUnidadePressaoDiastolica());
		obx.getObx7_ReferencesRange().setValue("60-80");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoPressaoDomain.getDataHora());
		
		Varies varies = obx.getObservationValue(0);
		varies.setData(ce1);//
		
		// OBX 3 - Pressão media
		obx = orderOBR.getOBSERVATION(2).getOBX();
		
		obx.getSetIDOBX().setValue("3");
		obx.getObservationIdentifier().getIdentifier().setValue("Pressão Media");
		obx.getValueType().setValue("NM");
		
		CE ce3 = new CE(mensagem);
		ce3.getText().setValue(String.valueOf(medicaoPressaoDomain.getPressaoMedia()));

		obx.getUnits().getCe2_Text().setValue(medicaoPressaoDomain.getUnidadePressaoMedia());
		obx.getObx7_ReferencesRange().setValue("92-96");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoPressaoDomain.getDataHora());
		
		Varies varie3 = obx.getObservationValue(0);
		varie3.setData(ce3);//
		
		// OBX 4 - Taxa de Pulso
		obx = orderOBR.getOBSERVATION(3).getOBX();
		
		obx.getSetIDOBX().setValue("4");
		obx.getObservationIdentifier().getIdentifier().setValue("Taxa de Pulso");
		obx.getValueType().setValue("NM");
		
		CE ce4 = new CE(mensagem);
		ce4.getText().setValue(String.valueOf(medicaoPressaoDomain.getTaxaDePulso()));

		obx.getUnits().getCe2_Text().setValue(medicaoPressaoDomain.getuTaxaDePulso());
		obx.getObx7_ReferencesRange().setValue("60-100");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoPressaoDomain.getDataHora());
		
		Varies varie4 = obx.getObservationValue(0);
		varie4.setData(ce4);//

		// Transforma os objetos no arquivo HL7.
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
		String encodedMessage = parser.encode(mensagem);

		System.out.println(encodedMessage);

		return encodedMessage;
	}
	
	public String criarMensagemHL7Oximetro(PacienteDomain paciente) throws HL7Exception, IOException {
		
		MedicaoOximetroDomain medicaoOximetroDomain = business.lisatUltimaMedicaoOximetro(paciente.getId());
		
		ORU_R01 mensagem = new ORU_R01();
		mensagem.initQuickstart("ORU", "R01", "P");

		// Cabeçalho da mensagem
		MSH mshMensagem = mensagem.getMSH();
		mshMensagem.getMessageControlID().setValue("MESSAGE_CONTROL");
		mshMensagem.getSequenceNumber().setValue("123");

		// Informações básicas do paciente
		PID pid = mensagem.getPATIENT_RESULT().getPATIENT().getPID();
		pid.getPatientName(0).getGivenName().setValue(paciente.getNome());
		pid.getSetIDPID().setValue(String.valueOf(paciente.getId()));
		pid.getPatientAddress(0).getCity().setValue(paciente.getCidade());
		pid.getPatientAddress(0).getStreetAddress().getStreetName().setValue(paciente.getEndereco());
		pid.getPhoneNumberBusiness(0).getTelephoneNumber().setValue(paciente.getTelefoneCasa());

		// OBR
		ORU_R01_ORDER_OBSERVATION orderOBR = mensagem.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBR obr = orderOBR.getOBR();
		obr.getSetIDOBR().setValue("1");
		obr.getFillerOrderNumber().getEntityIdentifier().setValue("Dispositivo");
		obr.getUniversalServiceIdentifier().getIdentifier().setValue("Oximetro");

		// OBX 1 - SPO2
		ORU_R01_OBSERVATION orderOBX = orderOBR.getOBSERVATION();
		OBX obx = orderOBX.getOBX();
		obx.getSetIDOBX().setValue("1");
		obx.getObservationIdentifier().getIdentifier().setValue("SPO2");
		obx.getValueType().setValue("NM");

		CE ce = new CE(mensagem);
		ce.getText().setValue(String.valueOf(medicaoOximetroDomain.getSpo2()));

		obx.getUnits().getCe2_Text().setValue(medicaoOximetroDomain.getuSPO2());
		obx.getObx7_ReferencesRange().setValue("94-100");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoOximetroDomain.getDataHora());
		
		Varies varie = obx.getObservationValue(0);
		varie.setData(ce);//
		
		// OBX 2 - Taxa de Pulso
		obx = orderOBR.getOBSERVATION(1).getOBX();
		
		obx.getSetIDOBX().setValue("2");
		obx.getObservationIdentifier().getIdentifier().setValue("Taxa de Pulso");
		obx.getValueType().setValue("NM");
		
		CE ce1 = new CE(mensagem);
		ce1.getText().setValue(String.valueOf(medicaoOximetroDomain.getTaxaPulso()));

		obx.getUnits().getCe2_Text().setValue(medicaoOximetroDomain.getuTaxaDePulso());
		obx.getObx7_ReferencesRange().setValue("60-100");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoOximetroDomain.getDataHora());
		
		Varies varies = obx.getObservationValue(0);
		varies.setData(ce1);//
		
		// Transforma os objetos no arquivo HL7.
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
		String encodedMessage = parser.encode(mensagem);

		System.out.println(encodedMessage);

		return encodedMessage;
	}

	public String criarMensagemHL7Balanca(PacienteDomain paciente) throws HL7Exception, IOException {
		
		MedicaoBalancaDomain medicaoBalancaDomain = business.lisatUltimaMedicaoBalanca(paciente.getId());
		
		ORU_R01 mensagem = new ORU_R01();
		mensagem.initQuickstart("ORU", "R01", "P");

		// Cabeçalho da mensagem
		MSH mshMensagem = mensagem.getMSH();
		mshMensagem.getMessageControlID().setValue("MESSAGE_CONTROL");
		mshMensagem.getSequenceNumber().setValue("123");

		// Informações básicas do paciente
		PID pid = mensagem.getPATIENT_RESULT().getPATIENT().getPID();
		pid.getPatientName(0).getGivenName().setValue(paciente.getNome());
		//pid.getPatientID().getIdentifierTypeCode().setTable(paciente.getId());
		pid.getSetIDPID().setValue(String.valueOf(paciente.getId()));
		pid.getPatientAddress(0).getCity().setValue(paciente.getCidade());
		pid.getPatientAddress(0).getStreetAddress().getStreetName().setValue(paciente.getEndereco());
		pid.getPhoneNumberBusiness(0).getTelephoneNumber().setValue(paciente.getTelefoneCasa());

		// OBR
		ORU_R01_ORDER_OBSERVATION orderOBR = mensagem.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBR obr = orderOBR.getOBR();
		obr.getSetIDOBR().setValue("1");
		obr.getFillerOrderNumber().getEntityIdentifier().setValue("Dispositivo");
		obr.getUniversalServiceIdentifier().getIdentifier().setValue("Balança");

		// OBX 1 - Peso
		ORU_R01_OBSERVATION orderOBX = orderOBR.getOBSERVATION();
		OBX obx = orderOBX.getOBX();
		obx.getSetIDOBX().setValue("1");
		obx.getObservationIdentifier().getIdentifier().setValue("Peso");
		obx.getValueType().setValue("NM");

		CE ce = new CE(mensagem);
		ce.getText().setValue(String.valueOf(medicaoBalancaDomain.getPeso()));

		obx.getUnits().getCe2_Text().setValue(medicaoBalancaDomain.getuPeso());
		//obx.getObx7_ReferencesRange().setValue("94-100");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoBalancaDomain.getDataHora());
		
		Varies varie = obx.getObservationValue(0);
		varie.setData(ce);//
		
		// OBX 2 - Altura
		obx = orderOBR.getOBSERVATION(1).getOBX();
		
		obx.getSetIDOBX().setValue("2");
		obx.getObservationIdentifier().getIdentifier().setValue("Altura");
		obx.getValueType().setValue("NM");
		
		CE ce1 = new CE(mensagem);
		ce1.getText().setValue(String.valueOf(medicaoBalancaDomain.getAltura()));

		obx.getUnits().getCe2_Text().setValue(medicaoBalancaDomain.getuAltura());
		//obx.getObx7_ReferencesRange().setValue("60-100");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoBalancaDomain.getDataHora());
		
		Varies varies = obx.getObservationValue(0);
		varies.setData(ce1);//
		
		// OBX 3 - Massa
		obx = orderOBR.getOBSERVATION(2).getOBX();
		
		obx.getSetIDOBX().setValue("3");
		obx.getObservationIdentifier().getIdentifier().setValue("Massa");
		obx.getValueType().setValue("NM");
		
		CE ce3 = new CE(mensagem);
		ce3.getText().setValue(String.valueOf(medicaoBalancaDomain.getMassa()));

		obx.getUnits().getCe2_Text().setValue(medicaoBalancaDomain.getuMassa());
		//obx.getObx7_ReferencesRange().setValue("60-100");
		obx.getDateTimeOfTheObservation().getTime().setValue(medicaoBalancaDomain.getDataHora());
		
		Varies varies3 = obx.getObservationValue(0);
		varies3.setData(ce3);//
		
		// Transforma os objetos no arquivo HL7.
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
		String encodedMessage = parser.encode(mensagem);
		
		System.out.println(encodedMessage);

		return encodedMessage;
	}

	public MedicaoBalancaDomain informacoesBalanca(int banca) {
		MedicaoBalancaDomain balanca = new MedicaoBalancaDAO().obtemMedicaoBalanca(banca);
		return balanca;
	}

	public PacienteDomain informacoesDoPaciente(int id) {
		PacienteDAO dao = new PacienteDAO();
		PacienteDomain paciente = new PacienteDomain();
		paciente = dao.obtemPaciente(id);
		return paciente;
	}

	
	// Segundo o nosso gerente, o nome do método teria que ser esse, se não entenderem pergunte a ele!!
		public String criarMensagemHL7(PacienteDomain paciente, MedicaoOximetroDomain oximetro, MedicaoPressaoDomain pressao, MedicaoBalancaDomain balanca) throws HL7Exception, IOException {
			
			ORU_R01 mensagem = new ORU_R01();
			mensagem.initQuickstart("ORU", "R01", "P");

			// Cabeçalho da mensagem
			MSH mshMensagem = mensagem.getMSH();
			mshMensagem.getMessageControlID().setValue("MESSAGE_CONTROL");
			mshMensagem.getSequenceNumber().setValue("123");

			// Informações básicas do paciente
			PID pid = mensagem.getPATIENT_RESULT().getPATIENT().getPID();
			pid.getPatientName(0).getGivenName().setValue(paciente.getNome());
			//pid.getPatientID().getIdentifierTypeCode().setTable(paciente.getId());
			pid.getSetIDPID().setValue(String.valueOf(paciente.getId()));
			pid.getPatientAddress(0).getCity().setValue(paciente.getCidade());
			pid.getPatientAddress(0).getStreetAddress().getStreetName().setValue(paciente.getEndereco());
			pid.getPhoneNumberBusiness(0).getTelephoneNumber().setValue(paciente.getTelefoneCasa());

			// OBR
			ORU_R01_ORDER_OBSERVATION orderOBR = mensagem.getPATIENT_RESULT().getORDER_OBSERVATION();
			OBR obr = orderOBR.getOBR();
			obr.getSetIDOBR().setValue("1");
			obr.getFillerOrderNumber().getEntityIdentifier().setValue("Dispositivo");
			obr.getUniversalServiceIdentifier().getIdentifier().setValue("Pressão");

			// OBX 1 - Pressão Sistolica
			ORU_R01_OBSERVATION orderOBX = orderOBR.getOBSERVATION();
			OBX obx = orderOBX.getOBX();
			obx.getSetIDOBX().setValue("1");
			obx.getObservationIdentifier().getIdentifier().setValue("Pressão Sistolica");
			obx.getValueType().setValue("NM");

			CE ce = new CE(mensagem);
			ce.getText().setValue(String.valueOf(pressao.getPressaoSistolica()));

			
			
			/// Pressão
			obx.getUnits().getCe2_Text().setValue(pressao.getUnidadePressaoSistolica());
			obx.getObx7_ReferencesRange().setValue("90-120");
			obx.getDateTimeOfTheObservation().getTime().setValue(pressao.getDataHora());
			
			Varies varie = obx.getObservationValue(0);
			varie.setData(ce);//
			
			// OBX 2 - Pressão Diastolica
			obx = orderOBR.getOBSERVATION(1).getOBX();
			
			obx.getSetIDOBX().setValue("2");
			obx.getObservationIdentifier().getIdentifier().setValue("Pressão Diastolica");
			obx.getValueType().setValue("NM");
			
			CE ce1 = new CE(mensagem);
			ce1.getText().setValue(String.valueOf(pressao.getPressaoDiastolica()));

			obx.getUnits().getCe2_Text().setValue(pressao.getUnidadePressaoDiastolica());
			obx.getObx7_ReferencesRange().setValue(pressao.getPressaoMedia()+"");
			obx.getDateTimeOfTheObservation().getTime().setValue(pressao.getDataHora());
			
			Varies varies = obx.getObservationValue(0);
			varies.setData(ce1);//
			
			// OBX 3 - Pressão media
			obx = orderOBR.getOBSERVATION(2).getOBX();
			
			obx.getSetIDOBX().setValue("3");
			obx.getObservationIdentifier().getIdentifier().setValue("Pressão Media");
			obx.getValueType().setValue("NM");
			
			CE ce3 = new CE(mensagem);
			ce3.getText().setValue(String.valueOf(pressao.getPressaoMedia()));

			obx.getUnits().getCe2_Text().setValue(pressao.getUnidadePressaoMedia());
			obx.getObx7_ReferencesRange().setValue("92-96");
			obx.getDateTimeOfTheObservation().getTime().setValue(pressao.getDataHora());
			
			Varies varie3 = obx.getObservationValue(0);
			varie3.setData(ce3);//
			
			// OBX 4 - Taxa de Pulso
			obx = orderOBR.getOBSERVATION(3).getOBX();
			
			obx.getSetIDOBX().setValue("4");
			obx.getObservationIdentifier().getIdentifier().setValue("Taxa de Pulso");
			obx.getValueType().setValue("NM");
			
			CE ce4 = new CE(mensagem);
			ce4.getText().setValue(String.valueOf(pressao.getTaxaDePulso()));

			obx.getUnits().getCe2_Text().setValue(pressao.getuTaxaDePulso());
			obx.getObx7_ReferencesRange().setValue("60-100");
			obx.getDateTimeOfTheObservation().getTime().setValue(pressao.getDataHora());
			
			Varies varie4 = obx.getObservationValue(0);
			varie4.setData(ce4);//

			
			// Balanca	
			CE ceBalanca = new CE(mensagem);
			ceBalanca.getText().setValue(String.valueOf(balanca.getPeso()));

			obx.getUnits().getCe2_Text().setValue(balanca.getuPeso());
			//obx.getObx7_ReferencesRange().setValue("94-100");
			obx.getDateTimeOfTheObservation().getTime().setValue(balanca.getDataHora());
			
			Varies variBalanca = obx.getObservationValue(0);
			varie.setData(ce);//
			
			// OBX 2 - Altura
			obx = orderOBR.getOBSERVATION(1).getOBX();
			
			obx.getSetIDOBX().setValue("2");
			obx.getObservationIdentifier().getIdentifier().setValue("Altura");
			obx.getValueType().setValue("NM");
			
			CE ceBalanca2 = new CE(mensagem);
			ceBalanca2.getText().setValue(String.valueOf(balanca.getAltura()));

			obx.getUnits().getCe2_Text().setValue(balanca.getuAltura());
			//obx.getObx7_ReferencesRange().setValue("60-100");
			obx.getDateTimeOfTheObservation().getTime().setValue(balanca.getDataHora());
			
			Varies variesBalanca = obx.getObservationValue(0);
			variesBalanca.setData(ce1);//
			
			// OBX 3 - Massa
			obx = orderOBR.getOBSERVATION(2).getOBX();
			
			obx.getSetIDOBX().setValue("3");
			obx.getObservationIdentifier().getIdentifier().setValue("Massa");
			obx.getValueType().setValue("NM");
			
			CE ceBalanca3 = new CE(mensagem);
			ceBalanca3.getText().setValue(String.valueOf(balanca.getMassa()));

			obx.getUnits().getCe2_Text().setValue(balanca.getuMassa());
			//obx.getObx7_ReferencesRange().setValue("60-100");
			obx.getDateTimeOfTheObservation().getTime().setValue(balanca.getDataHora());
			
			Varies variesPressao3 = obx.getObservationValue(0);
			variesPressao3.setData(ceBalanca3);//
			
			
			/// Oximetro
			CE ceOximetro = new CE(mensagem);
			ceOximetro.getText().setValue(String.valueOf(oximetro.getSpo2()));

			obx.getUnits().getCe2_Text().setValue(oximetro.getuSPO2());
			obx.getObx7_ReferencesRange().setValue("94-100");
			obx.getDateTimeOfTheObservation().getTime().setValue(oximetro.getDataHora());
			
			Varies varieOximetro = obx.getObservationValue(0);
			varie.setData(ce);//
			
			// OBX 2 - Taxa de Pulso
			obx = orderOBR.getOBSERVATION(1).getOBX();
			
			obx.getSetIDOBX().setValue("2");
			obx.getObservationIdentifier().getIdentifier().setValue("Taxa de Pulso");
			obx.getValueType().setValue("NM");
			
			CE ceoximetro1 = new CE(mensagem);
			ceoximetro1.getText().setValue(String.valueOf(oximetro.getTaxaPulso()));

			obx.getUnits().getCe2_Text().setValue(oximetro.getuTaxaDePulso());
			obx.getObx7_ReferencesRange().setValue("60-100");
			obx.getDateTimeOfTheObservation().getTime().setValue(oximetro.getDataHora());
			
			Varies variesoximetro = obx.getObservationValue(0);
			varies.setData(ceoximetro1);//
			
			
			
			
			
			// Transforma os objetos no arquivo HL7.
			HapiContext context = new DefaultHapiContext();
			Parser parser = context.getPipeParser();
			String encodedMessage = parser.encode(mensagem);

			System.out.println(encodedMessage);

			return encodedMessage;
		}
		
	
	public static void main(String[] args) {
		MensagensHL7 tranformacaoDaStringParaHL7 = new MensagensHL7();
		PacienteDomain paciente = tranformacaoDaStringParaHL7.informacoesDoPaciente(1);
		try {
			// tranformacaoDaStringParaHL7.createRadiologyOrderMessage();
			tranformacaoDaStringParaHL7.criarMensagemHL7Balanca(paciente);
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
