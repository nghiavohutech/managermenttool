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
var http_1 = require("@angular/http");
var Observable_1 = require("rxjs/Observable");
require("rxjs/Rx");
require('rxjs/add/operator/map');
var AppService = (function () {
    function AppService(http) {
        this.http = http;
    }
    AppService.prototype.addHuman = function (human) {
        var header = new http_1.Headers();
        header.append('Content-Type', 'application/json');
        return this.http.post('/api/human', JSON.stringify(human), { headers: header });
    };
    AppService.prototype.getNewsBySlug = function (slug) {
        return this.http.get('/news/newsbyid?slug=' + slug)
            .map(function (res) { return res.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.json().error || 'Server error'); });
    };
    AppService.prototype.getNewsAll = function () {
        return this.http.get('/news/all')
            .map(function (res) { return res.json(); })
            .catch(function (error) { return Observable_1.Observable.throw(error.json().error || 'Server error'); });
    };
    AppService = __decorate([
        core_1.Injectable(), 
        __metadata('design:paramtypes', [http_1.Http])
    ], AppService);
    return AppService;
}());
exports.AppService = AppService;
//https://scotch.io/tutorials/angular-2-http-requests-with-observables
//# sourceMappingURL=app.service.js.map