package com.br.uepb.hl7;

import java.util.concurrent.Executors;

import javax.naming.LinkRef;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.protocol.ReceivingApplication;
import ca.uhn.hl7v2.validation.builder.support.DefaultValidationBuilder;
import ca.uhn.hl7v2.validation.builder.support.NoValidationBuilder;

public class HL7Mensagem {

	/**
	 * <a href="http://hl7api.sourceforge.net/devbyexample.html">link</a>
	 * 1 - Primeiro, você vai precisar de um Contexto HAPI 
	 * 
	 * 2 - Agora, vamos introduzir algumas operações de rede para enviar mensagens de um cliente
	 * e receber mensagens para um servidor. 
	 * 
	 * 3 - Ler mensagens de um arquivo e enviar várias mensagens para fora usando ConnectionHub. 
	 * 
	 * 4 - Lidar com diferentes esquemas de codificação de caracteres (charsets), tais como
	 * UTF-8 ou ISO-8859/2. 
	 * 
	 * 5 - Criptografia de mensagens é possível usando SSL / TLS 
	 * 
	 * 6 - Configurar de segmentação estratégias usando ExecutorServices
	 * personalizados.
	 *
	 */

	public void receberMensagem(String mensagem) {
		HapiContext ctx = new DefaultHapiContext();
		
		ctx.setValidationRuleBuilder(new NoValidationBuilder());
		
		HL7Service server1 = ctx.newServer(8080, false);
		HL7Service server2 = ctx.newServer(8081, false);
		
		HapiContext ctx1 = new DefaultHapiContext();
		ctx1.setValidationRuleBuilder(new NoValidationBuilder());
		server1 = ctx1.newServer(8080, false);
		  		
		HapiContext ctx2 = new DefaultHapiContext();
		ctx2.setValidationRuleBuilder(new DefaultValidationBuilder());
		server2 = ctx2.newServer(8081, false);
		
		ctx = new DefaultHapiContext();
		ctx.setExecutorService(Executors.newCachedThreadPool());
		
		ReceivingApplication handler = new ReceberApplication();
		server1.registerApplication("ADT", "A01", handler);
		server1.registerApplication("ADT", "A02", handler);
		
		
	}
	
	public static void main(String[] args) {
		String msg = "MSH|^~\\&|VSM001|MIRTH_CONNECT|HIS001|MIRTH_CONNECT|20100511220525||ORU ^R01|MSG0000001|P|2.5|||NE|NE|CO|8859/1|ES-CO"
				+ "PID||6537077|6537077^^^^CC||ANDRES FELIPE^FERNANDEZ CORTES||19860705|M"
				+ "OBR|1||VS12340000|28562-7^Vital Signs^LN"
				+ "OBX|1|NM|271649006^Systolic blood pressure^SNOMED-CT||132|mm[Hg]|90-120|H|||F|||20100511220525"
				+ "OBX|2|NM|271650006^Diastolic blood pressure^SNOMED-CT||86|mm[Hg]|60-80|H|||F|||20100511220525"
				+ "OBX|3|NM|6797001^Mean blood pressure^SNOMED-CT||94|mm[Hg]|92-96|N|||F|||20100511220525"
				+ "OBX|4|NM|386725007^Body temperature^SNOMED-CT||37|C|37|N|||F|||20100511220525"
				+ "OBX|5|NM|78564009^Pulse rate^SNOMED-CT||80|bpm|60-100|N|||F|||20100511220525"
				+ "OBX|6|NM|431314004^SpO2^SNOMED-CT||90|%|94-100|L|||F|||20100511220525";
		new HL7Mensagem().receberMensagem(msg);
	}
}
