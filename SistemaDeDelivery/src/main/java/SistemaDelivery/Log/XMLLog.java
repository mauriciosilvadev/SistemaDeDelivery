/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery.Log;

import SistemaDelivery.Interfaces.ILog;
import SistemaDelivery.Models.Pedido;
import SistemaDelivery.Services.UsuarioLogadoService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Morrice
 */
public class XMLLog implements ILog {

    @Override
    public void escrever(Pedido pedido) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.newDocument();

            Element root = document.createElement("pedido");
            document.appendChild(root);

            Element book1 = document.createElement("usuario");
            book1.appendChild(document.createTextNode(UsuarioLogadoService.getNomeUsuario()));
            Element book2 = document.createElement("data");
            book2.appendChild(document.createTextNode(pedido.getDataPedido().toLocalDate().toString()));
            Element book3 = document.createElement("hora");
            book3.appendChild(document.createTextNode(pedido.getDataPedido().toLocalTime().toString()));
            Element book4 = document.createElement("codigo_pedido");
            book4.appendChild(document.createTextNode(pedido.getCodigoPedido().toString()));
            Element book5 = document.createElement("cliente");
            book5.appendChild(document.createTextNode(pedido.getCliente().getNome()));
            root.appendChild(book1);
            root.appendChild(book2);
            root.appendChild(book3);
            root.appendChild(book4);
            root.appendChild(book5);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult("pedido_log.xml");
            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(XMLLog.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
