package dagger.modules

import dagger.Module
import dagger.Provides
import dagger.models.BackendServices
import shubham.fretron.resource.UserResource
import javax.inject.Named

@Module
class ServerModule {

    @Provides()
    fun uriProvider():String{
        return "http://localhost"
    }

    @Provides
    fun portProvider():Int{
        return 8080
    }

    @Provides
    fun userResourceProvider():UserResource{
        return UserResource()
    }





}