
import {Component, OnInit, Input} from '@angular/core';
import {AppService} from "../app.service";
import {News} from "./News";

@Component({
    selector: 'thumb-news',
    templateUrl:'thumb-news.html',
    styleUrls:['../css/thumb-news.css']
})


export class ThumbNewsComponent implements OnInit{

    @Input('image') image:string;
    @Input('title') title:string;

    constructor(private service:AppService){}

    NewsList:News[];
    ngOnInit(){

    }


}

