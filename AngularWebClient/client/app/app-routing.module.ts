import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HumanComponent} from "./human.component";
import {AppComponent} from "./app.component";
import {MainNewsComponent} from "./news/main-news.component";
import {DetailNewsComponent} from "./news/detail-news.component";
import {AllNewsComponent} from "./news/all-news.component";
import {ThumbNewsComponent} from "./news/thumb-news.component";

const routes = [
    {path: 'human',  component: HumanComponent, useAsDefault:true},
    {path: 'news/:slug', component: DetailNewsComponent},
    {path: 'news-all/all', component: AllNewsComponent},
    // {path: 'thumb', component: ThumbNewsComponent},
];
@NgModule({
    imports: [ RouterModule.forRoot(routes,{useHash:true}) ],
    exports: [ RouterModule ]
})
export class AppRoutingModule {
}
