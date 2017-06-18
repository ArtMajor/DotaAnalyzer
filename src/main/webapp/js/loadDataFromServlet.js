var i = "";
jQuery.extend({
    getValues: function () {
        var result = null;
        $.ajax({
            url: "https://api.opendota.com/api/heroStats",
            type: 'get',
            async: false,
            dataType: 'json',
            success: function (data) {
                result = data;
            },
            error: function () {
                console.log("error")
            }
        });
        return result;
    }
});
function randomInteger(min, max) {
    var rand = min - 0.5 + Math.random() * (max - min + 1)
    rand = Math.round(rand);
    return rand;
}
function fillHero(data) {
    for (var i = 0; i < data.length; i++) {
        $(".hero-container").append("<div class='hero'>" +
            "<div class='hero-img'><i class=\"glyphicon glyphicon-ok\"></i>" +
            "<img src=\"https://api.opendota.com" + data[i].img + "\">" +
            "</div>" +
            "<div class='hero-name'>" +
            "<p class='h-name'>" + data[i].localized_name + "</p>" +
            "</div>" +
            "<input type='hidden' class='hero-id' value='" + i + "'>" +
            "</div>");
    }
}
function fillChoseHero(index, data) {
    if(!$(".chose-hero-container img").is('#'+index)) {
        $(".chose-hero-container").append("<img class='hero-image' id=\"" + index + "\"src=\"https://api.opendota.com" + data[index].img + "\">");
    }
}
function fillOpponentHeroes(data) {
    $(".opponent-hero-container").empty();
    for (var i = 0; i < 12; i++) {
        var index = randomInteger(20, data.length - 1);
        $(".opponent-hero-container").append("<div class='hero'>" +
            "<div class='hero-img'><i class=\"glyphicon glyphicon-ok\"></i>" +
            "<img src=\"https://api.opendota.com" + data[index].img + "\">" +
            "</div>" +
            "<div class='hero-name'>" +
            "<p class='h-name'>" + data[index].localized_name + "</p>" +
            "</div>" +
            "</div>");
    }
}
function deleteChoseHero(id) {
    $(".chose-hero-container").find("img[id='"+id+"']").remove();
}
function getHeroID(element) {
   return element.parent().find(".hero-id").val();
}
function showButton() {
    if(!$(".chose-hero-container").is(':empty')) {
        $(".button-block > button").css({"visibility" : "visible"});
    }
}
function hideButton() {
    $(".button-block > button").css({"visibility" : "hidden"});
}
$(document).ready(function () {

    var data = $.getValues();
    fillHero(data);

});

var count = 0;
$(document).on("click", ".hero-img", function () {
    var heroId = parseInt(getHeroID($(this)));
    if(count < 5 && !$(this).hasClass("chose")) {
        $(this).toggleClass("chose");
        $(this).children("i").toggleClass("gliph-visible");
        count++;
        var data = $.getValues();
        fillChoseHero(heroId, data);
        showButton();

    } else if($(this).hasClass("chose")){
        $(this).toggleClass("chose");
        $(this).children("i").toggleClass("gliph-visible");
        count--;
        deleteChoseHero(heroId);
        if(count === 0) {
            hideButton();
        }
    }
});
$(document).on("click", "#analyze", function () {
   var data = $.getValues();
   $(".opponent-panel").css({"visibility": "visible"});
   fillOpponentHeroes(data);
});


