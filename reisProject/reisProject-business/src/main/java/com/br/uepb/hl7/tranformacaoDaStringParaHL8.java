
package com.br.uepb.hl7;

import java.io.IOException; 

import com.br.uepb.dao.MedicaoBalancaDAO;
import com.br.uepb.dao.PacienteDAO;
import com.br.uepb.model.MedicaoBalancaDomain;
import com.br.uepb.model.PacienteDomain;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.Varies;
import ca.uhn.hl7v2.model.v25.message.ORU_R01;
import ca.uhn.hl7v2.model.v25.datatype.CE;
import ca.uhn.hl7v2.model.v25.datatype.NM;
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

public class tranformacaoDaStringParaHL8 {

	public tranformacaoDaStringParaHL8() {

	}

	public String criarHL7TESTE(PacienteDomain paciente) throws HL7Exception, IOException {
		ORU_R01 mensagem = new ORU_R01();
		mensagem.initQuickstart("ADT", "A01", "P");

		// Cabeçalho da mensagem
		MSH mshMensagem = mensagem.getMSH();
		mshMensagem.getMessageControlID().setValue("MESSAGE_CONTROL_ID_1");
		mshMensagem.getSequenceNumber().setValue("123");

		// Informações básicas do paciente
		PID pid = mensagem.getPATIENT_RESULT().getPATIENT().getPID();
		pid.getPatientName(0).getGivenName().setValue(paciente.getNome());

		// OBR
		ORU_R01_ORDER_OBSERVATION orderOBR = mensagem.getPATIENT_RESULT().getORDER_OBSERVATION();
		OBR obr = orderOBR.getOBR();
		obr.getSetIDOBR().setValue("1");
		obr.getFillerOrderNumber().getEntityIdentifier().setValue("UEPB");
		obr.getFillerOrderNumber().getNamespaceID().setValue("123");
		obr.getUniversalServiceIdentifier().getIdentifier().setValue("Oximetro");

		// OBX
		ORU_R01_OBSERVATION orderOBX = orderOBR.getOBSERVATION();
		OBX obx = orderOBX.getOBX();
		obx.getSetIDOBX().setValue("1");
		obx.getObservationIdentifier().getIdentifier().setValue("Pressão Sistolica");
		obx.getValueType().setValue("NM");

		CE ce = new CE(mensagem);
		ce.getText().setValue("");
		ce.getNameOfCodingSystem().setValue("PS");

		
		Varies varie = obx.getObservationValue(0);
		varie.setData(ce);//
		
		obx = orderOBR.getOBSERVATION(1).getOBX();
		

		// Transforma os objetos no arquivo HL7.
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
		String encodedMessage = parser.encode(mensagem);

		System.out.println("Mensagem HL7");
		System.out.println(encodedMessage);

		return encodedMessage;
	}

	public String criarHL7(PacienteDomain paciente) throws HL7Exception, IOException {
		ADT_A01 mensagem = new ADT_A01();
		mensagem.initQuickstart("ADT", "A01", "P");

		// Cabeçalho da mensagem
		MSH mshMensagem = mensagem.getMSH();
		mshMensagem.getMessageControlID().setValue("MESSAGE_CONTROL_ID_1");
		mshMensagem.getSequenceNumber().setValue("123");

		// Informações básicas do paciente
		PID pid = mensagem.getPID();
		pid.getPatientName(0).getGivenName().setValue(paciente.getNome());

		// TODO: Falta o OBR

		// OBX
		OBX obx = mensagem.getOBX();
		obx.getSetIDOBX().setValue("1");

		// OBX2
		OBX obx2 = mensagem.getOBX();
		obx2.getSetIDOBX().setValue("2");

		//
		PV1 pv1 = mensagem.getPV1();
		pv1.getSetIDPV1().setValue("1");

		// Transforma os objetos no arquivo HL7.
		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
		String encodedMessage = parser.encode(mensagem);

		System.out.println("Mensagem HL7");
		System.out.println(encodedMessage);

		return encodedMessage;
	}

