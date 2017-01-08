
import {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";
import {News} from "./News";

@Component({
    selector: 'all-news',
    template:'<div class="container">' +
    '<ul class="list-group">' +
    '<li class="list-group-item" *ngFor="let item of NewsList; let i = index">' +
        '<a routerLink="/news/{{item.MetaSlug}}" >{{item.Title}}</a>'+
    '</li>' +
    '</ul>' +
    '</div>'

})


export class AllNewsComponent implements OnInit{
    constructor(private service:AppService){}

    NewsList:News[];
    ngOnInit(){
        this.service.getNewsAll().subscribe(
            data=>this.NewsList=data as News[],
            error => console.log("Error HTTP GET Service"),
            ()=>console.log(this.NewsList)
        );
    }


}

