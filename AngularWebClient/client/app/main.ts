import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { AppModule } from './app.module';
import {AppRoutingModule} from "./app-routing.module";


const platform = platformBrowserDynamic();
platform.bootstrapModule(AppModule ,[AppRoutingModule]);
