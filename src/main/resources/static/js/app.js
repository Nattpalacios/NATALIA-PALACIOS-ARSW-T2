document.addEventListener('DOMContentLoaded', function () {
  if (document.querySelectorAll('#map').length > 0)
  {
    if (document.querySelector('html').lang)
      lang = document.querySelector('html').lang;
    else
      lang = 'en';

    var js_file = document.createElement('script');
    js_file.type = 'text/javascript';
    js_file.src = 'https://maps.googleapis.com/maps/api/js?callback=initMap&signed_in=true&language=' + lang;
    document.getElementsByTagName('head')[0].appendChild(js_file);
  }
});

var map;

function initMap()
{
  map = new google.maps.Map(document.getElementById('map'), {
    center: {lat: -34.397, lng: 150.644},
    zoom: 8
  });

}

var markers;
var bounds;

function plotMarkers(m)
{
  initMap();
  markers = [];
  bounds = new google.maps.LatLngBounds();

  m.forEach(function (marker) {
    var position = new google.maps.LatLng(marker.latlng[0], marker.latlng[1]);

    markers.push(
      new google.maps.Marker({
        position: position,
        map: map,
        animation: google.maps.Animation.DROP
      })
    );

    bounds.extend(position);
  });

  map.fitBounds(bounds);
}

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
        apiclient.getPos(info.name);
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

    function print(name){
        plotMarkers(name);
    }

    return{
        crearTabla:crearTabla,
        tablaByName:tablaByName,
        infTabla:infTabla,
        print:print
    }

})();