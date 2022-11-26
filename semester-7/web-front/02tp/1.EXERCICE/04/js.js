






var n = prompt ( "Nombre de lancé : ", "int" );
const number_int_per_column = 10;
var h2 = document.getElementById("nb");
h2.removeChild(h2.firstChild);
h2.appendChild(document.createTextNode("Lancer du dé " + n + " fois"));

var div = document.getElementById("num");

var issou = new Array(Number(n));
var stats = [0, 0, 0, 0, 0, 0];

function increment(params) {
    stats[params] = stats[params] + 1;
    console.log(params);
    return stats;
}

var index = 0;
var p = document.createElement("p");

for ( iterator of issou) {
    index++;
    iterator = Math.ceil( Math.random() * 6 );
    p.appendChild(document.createTextNode(iterator + " "));
    stats[Number(iterator)-1]++;
}
div.appendChild(p);

var div2 = document.getElementById("stat");
var i = 1;
for (const iterator of stats) {
    var p2 = document.createElement("p");
    var pourc = Math.round(( iterator / n ) * 100);
    p2.appendChild(document.createTextNode("Nombre de " + i + " : " + iterator + " soit " + pourc + "%;"));
    div2.appendChild(p2);
    i++;
}
