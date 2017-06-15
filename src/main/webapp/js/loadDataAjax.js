$(document).ready(function () {
    $.ajax({
        url: "https://api.opendota.com/api/heroStats",
        type: 'get',
        dataType: 'json',
        success: function (data) {
            for (var index = 0; index < data.length; index++) {
                $("#firstHero").append("<option value='" + data[index].id + "' data-content='<img src=\"https://api.opendota.com" + data[index].icon + "\">  " + data[index].localized_name + "'></option>");
                $("#secondHero").append("<option value='" + data[index].id + "' data-content='<img src=\"https://api.opendota.com" + data[index].icon + "\">  " + data[index].localized_name + "'></option>");

            }

            $("#firstHero").bind("change", function () {
                $("#secondHero").empty();

                var heroId = parseInt($("#firstHero option:selected").val());
                $("#secondHero").append("<option selected disabled> Choose hero </option>");
                for (var index = 0; index < data.length; index++) {
                     if (parseInt(data[index].id) !== heroId) {
                         $("#secondHero").append("<option value='" + data[index].id + "' data-content='<img src=\"https://api.opendota.com" + data[index].icon + "\">  " + data[index].localized_name + "'></option>");
                     }
                 }
                $("#secondHero").selectpicker("refresh");
            });
            $("#firstHero").selectpicker("refresh");
            $("#secondHero").selectpicker("refresh");
        }
    });
});