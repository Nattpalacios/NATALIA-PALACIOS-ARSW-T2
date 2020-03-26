var app = (function(){

    function tablaByName(paises){
        $('#tabla tbody').empty();
        paises.map(function(element){
            var markup = "<tr> <td>"+ element.province+"</td> <td>"+element.deaths+"</td> <td>"+element.confirmed+"</td> <td>"+element.recovered+"</td></tr>";
            $("#infoPais").append(markup)
        })
    }

    function infTabla(info){
        $('#infoTabla tbody').empty();

        var markup= "<tr> <td> Num deaths </td> <td>" + info.muertos + "</td> </tr>"
        $("#infoFilas").append(markup)
        var markup= "<tr> <td> Num infected </td> <td>" + info.infectados + "</td> </tr>"
        $("#infoFilas").append(markup)
        var markup= "<tr> <td> Num cured </td> <td>" + info.curados + "</td> </tr>"
        $("#infoFilas").append(markup)

    }

    function crearTabla(countries){
        $('#covid tbody').empty();
        countries.map(function(element){
            var onclick = 'apiclient.countryByName("'+element.name+'")';
            var markup = "<tr> <td>"+ element.name+"</td> <td>"+ element.muertos+"</td> <td>"+ element.infectados+"</td> <td>"+element.curados+"</td> <td><input type='button' class='show' value='Open'onclick="+onclick+"></input></td></tr>";
            $("#info").append(markup)
        })
    }

    return{
        crearTabla:crearTabla,
        tablaByName:tablaByName,
        infTabla:infTabla
    }

})();