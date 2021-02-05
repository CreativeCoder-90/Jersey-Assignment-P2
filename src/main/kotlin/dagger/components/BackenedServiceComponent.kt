package dagger.components

import com.sun.security.ntlm.Server
import dagger.Component
import dagger.models.BackendServices
import dagger.modules.ServerModule
import shubham.fretron.resource.UserResource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules=[ServerModule::class])
interface BackenedServiceComponent {
    fun buildBackenedService():BackendServices
}