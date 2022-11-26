const tabAnnee = ["1582", "1600", "1789", "1900", "1944", "1997", "2000", "2007", "2019", "2020"];
var ul = document.querySelector("ul");
chaine = "";

function condition (params) {
    return params%4 == 0 && params%100 != 0 || params%400 == 0;
}

tabAnnee.forEach((item, index) => {
    if ( condition ( Number ( item ) ) ) {
        chaine += "<li class='bis'>" + item + " est une année bissextiles</li>";
    } else {
        chaine+= "<li class='non_bis'>" + item + " n'est pas une année bissextiles</li>";
    }
});

ul.innerHTML=chaine;

var bis = document.querySelectorAll(".bis");

for (const iterator of bis) {
    iterator.style.color = "green";
}

var non_bis = document.querySelectorAll(".non_bis");

for (const iterator of non_bis) {
    iterator.style.color = "red";
}