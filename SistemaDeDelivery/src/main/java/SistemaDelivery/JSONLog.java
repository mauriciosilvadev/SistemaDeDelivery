/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaDelivery;

import SistemaDelivery.Interfaces.ILog;
import SistemaDelivery.Models.Pedido;
import SistemaDelivery.Services.UsuarioLogadoService;
import java.io.FileWriter;
import java.io.IOException;
import org.json.JSONObject;

/**
 *
 * @author Morrice
 */
public class JSONLog implements ILog {

    @Override
    public void escrever(Pedido pedido) {
        JSONObject json = new JSONObject();

        json.put("usuario", UsuarioLogadoService.getNomeUsuario());
        json.put("data", pedido.getDataPedido().toLocalDate().toString());
        json.put("hora", pedido.getDataPedido().toLocalTime().toString());
        json.put("codigo_pedido", pedido.getCodigoPedido());
        json.put("cliente", pedido.getCliente().getNome());

        try {
            FileWriter writeFile = new FileWriter("pedido_log.json");

            writeFile.write(json.toString());
            writeFile.close();
        } catch (IOException e) {
            System.out.println("Houve um erro ao escrever no arquivo json: " + e.toString());
        }

        System.out.println(json);
    }

}
