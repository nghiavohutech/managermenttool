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
var MainNewsComponent = (function () {
    function MainNewsComponent(service) {
        this.service = service;
        this.link = 'about';
    }
    MainNewsComponent.prototype.onAddHuman = function () {
        this.service.addHuman({ name: this.name, age: this.age })
            .subscribe(function (data) {
            console.log('Success ' + JSON.stringify(data));
        });
    };
    MainNewsComponent = __decorate([
        core_1.Component({
            selector: 'main-news',
            moduleId: module.id,
            templateUrl: 'main-news.html',
            providers: [app_service_1.AppService]
        }), 
        __metadata('design:paramtypes', [app_service_1.AppService])
    ], MainNewsComponent);
    return MainNewsComponent;
}());
exports.MainNewsComponent = MainNewsComponent;
//# sourceMappingURL=main-news.component.js.map