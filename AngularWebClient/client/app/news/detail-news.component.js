"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var core_1 = require('@angular/core');
var app_service_1 = require("../app.service");
var router_1 = require("@angular/router");
var DetailNewsComponent = (function () {
    function DetailNewsComponent(service, route) {
        var _this = this;
        this.service = service;
        this.route = route;
        this.subscription = this.route.params.subscribe(function (param) {
            _this.slug = param['slug'];
            service.getNewsBySlug(_this.slug).subscribe(function (data) { return _this.newsLst = data; }, function (error) { return console.log("Error HTTP GET Service"); }, function () { return _this.getNewsCallback(_this.newsLst); });
        });
    }
    DetailNewsComponent.prototype.getNewsCallback = function (newsLst) {
        this.newsObj = newsLst[0];
        console.log(newsLst[0]);
    };
    DetailNewsComponent = __decorate([
        core_1.Component({
            selector: 'detail-news',
            template: '' +
                '<div *ngIf="newsObj" class="container">' +
                '<h3  >{{newsObj.Title }}</h3>' +
                '<p [innerHTML]="newsObj.Contents">' +
                '' +
                '</p>' +
                '</div>'
        }), 
        __metadata('design:paramtypes', [app_service_1.AppService, router_1.ActivatedRoute])
    ], DetailNewsComponent);
    return DetailNewsComponent;
}());
exports.DetailNewsComponent = DetailNewsComponent;
//# sourceMappingURL=detail-news.component.js.map