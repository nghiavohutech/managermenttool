import  {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";
import {ActivatedRoute} from "@angular/router";
import {Subscription} from "rxjs";
import {News} from "./News";

@Component({
    selector: 'detail-news',
    template: '' +
    '<div *ngIf="newsObj" class="container">' +
    '<h3  >{{newsObj.Title }}</h3>' +
    '<p [innerHTML]="newsObj.Contents">' +
    '' +
    '</p>' +
    '</div>'
})

export class DetailNewsComponent {

    newsObj:News;
    newsLst:News[];
    slug: string;
    private subscription: Subscription;

    constructor(private service: AppService,
                private route: ActivatedRoute) {
        this.subscription = this.route.params.subscribe(
            (param: any) => {
                this.slug = param['slug'];

                service.getNewsBySlug(this.slug).subscribe(
                    data=>this.newsLst=data as News[],
                    error => console.log("Error HTTP GET Service"),
                    ()=>this.getNewsCallback(this.newsLst)
                );
            });
    }

    getNewsCallback(newsLst:News[]){

            this.newsObj=newsLst[0];
            console.log(newsLst[0]);

    }

}