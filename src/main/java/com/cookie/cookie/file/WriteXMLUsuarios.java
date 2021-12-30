package com.cookie.cookie.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.cookie.cookie.entity.Usuario;

public class WriteXMLUsuarios {
    static List<Usuario> usuarios = new ArrayList<Usuario>();
	static
	{
		Usuario usua1 = new Usuario();
        usua1.setEstado(1);
		Usuario usua2 = new Usuario();
        usua2.setEstado(1);

		usuarios.add(usua1);
		usuarios.add(usua2);
	}
	
	// public static void main(String[] args) throws JAXBException {
	// 	 JAXBContext jaxbContext = JAXBContext.newInstance(Usuario.class);
	// 	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	// 	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

	// 	    jaxbMarshaller.marshal(usuarios, System.out);

	// 	    jaxbMarshaller.marshal(usuarios, new File("solicitudes.xml"));
	// }

}