	/**
	 * Pega as informações que estão na base de dados correspondente a balança
	 * do id (int) e retorna o objeto.
	 * 
	 * @param banca
	 * @return
	 */
	public MedicaoBalancaDomain informacoesBalanca(int banca) {
		MedicaoBalancaDomain balanca = new MedicaoBalancaDAO().obtemMedicaoBalanca(banca);
		return balanca;
	}

	/**
	 * Pega as informações pela classe {@link PacienteDAO} e coloca no objeto
	 * {@link PacienteDomain} e retorna.
	 * 
	 * @param id
	 * @return
	 */
	public PacienteDomain informacoesDoPaciente(int id) {
		PacienteDAO dao = new PacienteDAO();
		PacienteDomain paciente = new PacienteDomain();
		paciente = dao.obtemPaciente(id);
		return paciente;
	}

	public static void main(String[] args) {
		tranformacaoDaStringParaHL8 tranformacaoDaStringParaHL7 = new tranformacaoDaStringParaHL8();
		PacienteDomain paciente = tranformacaoDaStringParaHL7.informacoesDoPaciente(1);
		try {
			// tranformacaoDaStringParaHL7.createRadiologyOrderMessage();
			tranformacaoDaStringParaHL7.criarHL7TESTE(paciente);
		} catch (HL7Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Message createRadiologyOrderMessage() throws HL7Exception {
		ORM_O01 message = new ORM_O01();

		// handle the MSH component
		MSH msh = message.getMSH();
		msh.getSendingApplication().getNamespaceID().setValue("Teste");
		msh.getMessageControlID().setValue("MESSAGE_CONTROL_ID_1");
		// TODO: Preencher os campos do segmento MSH (pelo menos os que serão
		// necessários.

		// handle the patient PID component
		ORM_O01_PATIENT patient = message.getPATIENT();
		PID pid = patient.getPID();
		pid.getPatientIdentifierList(0).getIDNumber().setValue("GAN111113");
		pid.getPatientName(0).getFamilyName().getSurname().setValue("Patient");
		pid.getPatientName(0).getGivenName().setValue("Dummy");
		pid.getDateTimeOfBirth().getTime().setValue("20120830");
		pid.getAdministrativeSex().setValue("M");
		// TODO: do we need patient admission ID / account number

		// handle patient visit component
		PV1 pv1 = message.getPATIENT().getPATIENT_VISIT().getPV1();
		pv1.getAssignedPatientLocation().getPointOfCare().setValue("OPD");
		pv1.getAssignedPatientLocation().getPersonLocationType().setValue("EMR");
		pv1.getReferringDoctor(0).getIDNumber().setValue("1");
		pv1.getReferringDoctor(0).getFamilyName().getSurname().setValue("Dummy");
		pv1.getReferringDoctor(0).getGivenName().setValue("Doctor");

		// handle ORC component
		ORC orc = message.getORDER().getORC();
		orc.getPlacerOrderNumber().getEntityIdentifier().setValue("A00111");
		orc.getFillerOrderNumber().getEntityIdentifier().setValue("B00111");
		orc.getEnteredBy(0).getGivenName().setValue("Bahmni");
		orc.getOrderControl().setValue("NW");

		// handle OBR component
		OBR obr = message.getORDER().getORDER_DETAIL().getOBR();
		obr.getUniversalServiceIdentifier().getIdentifier().setValue("CHESTLORDOTICXRAY");
		obr.getUniversalServiceIdentifier().getText().setValue("Chest lordotic xray");
		// obr.getFillerOrderNumber().getEntityIdentifier().setValue("ORNO1");

		// note that we are just sending modality here, not the device location
		obr.getPlacerField2().setValue("CR");
		obr.getQuantityTiming(0).getPriority().setValue("STAT");

		// break the reason for study up by lines
		obr.getReasonForStudy(0).getText().setValue("Creating a test order programmatically");
		obr.getReasonForStudy(1).getText().setValue("This is a test order. Please ignore this order.");

		HapiContext context = new DefaultHapiContext();
		Parser parser = context.getPipeParser();
		String encodedMessage = parser.encode(message);

		System.out.println("Mensagem HL7");
		System.out.println(encodedMessage);

		return message;
	}

}
