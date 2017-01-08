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
var platform_browser_1 = require('@angular/platform-browser');
var app_component_1 = require('./app.component');
var human_component_1 = require("./human.component");
var http_1 = require("@angular/http");
var forms_1 = require("@angular/forms");
var ng_bootstrap_1 = require('@ng-bootstrap/ng-bootstrap');
var app_service_1 = require("./app.service");
var app_routing_module_1 = require("./app-routing.module");
var main_news_component_1 = require("./news/main-news.component");
var detail_news_component_1 = require("./news/detail-news.component");
var all_news_component_1 = require("./news/all-news.component");
var AppModule = (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        core_1.NgModule({
            imports: [platform_browser_1.BrowserModule, http_1.HttpModule, forms_1.FormsModule, ng_bootstrap_1.NgbModule.forRoot(), app_routing_module_1.AppRoutingModule],
            declarations: [app_component_1.AppComponent, human_component_1.HumanComponent, main_news_component_1.MainNewsComponent, detail_news_component_1.DetailNewsComponent, all_news_component_1.AllNewsComponent],
            bootstrap: [app_component_1.AppComponent],
            providers: [app_service_1.AppService]
        }), 
        __metadata('design:paramtypes', [])
    ], AppModule);
    return AppModule;
}());
exports.AppModule = AppModule;
//# sourceMappingURL=app.module.js.map