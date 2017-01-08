var PORT = 8888 || process.env.PORT;
var mainRouter = require('./routes/index.js');
var apiRouter=require('./routes/api.js');
var newsRouter=require('./routes/news.js');
var DB = 'mongodb://localhost:27017/MEAN';
var mongoose = require('mongoose');
var express = require('express');
var bodyParser = require('body-parser');
var path = require('path');
var morgan = require('morgan');
var app = express();

app.use(morgan('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));
app.use('/',mainRouter);
app.use('/api',apiRouter);
app.use('/news',newsRouter);
/*mongoose.connect(DB,function(err,db){
    if(err){
        return err;
    }else{
        console.log('successfully connected to ' +DB);


    }

});*/
app.set('views',__dirname+'/client/views');
app.set('view engine','ejs');
app.engine('html',require('ejs').renderFile)
app.use(express.static(path.join( __dirname,'/client')));

app.listen(PORT,function () {
   //color changing
    console.log('\x1b[35m', 'listening on port: '+PORT ,'\x1b[0m');
});