
function compliment(){
    return "hello world";
}

var urls = (function () {
    //private methods
    var url;

    function initUrl(host, a){
        url = 'http://'+host+'/'+a
    }

    return {
        school: function (a, b) {
            initUrl('utah.edu', a+'/'+b);
            return url;
        },

        work: function (a) {
            initUrl('kuali.co', a);
            return url
        },

        home: function (kids) {
            var concat = '';
            for (var i = 0, len = kids.length; i < len; i++) {
                concat += kids[i]+'/';
            }
            initUrl('lds.org', concat.trim());
            return url;
        }
    };
}());