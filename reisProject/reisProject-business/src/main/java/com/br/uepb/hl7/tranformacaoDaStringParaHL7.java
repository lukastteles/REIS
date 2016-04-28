package com.br.uepb.hl7;

import com.br.uepb.model.PacienteDomain;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.datatype.PN;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.parser.EncodingNotSupportedException;
import ca.uhn.hl7v2.parser.Parser;

public class tranformacaoDaStringParaHL7 {

	private static ADT_A01 adtMsg;

	private String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01||P|2.2\r"
			+ "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
			+ "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
			+ "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
			+ "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||19990225|19990226|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
			+ "AL1||SEV|001^POLLEN\r"
			+ "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
			+ "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554";

	private String msg2 = "MSH|^~\\&|VSM001|MIRTH_CONNECT|HIS001|MIRTH_CONNECT|20100511220525||ORU ^R01|MSG0000001|P|2.5|||NE|NE|CO|8859/1|ES-CO"
			+ "PID||6537077|6537077^^^^CC||ANDRES FELIPE^FERNANDEZ CORTES||19860705|M"
			+ "OBR|1||VS12340000|28562-7^Vital Signs^LN"
			+ "OBX|1|NM|271649006^Systolic blood pressure^SNOMED-CT||132|mm[Hg]|90-120|H|||F|||20100511220525"
			+ "OBX|2|NM|271650006^Diastolic blood pressure^SNOMED-CT||86|mm[Hg]|60-80|H|||F|||20100511220525"
			+ "OBX|3|NM|6797001^Mean blood pressure^SNOMED-CT||94|mm[Hg]|92-96|N|||F|||20100511220525"
			+ "OBX|4|NM|386725007^Body temperature^SNOMED-CT||37|C|37|N|||F|||20100511220525"
			+ "OBX|5|NM|78564009^Pulse rate^SNOMED-CT||80|bpm|60-100|N|||F|||20100511220525"
			+ "OBX|6|NM|431314004^SpO2^SNOMED-CT||90|%|94-100|L|||F|||20100511220525";

	public tranformacaoDaStringParaHL7() {
		HapiContext context = new DefaultHapiContext();

		Parser p = context.getGenericParser();

		Message hapiMsg;
		try {
			// O mÃ©todo parse executa a anÃ¡lise real
			hapiMsg = p.parse(msg);
		} catch (EncodingNotSupportedException e) {
			e.printStackTrace();
			return;
		} catch (HL7Exception e) {
			e.printStackTrace();
			return;
		}

		adtMsg = (ADT_A01) hapiMsg;

	}

	public PacienteDomain informacoesDoPaciente() {
		PacienteDomain paciente = new PacienteDomain();

		return paciente;
	}

	public static void main(String[] args) {

		tranformacaoDaStringParaHL7 tranformacaoDaStringParaHL7 = new tranformacaoDaStringParaHL7();

		//MSH msh = adtMsg.getMSH();

		// Recuperar alguns dados do segmento MSH
		//String msgType = msh.getMessageType().getMessageType().getValue();
		//String msgTrigger = msh.getMessageType().getTriggerEvent().getValue();

		// Imprimir "ADT A01"
		//System.out.println(msgType + " " + msgTrigger);

		/*
		 * Agora vamos recuperar o nome do paciente a partir da mensagem
		 * analisado.
		 * 
		 * PN Ã© um tipo de dados HL7 constituÃ­do por vÃ¡rios componentes, tais
		 * como nome de famÃ­lia, nome, etc.
		 */
		PN patientName = adtMsg.getPID().getPatientName();
		//AD endereco = adtMsg.getNK1().getAddress();
		//TN telefone = adtMsg.getNK1().getBusinessPhoneNumber();

		String familyName = patientName.getFamilyName().getValue();
		System.out.println(familyName);
		System.out.println(patientName.getGivenName().getValue());
		System.out.println(patientName.getMiddleInitialOrName().getValue());
		System.out.println(patientName.getSuffixEgJRorIII().getValue());

		//System.out.println("Endereço:");
		//System.out.println(endereco.getCity().getValue());
		//System.out.println(endereco.getCountry().getValue());

		//System.out.println("Telefone:");
		//System.out.println(telefone.getValue());
	}

}
