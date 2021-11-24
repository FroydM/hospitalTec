/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import jdk.nashorn.api.tree.Parser;
import modelo.Paciente;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author march
 */
public class TribunalSupremoEleccionesDAO {
    public static Paciente obtenerPacienteInfoByIdentificacion(int cedula) {
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
            return convertData(responseContent.toString());
        } catch (Exception e) {
            return null;
        }
    }
    private static Paciente convertData(String responseBody) throws Exception{
        
        try {
            
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(responseBody);
            JSONObject jsonObject = (JSONObject)obj;
            JSONArray array = (JSONArray)jsonObject.get("results");
            JSONObject info = (JSONObject)array.get(0);
            Paciente pacienteInfo = new Paciente();
            pacienteInfo.setCedula(Integer.parseInt(info.get("cedula").toString()));
            pacienteInfo.setNombre(info.get("firstname1").toString());
            pacienteInfo.setApellido1(info.get("lastname1").toString());
            pacienteInfo.setApellido2(info.get("lastname2").toString());
            return pacienteInfo;
            
        } catch (Exception e) {
            throw e;
        }
        
    }
}
