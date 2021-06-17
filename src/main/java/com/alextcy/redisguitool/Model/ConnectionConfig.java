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
    
    public void setName(String name) {
        this.name = name;
    }

    public String getHost() 
    {
        return host;
    }
    
    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() 
    {
        return port;
    }
    
    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() 
    {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public SshTunnelConfig getSshTunnel() 
    {
        return sshTunnel;
    }
    
    public void setSshTunnel(SshTunnelConfig sshTunnel)
    {
        this.sshTunnel = sshTunnel;
    }
}
