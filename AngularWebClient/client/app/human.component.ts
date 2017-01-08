import  {Component} from '@angular/core';
import {AppService} from "./app.service";

@Component({
    selector: 'human',
    moduleId: module.id,
    templateUrl: 'human.html',
    providers:[AppService]
})

export class HumanComponent {
    name: string;
    age: number;

    constructor(private service: AppService) {

    }

    onAddHuman() {
        this.service.addHuman({name: this.name, age: this.age})
            .subscribe(data=>{
                console.log('Success '+JSON.stringify( data));
            });
    }
}