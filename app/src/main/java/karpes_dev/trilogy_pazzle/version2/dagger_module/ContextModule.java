package karpes_dev.trilogy_pazzle.version2.dagger_module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import karpes_dev.trilogy_pazzle.version2.dagger_component.SingleScope;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Named("application_context")
    @SingleScope
    @Provides
    public Context context(){ return context.getApplicationContext(); }
}