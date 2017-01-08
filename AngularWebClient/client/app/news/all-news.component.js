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
var AllNewsComponent = (function () {
    function AllNewsComponent(service) {
        this.service = service;
    }
    AllNewsComponent.prototype.ngOnInit = function () {
        var _this = this;
        this.service.getNewsAll().subscribe(function (data) { return _this.NewsList = data; }, function (error) { return console.log("Error HTTP GET Service"); }, function () { return console.log(_this.NewsList); });
    };
    AllNewsComponent = __decorate([
        core_1.Component({
            selector: 'all-news',
            template: '<div class="container">' +
                '<ul class="list-group">' +
                '<li class="list-group-item" *ngFor="let item of NewsList; let i = index">' +
                '<a routerLink="/news/{{item.MetaSlug}}" >{{item.Title}}</a>' +
                '</li>' +
                '</ul>' +
                '</div>'
        }), 
        __metadata('design:paramtypes', [app_service_1.AppService])
    ], AllNewsComponent);
    return AllNewsComponent;
}());
exports.AllNewsComponent = AllNewsComponent;
//# sourceMappingURL=all-news.component.js.map