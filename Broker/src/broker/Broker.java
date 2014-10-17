/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package broker;

/**
 *
 * @author a09001005
 */
public class Broker {
    private String ip;
    private String port;

    public Broker(String ip, String port) {
        this.ip = ip;
        this.port = port;
    }

    Broker() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
    

    
}