import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }   from './app.component';
import {HumanComponent} from "./human.component";
import {HttpModule} from "@angular/http";
import {FormsModule} from "@angular/forms";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {AppService} from "./app.service";
import {AppRoutingModule} from "./app-routing.module";
import {MainNewsComponent} from "./news/main-news.component";
import {DetailNewsComponent} from "./news/detail-news.component";
import {AllNewsComponent} from "./news/all-news.component";
import {ThumbNewsComponent} from "./news/thumb-news.component";




@NgModule({
   imports:      [ BrowserModule, HttpModule, FormsModule,NgbModule.forRoot(),AppRoutingModule ],
   declarations: [ AppComponent,HumanComponent,MainNewsComponent,DetailNewsComponent,AllNewsComponent],
   bootstrap:    [ AppComponent ],
   providers:[AppService  ]
})
export class AppModule { }
