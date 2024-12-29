package com.example.understandinghilt

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UserModule {
    @Provides
//    @Named("sql")  we can also create custom annotations for this work
    @SQLQualifier
    fun providesSQLRepository() : UserRepository{
        return SQLRepository()
    }

    @Provides
    @Named("firebase")
    fun providesFirebaseRepository() : UserRepository{
        return FirebaseRepository()
    }

    @Provides
    @Named("changeEmail")
    @Singleton
    fun providesChangeDatainRepository() : UserRepository{
        return ChangeDatainRepository()
    }


}


//----------------BINDS----------------\\
/*
since SQLRepository has @Inject therefore hilt knows
how to create its object so we simply use bind instead of
            @Provides
            fun providesUserRepository() : UserRepository{
                return SQLRepository()
            }
this is now @Binds is used ==|
@InstallIn(SingletonComponent::class)
@Module
abstract class UserModule{
    @Binds
    abstract fun providesSQLRepository(sqlRepository: SQLRepository) : UserRepository
}
*/