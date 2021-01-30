package shubham.fretron

import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import shubham.fretron.resource.UserResource

import javax.ws.rs.core.UriBuilder


fun main(){
    var baseURI = UriBuilder.fromUri("http://localhost").port(8080).build()
    var config = ResourceConfig(UserResource::class.java)
    var server = GrizzlyHttpServerFactory.createHttpServer(baseURI,config)
}