/**
 * Created by Yffan on 08.04.2017.
 */

$(document).ready(function () {

    var productsID = [];
    var recipesID = [];

    window.onunload = unloadPage;
    function unloadPage() {
        productsID = [];
        recipesID = [];
    }

    $('#products_list').sortable({
        connectWith: '#bin_list',
        /*remove: function (event, ui) {
         ui.item.clone().appendTo('#bin_list');
         $(this).sortable('cancel');
         }*/
    });

    $('#bin_list').sortable({
        receive: function (event, ui) {
            var id = $(ui.item).attr('id');
            if ($.inArray(id, productsID) < 0) {
                productsID.push(id);
                //alert(productsID);
                getRecipes();
            }
        }
    });

    function addDeleteButton(id) {
        var listElement = document.getElementById(id);
        var button = document.createElement("button");
        button.setAttribute("type", "button");
        $(button).click(function () {
            $(listElement).remove();
            $(button).remove();
        });
        button.innerHTML = "X";
        listElement.appendChild(button);
    }

    function getRecipes() {
        $.ajax({
            data: {products: productsID},
            traditional: true,
            url: 'receiveRecipe',
            success: function (data) {
                var jsonData = JSON.parse(data);
                var list = document.getElementById('recipe_advised_list');
                for (var i = 0; i < jsonData.length; i++) {
                    var jsonObject = jsonData[i];
                    var recipeId = jsonObject.id;
                    if ($.inArray(recipeId, recipesID) < 0) {
                        recipesID.push(recipeId);
                        var li = document.createElement("li");
                        li.appendChild(document.createTextNode("Name: " + jsonObject.name));
                        li.appendChild(document.createElement("br"));
                        li.appendChild(document.createTextNode("Description: " + jsonObject.description));
                        list.appendChild(li);
                    }
                }
            }
        });
    }
});
