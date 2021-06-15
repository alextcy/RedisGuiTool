package com.alextcy.redisguitool.Model;

/**
 * @author aleksei.tsymbaliuk
 */
public class ConnectionConfig 
{
    private String name;
   
    private String host;
   
    private int port;
   
    private String password;
   
    private SshTunnelConfig sshTunnel;

    public ConnectionConfig(String name, String host, int port, String password, SshTunnelConfig sshTunnel) {
        this.name = name;
        this.host = host;
        this.port = port;
        this.password = password;
        this.sshTunnel = sshTunnel;
    }
 
    public ConnectionConfig(String name, String host, int port, String password) 
    {
        this.name = name;
        this.host = host;
        this.port = port;
        this.password = password;
    }

    public String getName() 
    {
        return name;
    }

    public String getHost() 
    {
        return host;
    }

    public int getPort() 
    {
        return port;
    }

    public String getPassword() 
    {
        return password;
    }

    public SshTunnelConfig getSshTunnel() 
    {
        return sshTunnel;
    }
}
