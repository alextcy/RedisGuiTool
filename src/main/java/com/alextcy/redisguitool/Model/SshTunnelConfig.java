package com.alextcy.redisguitool.Model;

/**
 *
 * @author aleksei.tsymbaliuk
 */
public class SshTunnelConfig
{
    private String host;
    
    private String user;
    
    private String password;
    
    private int port;

    public SshTunnelConfig(String host, String user, String password, int port) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.port = port;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }
}
