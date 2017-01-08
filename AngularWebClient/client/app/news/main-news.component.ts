import  {Component} from '@angular/core';
import {AppService} from "../app.service";

@Component({
    selector: 'main-news',
    moduleId: module.id,
    templateUrl: 'main-news.html',
    providers: [AppService]
})

export class MainNewsComponent {
    name: string;
    age: number;

    link = 'about';

    constructor(private service: AppService) {

    }

    onAddHuman() {
        this.service.addHuman({name: this.name, age: this.age})
            .subscribe(data => {
                console.log('Success ' + JSON.stringify(data));
            });
    }
}