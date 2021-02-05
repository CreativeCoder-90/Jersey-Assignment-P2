package shubham.fretron

import dagger.components.DaggerBackenedServiceComponent
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory
import org.glassfish.jersey.server.ResourceConfig
import shubham.fretron.resource.UserResource
import javax.inject.Inject

import javax.ws.rs.core.UriBuilder

fun main() {

    var component = DaggerBackenedServiceComponent.builder().build()
    var backenedService = component.buildBackenedService()
    var serverURI = backenedService.uri
    var serverPort = backenedService.port
    var userResource = backenedService.userResource



    var baseURI = UriBuilder.fromUri(serverURI).port(serverPort).build()
        var config = ResourceConfig().register(userResource)


    var server = GrizzlyHttpServerFactory.createHttpServer(baseURI, config)
}