var apiclient = (function(){

    function countryByName(name){
        document.getElementById('country').innerHTML = name;
        infoCountry(name);
        axios({
            method :'get',
            url : "/coronavirus/"+ name
        })
        .then(response => app.tablaByName(response.data.data.covid19Stats))
        .catch(error => console.log(error));
    }

    function countries(){
        axios({
            method:'get',
            url: "/coronavirus"
        })
        .then(response => app.crearTabla(response.data))
        .catch(error => console.log(error));
    }

    function getPos(name){
        axios({
            method : 'get',
            url : " https://restcountries-v1.p.rapidapi.com/name/"+ name,
            headers:{
                "x-rapidapi-host": "restcountries-v1.p.rapidapi.com",
                "x-rapidapi-key": "cc65d2a330msha7ea3b2ae24b677p10b31ajsnfc970dcad64d"
            }
        })
        .then(response => app.print(response.data))
         .catch(error => console.log(error));
    }

    function infoCountry(name){
        axios({
            method : 'get',
            url : "/coronavirus/info/"+ name
        })
        .then(response => app.infTabla(response.data))
        .catch(error => console.log(error));
    }

    return{
        countries:countries,
        countryByName:countryByName,
        getPos:getPos,
        infoCountry:infoCountry
    }

})();