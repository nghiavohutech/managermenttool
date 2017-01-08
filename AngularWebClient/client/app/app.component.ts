import {Component} from '@angular/core';

import {HumanComponent} from "./human.component";
import {loadNgModuleDirectives} from "@angular/compiler";
import {MainNewsComponent} from "./news/main-news.component";

@Component({
    selector: 'my-app',
    template:
    '<main-news></main-news>'+
    '<router-outlet></router-outlet>'
})


export class AppComponent {
}
