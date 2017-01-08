var express = require('express');
var router = express.Router();
var Model = require('../models/model.js')

router.get('/human',function (req,res) {
    Model.find({},function (err,resources) {
        if(err){
            res.send(err).status(404);
        }else{
            res.send(resources).status(200);
        }
    })
});


router.post('/human',function (req,res) {
    var human = new Model(req.body);
    human.save(function (err,resource) {
        if(err){
            res.send(err).status(501);
        }else{
            res.json(resource).status(201);
        }
    })
});

module.exports=router;