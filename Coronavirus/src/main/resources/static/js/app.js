var app = (function(){

    function tablaByName(paises){

    }

    function crearTabla(countries){
        $('#covid tbody').empty();
        countries.map(function(element){
            var onclick = 'apiclient.countryByName("'+element.name+'")';
            var markup = "<tr> <td>"+ element.name+"</td> <td>"+ element.muertos+"</td> <td>"+ element.infectados+"</td> <td>"+element.curados+"</td> <td><input type='button' class='show' value='Open'onclick="+onclick+"></input></td></tr>";
            $("#info").append(markup)
        })
    }

})();