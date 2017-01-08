var express = require('express');
var router = express.Router();

var mongo = require('mongodb'),
    Server = mongo.Server,
    Db = mongo.Db;
var server = new Server('127.0.0.1', 27017, {
    auto_reconnect: true
});
var db = new Db('MEAN', server);
var onErr = function (err) {
   // db.close();
    console.log(err);

};

var NEWS_COLLECTION =null;

db.open(function (err, db) {
    if (!err) {
        db.collection('NEWSFULL', function (err, collection) {
            if (!err) {
                NEWS_COLLECTION = collection;

            } else {
                onErr(err);
            }
        }); //end db.collection
    } else {
        onErr(err);
    }
}); // end db.open

router.get('/newsbyid', function (req, res) {
    console.log(req.query.slug);
    NEWS_COLLECTION.find({'MetaSlug':req.query.slug}).toArray(function (err, docs) {
        if (!err) {
            // db.close();
            var intCount = docs.length;
            res.send(JSON.stringify(docs));
        } else {
            onErr(err);
        }
    }); //end collection.find

});

router.get('/all', function (req, res) {

    NEWS_COLLECTION.find({}).limit(100).toArray(function (err, docs) {
        if (!err) {
           // db.close();
            var intCount = docs.length;
            res.send(JSON.stringify(docs));
        } else {
            onErr(err);
        }
    }); //end collection.find

});

module.exports = router;


