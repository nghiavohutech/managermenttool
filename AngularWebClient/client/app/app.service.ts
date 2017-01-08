import  {Injectable} from '@angular/core';
import {Http, Headers, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import  "rxjs/Rx";
import 'rxjs/add/operator/map'

@Injectable()
export  class AppService{
     constructor(private http:Http){}

     addHuman(human){
         var header = new Headers();
         header.append('Content-Type','application/json');
         return this.http.post('/api/human',JSON.stringify(human),{headers:header});
     }

    getNewsBySlug(slug){

        return this.http.get('/news/newsbyid?slug='+slug)
            .map((res:Response)=>res.json())
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }

    getNewsAll(){

        return this.http.get('/news/all')
            .map((res:Response)=>res.json())
            .catch((error:any) => Observable.throw(error.json().error || 'Server error'));
    }
}

//https://scotch.io/tutorials/angular-2-http-requests-with-observables
