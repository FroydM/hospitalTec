/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
/**
 *
 * @author march
 */
public class TribunalSupremoEleccionesDAO {
    public static void obtenerPacienteInfoByIdentificacion(int cedula) {
        HttpURLConnection connection;
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        try {
            URL urlRequest = new URL("https://apis.gometa.org/cedulas/"+cedula+"&key=SMmxgFW1Kh1Sucb");
            connection = (HttpURLConnection)urlRequest.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            int status = connection.getResponseCode();
            if(status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine())!=null){
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
        } catch (Exception e) {
        }
    }
    private static String[] convertData(String responseBody) {
        //JSONArray personInfo = new JSONArray(responseBody);
        return null;
    }
}
