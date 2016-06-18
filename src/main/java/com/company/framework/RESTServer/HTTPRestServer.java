/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.framework.RESTServer;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author nuno
 */
public class HTTPRestServer {

    private String uri;
    private int port;

    public HTTPRestServer(String uri, int port) {
        this.setUri(uri);
        this.setPort(port);
    }

    /**
     * Informs the current Uniform Resource Identifier.
     *
     * @return uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * Define Uniform Resource Identifier.
     *
     * @param uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * HTTP server listen on port. DEFAULT 8080
     *
     * @return port number
     */
    public int getPort() {
        return port;
    }

    /**
     * Set HTTP server port.
     *
     * @param port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Starts the lightweight HTTP server serving the JAX-RS application.
     *
     * @param aplicationConfig instance that define application behavior
     * @return new instance of the lightweight HTTP server
     * @throws IOException
     */
    public HttpServer startServer(Application aplicationConfig) throws IOException {
        // create a new server listening at port 8080
        final HttpServer server = HttpServer.create(new InetSocketAddress(getBaseURI().getPort()), 0);
        server.setExecutor(null);
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.stop(0);
            }
        }));

        // create a handler wrapping the JAX-RS application
        HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(aplicationConfig, HttpHandler.class);

        // map JAX-RS handler to the server root
        server.createContext(getBaseURI().getPath(), handler);

        // start the server
        server.start();

        return server;
    }

    /**
     * Building HTTP process for requested configurations.
     *
     * @return uri
     */
    private URI getBaseURI() {
        return UriBuilder.fromUri(this.uri).port(getPort(this.port)).build();
    }

    /**
     * Verify port availability.
     *
     * @param defaultPort
     * @return port
     */
    private int getPort(int defaultPort) {
        final String portToUse = System.getProperty("jersey.config.test.container.port");
        if (null != portToUse) {
            try {
                return Integer.parseInt(portToUse);
            } catch (NumberFormatException e) {
                String info = "Value of jersey.config.test.container.port property"
                        + " is not a valid positive integer [" + portToUse + "]."
                        + " Reverting to default [" + defaultPort + "].";

                Logger.getLogger(HTTPRestServer.class.getName()).log(Level.INFO, info, "Port Number:");

            }

        }
        return defaultPort;
    }
}
